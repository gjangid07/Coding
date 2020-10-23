package CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {

	public static void main(String[] args) {
//		Arrays.stream(cyclicSort(new int[] { 1, 5, 6, 4, 3, 2 })).forEach(i -> System.out.print(i + ","));
//		System.out.println(findMissingNumber(new int[] { 8, 6, 5, 4, 3, 2, 1, 0 }));
//		Arrays.stream(findAllDuplicates(new int[] { 5, 4, 7, 2, 3, 5, 3 })).forEach(i -> System.out.print(i + ","));
		Arrays.stream(findKMissingPositiveNumbers(new int[] {-2, -3, 4}, 5)).forEach(i -> System.out.print(i + ","));
	}

	public static int[] findKMissingPositiveNumbers(int[] arr, int k) {
		int[] res = new int[k];
		int n = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		int i, j, l;
		for (i = 0; i < arr.length; i++) {
			while (i != arr[i] - 1 && arr[i]>0 && arr[i]<=n && arr[i] != arr[arr[i] - 1]) {
				swapNew1(i, arr[i] - 1, arr); 
			}
		}

		for (i = 0, j = 0, l = 0; i < arr.length; i++) {
			if (i != arr[i] - 1) {
				res[l] = i + 1;
				l++;
				list.add(arr[i]);
			}
		}
		n += 1;

		while (l < k) {
			if (!list.contains(n)) {
				res[l] = n;
				l++;
			}
			n += 1;
		}
		return res;
	}

	public static int[] cyclicSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i + 1) {
				swap(i, arr);
			}
		}
		return arr;
	}

	public static int[] findAllMissingNumbers(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			while (i + 1 != arr[i] && arr[i] != arr[arr[i] - 1]) {
				swapNew(i, arr);
			}
		}

		int res[] = new int[arr.length];

		for (int i = 0, k = 0; i < arr.length; i++) {
			if (i != arr[i] - 1) {
				res[k] = i + 1;
				k++;
			}
		}
		return res;
	}

	public static int[] findAllDuplicates(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0, k = 0; i < arr.length; i++) {
			while (i != arr[i] - 1) {
				if (arr[i] == arr[arr[i] - 1]) {
					res[k] = arr[i];
					k++;
					break;
				} else {
					swapNew1(i, arr[i] - 1, arr);
				}
			}
		}
		return res;
	}

	private static void swapNew1(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int findMissingNumber(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			while (arr[i] != i && arr[i] != n) {
				swapElements(i, arr);
			}
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] != i) {
				return i;
			}
		}
		return n;
	}

	private static void swapElements(int i, int[] arr) {

		int j = arr[i];
		arr[i] = arr[j];
		arr[j] = j;
	}

	private static void swap(int i, int[] arr) {
		int j = arr[i] - 1;
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void swapNew(int i, int[] arr) {
		int j = arr[i];
		int tmp = arr[j - 1];
//		arr[i] = arr[arr[i]-1];
		arr[j - 1] = arr[i];
		arr[i] = tmp;
	}
}
