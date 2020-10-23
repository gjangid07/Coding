package Sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 7, 4, 3, 2, 9, 8 };
		mergeSort(arr);
		System.out.println(arr);
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {

		if (l < r) {
			int mid = l + (r - l) / 2;

			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);

			mergeSort(arr, l, mid, r);
		}
	}

	public static void mergeSort(int[] arr, int l, int mid, int r) {

		int[] left = new int[mid + 1 - l];
		int[] right = new int[r - mid];

		for (int i = 0; i < left.length; i++) {
			left[i] = arr[l + i];
		}

		for (int i = 0; i < right.length; i++) {
			right[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = 0;
		for (i = 0, j = 0, k = 0; i < left.length && j < right.length;) {
			if (left[i] < right[j]) {
				arr[l + k] = left[i];
				i++;
			} else {
				arr[l + k] = right[j];
				j++;
			}
				
			k++;
		}

		while (i < left.length) {
			arr[l + k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			arr[l + k] = right[j];
			j++;
			k++;
		}

	}

}
