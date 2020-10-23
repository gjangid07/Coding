package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TwoPointers {

	public static void main(String[] args) {
//		Arrays.stream(targetSumPair(new int[] { 2, 5, 9, 11 }, 11)).forEach(i -> System.out.print(i + ", "));
//		System.out.println(remDuplicateLength(new int[] { 2, 2, 2, 11 }));
//		System.out.println(removeDuplicateKeyLength(new int[] { 2, 11, 2, 2, 1 }, 2));
//		System.out.println(squaringSortedArr2(new int[] { -2, -1, 0, 2, 3 }));

//		searchTriplets(new int[] { -3, -3, 0, 1, 2, -1, 1, -2 }).stream().forEach(i -> {
//			i.stream().forEach(j -> System.out.print(j + ", "));
//			System.out.println();
//		});

//		System.out.println(tripletSumClosestToTargetSum(new int[] { 1, 0, 1, 1 }, 100));

//		System.out.println(restoreString("art", new int[] { 1, 0, 2 }));
//		System.out.println(buldSwitcher3("101"));
//		System.out.println(searchAllTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
//		System.out.println(subArrProductLessThanTarget(new int[] { 8, 2, 6, 5, 10, 2, 3 }, 70));

//		System.out.println(findSubarrays(new int[] { 8, 2, 6, 5, 10, 2, 3}, 70));
//		sort(new int[] { 2, 2, 0, 1, 2, 0 });
		Arrays.stream(sortArr(new int[] { 2, 2, 0, 1, 2, 1, 0, 1, 2 })).forEach(i -> System.out.print(i + ", "));
	}

	public static void sort(int[] arr) {
		// all elements < low are 0 and all elements > high are 2
		// all elements from >= low < i are 1
		int low = 0, high = arr.length - 1;
		for (int i = 0; i <= high;) {
			if (arr[i] == 0) {
				swap(arr, i, low);
				// increment 'i' and 'low'
				i++;
				low++;
			} else if (arr[i] == 1) {
				i++;
			} else { // the case for arr[i] == 2
				swap(arr, i, high);
				// decrement 'high' only, after the swap the number at index 'i' could be 0, 1
				// or 2
				high--;
			}
			System.out.print("METHOD:" + i + " " + low + " " + high + " ");
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int product = 1, left = 0;
		for (int right = 0; right < arr.length; right++) {
			product *= arr[right];
			while (product >= target && left < arr.length)
				product /= arr[left++];
			// since the product of all numbers from left to right is less than the target
			// therefore,
			// all subarrays from left to right will have a product less than the target
			// too; to avoid
			// duplicates, we will start with a subarray containing only arr[right] and then
			// extend it
			List<Integer> tempList = new LinkedList<>();
			for (int i = right; i >= left; i--) {
				tempList.add(0, arr[i]);
				result.add(new ArrayList<>(tempList));
			}
		}
		return result;
	}

	public static Set<List<Integer>> subArrProductLessThanTarget(int[] arr, int target) {
		Set<List<Integer>> resList = new HashSet<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			int firstElement = arr[i];
			List<Integer> list = new ArrayList<Integer>();
//			List<Integer> copyList = new ArrayList<Integer>();
			int product = 0;
			if (firstElement < target) {
				list.add(firstElement);
				resList.add(list);
				list = new ArrayList<Integer>(list);
				product = firstElement;
			}
			for (int l = i, r = i + 1; l < r && r < arr.length;) {
				product = product * arr[r];
				if (product < target) {
					list.add(arr[r]);
					resList.add(list);
					list = new ArrayList<Integer>(list);
					r++;
				} else {
					break;
				}

			}
		}
		return resList;
	}

	public static List<List<Integer>> searchAllTriplets(int[] arr, int target) {
		Arrays.sort(arr);

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			int firstElement = arr[i];
			for (int l = i + 1; l < arr.length - 1;) {
				for (int m = l, n = arr.length - 1; m < n;) {
					if (firstElement + arr[m] + arr[n] < target) {
						List<Integer> newList = new ArrayList<>();
						newList.add(firstElement);
						newList.add(arr[m]);
						newList.add(arr[n]);
						resList.add(newList);
					}
					n--;
				}
				l++;
			}
		}
		return resList;
	}

	public static int searchTriplets(int[] arr, int target) {
		Arrays.sort(arr);

		int resCount = 0;

		for (int i = 0; i < arr.length; i++) {
			int firstElement = arr[i];
			for (int l = i + 1; l < arr.length - 1;) {
				for (int m = l, n = arr.length - 1; m < n;) {
					if (firstElement + arr[m] + arr[n] < target) {
						resCount = resCount + (n - m);
						break;
					}
					n--;
				}
				l++;
			}
		}
		return resCount;
	}

	public static int tripletSumClosestToTargetSum(int[] inputArr, int target) {
		Arrays.sort(inputArr);

		int minTargetDiff = Integer.MAX_VALUE;
		int minTripletSum = Integer.MAX_VALUE;

		for (int i = 0; i < inputArr.length; i++) {
			int firstElement = inputArr[i];

			for (int l = i + 1, r = inputArr.length - 1; l < r;) {
				int tripletSum = firstElement + inputArr[l] + inputArr[r];
				int targetDiff = Math.abs(tripletSum - target);

				if (targetDiff < minTargetDiff) {
					minTripletSum = tripletSum;
					minTargetDiff = Math.min(Math.abs((minTripletSum) - target), minTargetDiff);
				} else if (targetDiff == minTargetDiff) {
					if (tripletSum < minTripletSum) {
						minTripletSum = tripletSum;
					}
				}
				l++;
			}
		}
		return minTripletSum;
	}

	public static List<List<Integer>> searchTriplets(int[] inputArr) {
		Arrays.sort(inputArr);

		List<List<Integer>> resList = new ArrayList<>();

		for (int i = 0; i < inputArr.length; i++) {
			int fistElement = -1 * inputArr[i];
			for (int l = i + 1, r = inputArr.length - 1; l <= r;) {

				if (inputArr[l] == inputArr[i]) {
					break;
				}

				if (inputArr[l] + inputArr[r] > fistElement) {
					r--;
				} else if (inputArr[l] + inputArr[r] < fistElement) {
					l++;
				} else {
					List<Integer> res = new ArrayList<Integer>();
					res.add(inputArr[i]);
					res.add(inputArr[l]);
					res.add(inputArr[r]);
					resList.add(res);
					break;
				}
			}
		}

		return resList;
	}

	public static double[] squaringSortedArr2(int[] intArr) {
		int i = 0, j = intArr.length - 1;
		double[] resArr = new double[intArr.length];

		for (int k = resArr.length - 1; k >= 0 && i != j; k--) {
			if (Math.pow(intArr[i], 2) > Math.pow(intArr[j], 2)) {
				resArr[k] = Math.pow(intArr[i], 2);
				i++;
			} else if (Math.pow(intArr[i], 2) < Math.pow(intArr[j], 2)) {
				resArr[k] = Math.pow(intArr[j], 2);
				j--;
			} else {
				resArr[k] = Math.pow(intArr[j], 2);
				j--;
			}
		}
		return resArr;
	}

	public static double[] squaringSortedArr(int[] intArr) {
		int i = 0, j = 0;
		double[] resArr = new double[intArr.length];

		for (; i < intArr.length; i++) {
			if (intArr[i] >= 0) {
				j = i;
				break;
			}
		}

		for (int k = 0; k < resArr.length && i >= 0 && j < intArr.length; k++) {
			if (Math.pow(intArr[i], 2) > Math.pow(intArr[j], 2)) {
				resArr[k] = Math.pow(intArr[j], 2);
				j++;
			} else if (Math.pow(intArr[i], 2) < Math.pow(intArr[j], 2)) {
				resArr[k] = Math.pow(intArr[i], 2);
				i--;
			} else if (Math.pow(intArr[i], 2) == Math.pow(intArr[j], 2)) {
				if (i == j) {
					resArr[k] = Math.pow(intArr[j], 2);
					j++;
					i--;
				} else {
					if (i == 0) {
						resArr[k] = Math.pow(intArr[j], 2);
						j++;
					} else if (j == intArr.length - 1) {
						resArr[k] = Math.pow(intArr[i], 2);
						i--;
					}
				}

			}
		}
		return resArr;
	}

	public static int buldSwitcher3(String str) {
		int flip = 0;
		char status = '0';

		for (char bulb : str.toCharArray()) {
			if (bulb != status) {
				status = bulb;
				flip++;
			}
		}
		return flip;
	}

	public static int buldSwitcher2(String str) {
		int result = 0;
		StringBuilder inputStringB = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			inputStringB.append("0");
		}

		String inputStr = new String(inputStringB);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != inputStr.charAt(i)) {
				inputStringB = new StringBuilder();
				inputStringB.append(inputStr.substring(0, i) + switchString(inputStr.substring(i)));
				inputStr = inputStringB.toString();
				result++;
				if (str.equals(inputStr)) {
					return result;
				}
			}
		}
		return result;
	}

	private static Object switchString(String substring) {
		boolean flag = false;

		if (substring.charAt(0) == '0') {
			flag = true;
		}

		StringBuilder stringB = new StringBuilder();
		for (int i = 0; i < substring.length(); i++) {
			if (flag) {
				stringB = stringB.append('1');
			} else {
				stringB = stringB.append('0');
			}
		}
		return new String(stringB);
	}

	public static int buldSwitcher(String str) {
		int result = 0;
		int[] arr = new int[str.length()];

		int k = 0;
		for (char c : str.toCharArray()) {
			if (c == '0') {
				arr[k] = 0;
			} else {
				arr[k] = 1;
			}
			k++;
		}

		int[] inputArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inputArr[i] = 0;
		}

		for (int j = 0; j < arr.length;) {
			if (inputArr[j] != arr[j]) {
				inputArr = switchBulbs(inputArr, j);
				result++;
				if (equalsArr(inputArr, arr)) {
					return result;
				}
			}
			j++;
		}
		return result;
	}

	private static boolean equalsArr(int[] inputArr, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (inputArr[i] != arr[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] switchBulbs(int[] inputArr, int j) {
		boolean flag = false;

		if (inputArr[j] == 0) {
			flag = true;
		}

		for (int i = j; i < inputArr.length; i++) {
			if (flag) {
				inputArr[i] = 1;
			} else {
				inputArr[i] = 0;
			}
		}
		return inputArr;
	}

	public static String restoreString(String s, int[] indices) {
		char[] resArr = new char[s.length()];
		String resString;

		for (int i = 0; i < indices.length; i++) {
			resArr[indices[i]] = s.charAt(i);
		}

		StringBuilder sb = new StringBuilder();
		for (char c : resArr) {
			sb = sb.append(c);
		}
		return new String(sb);
	}

	public static int[] targetSumPair(int[] arr, int sum) {
		int[] resArr = new int[2];
		int l = 0;
		int r = arr.length - 1;

		for (; l <= r;) {
			if (arr[l] + arr[r] > sum) {
				r--;
			} else if (arr[l] + arr[r] < sum) {
				l++;
			} else {
				resArr[0] = l;
				resArr[1] = r;
				break;
			}
		}
		return resArr;
	}

	public static int remDuplicateLength(int[] arr) {
		int i = 0;
		int j = 0;

		for (; j < arr.length;) {
			if (arr[i] != arr[j]) {
				arr[i + 1] = arr[j];
				i = i + 1;
			}
			j++;
		}
		return i + 1;
	}

	public static int removeDuplicateKeyLength(int[] arr, int k) {
		int i = 0;
		int j = 0;

		for (; j < arr.length;) {
			if (arr[j] != k) {
				arr[i] = arr[j];
				i = i + 1;
			}
			j++;
		}
		return i;
	}

	public static int[] sortArr(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		for (int i = 0; i < high;) {
			if (arr[i] == 0) {
				swap(i, low, arr);
				low++;
				i++;
			} else if (arr[i] == 1) {
				i++;
			} else {
				swap(i, high, arr);
				high--;
			}
		}
		return arr;
	}

	private static void swap(int i, int j, int[] arr) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;

	}

}
