package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
//		System.out.println(OrderAgnosticBinarySearch(new int[] { 10, 6, 4 }, 4));
//		System.out.println(ceilingOfKey(new int[] { 1, 3, 8, 10, 15 }, 11));
//		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h', 'i', 'k', 'm' }, 'm'));
//		Arrays.stream(numberRange(new int[] { 4, 6, 6, 6, 9 }, 6)).forEach(i -> System.out.print(i + ","));

//		System.out.println(Math.log(28)/Math.log(2));

//		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
//		System.out.println(searchInInfiniteArray(reader, 30));

//		System.out.println(minDiffElement(new int[] { 4, 6, 10 }, 17));

//		System.out.println(BitonicArrayMax(new int[] { 10, 9, 8 }));

//		System.out.println(searchBitonicArray(new int[] { 10, 9, 8 }, 10));

		System.out.println(searchInRotatedArray(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	}

	public static int OrderAgnosticBinarySearch(int[] arr, int key) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}

		if (arr[0] < arr[arr.length - 1]) {
			return binarySearchAsc(arr, 0, arr.length - 1, key);
		} else {
			return binarySearchDesc(arr, 0, arr.length - 1, key);
		}
	}

	private static int binarySearchDesc(int[] arr, int start, int end, int key) {

		if (end < start) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (key < arr[mid]) {
			return binarySearchDesc(arr, mid + 1, end, key);
		} else {
			return binarySearchDesc(arr, start, mid - 1, key);
		}
	}

	private static int binarySearchAsc(int[] arr, int start, int end, int key) {

		if (end < start) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (key > arr[mid]) {
			return binarySearchAsc(arr, mid + 1, end, key);
		} else {
			return binarySearchAsc(arr, start, mid - 1, key);
		}
	}

	public static int ceilingOfKey(int[] arr, int key) {

		if (arr.length == 0 || arr == null) {
			return -1;
		}

		if (key < arr[0]) {
			return 0;
		}

		if (key > arr[arr.length - 1]) {
			return -1;
		}

		return ceilingOfKey(arr, 0, arr.length - 1, key);
	}

	private static int ceilingOfKey(int[] arr, int start, int end, int key) {

		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (key > arr[mid]) {
			if (end == mid + 1 && key < arr[end]) {
				return end;
			} else {
				return ceilingOfKey(arr, mid, end, key);
			}
		} else {

			return ceilingOfKey(arr, start, mid, key);

		}
	}

	public static char searchNextLetter(char[] letters, char key) {
		if (letters.length == 0 || letters == null) {
			return (Character) null;
		}

		if (key < letters[0] || key >= letters[letters.length - 1]) {
			return letters[0];
		}

		return searchNextLetter(letters, key, 0, letters.length - 1);
	}

	private static char searchNextLetter(char[] letters, char key, int start, int end) {

		int mid = start + (end - start) / 2;

		if (letters[mid] == key) {
			return letters[mid + 1];
		} else if (letters[mid] > key) {
			return searchNextLetter(letters, key, start, mid);
		} else {
			if (key < letters[mid + 1] && mid + 1 == end) {
				return letters[mid + 1];
			}
			return searchNextLetter(letters, key, mid, end);
		}
	}

	public static int[] numberRange(int[] arr, int key) {
		if (arr.length == 0 || arr == null) {
			return new int[] { -1, -1 };
		}

		return numberRange(arr, key, 0, arr.length - 1);
	}

	private static int[] numberRange(int[] arr, int key, int start, int end) {

		if (end < start) {
			return new int[] { -1, -1 };
		}
		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			int l = mid;
			int r = mid;

			while (arr[l] == key) {
				l--;
			}

			while (arr[r] == key) {
				r++;
			}

			return new int[] { l + 1, r - 1 };

		} else if (arr[mid] > key) {
			return numberRange(arr, key, start, mid - 1);
		} else {
			return numberRange(arr, key, mid + 1, end);
		}
	}

	public static int searchInInfiniteArray(ArrayReader reader, int key) {
		if (reader == null) {
			return -1;
		}
		return searchInInfiniteArray(reader, key, 0, 1);

	}

	private static int searchInInfiniteArray(ArrayReader reader, int key, int start, int end) {

		while (end > 0 && end >= start && reader.get(end) != Integer.MAX_VALUE) {
			int mid = start + (end - start) / 2;
			if (reader.get(mid) == key) {
				return mid;
			} else if (key < reader.get(mid)) {
				return searchInInfiniteArray(reader, key, 0, mid - 1);
			} else {
				if (key > reader.get(end)) {
					int oldEnd = end;
					end = end + (int) Math.pow(2, 1 + (int) (Math.log(end - start + 1) / Math.log(2)));
					start = oldEnd + 1;
					return searchInInfiniteArray(reader, key, start, end);
				}
				return searchInInfiniteArray(reader, key, mid + 1, end);
			}
		}
		return -1;
	}

	public static int minDiffElement(int[] arr, int key) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		return minDiffElement(arr, key, 0, arr.length - 1);
	}

	private static int minDiffElement(int[] arr, int key, int start, int end) {

		if (key > arr[end]) {
			return arr[end];
		}

		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				return arr[mid];
			} else if (arr[mid] > key) {
				if (arr[mid - 1] < key) {
					if (Math.abs(key - arr[mid - 1]) > Math.abs(arr[mid] - key)) {
						return arr[mid];
					} else {
						return arr[mid - 1];
					}

				}
				return minDiffElement(arr, key, start, mid - 1);
			} else {
				if (arr[mid + 1] > key) {
					if (Math.abs(key - arr[mid + 1]) > Math.abs(arr[mid] - key)) {
						return arr[mid];
					} else {
						return arr[mid + 1];
					}
				}
				return minDiffElement(arr, key, mid + 1, end);
			}

		}
		return -1;

	}

	public static int BitonicArrayMax(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		return BitonicArrayMax(arr, 0, arr.length - 1);
	}

	private static int BitonicArrayMax(int[] arr, int start, int end) {

		if (start > end) {
			return -1;
		} else {
			int mid = start + (end - start) / 2;

			if (start == end) {
				if (mid == end || mid == start)
					return arr[mid];
			}

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			}

			if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				return BitonicArrayMax(arr, mid + 1, end);
			}

			if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
				return BitonicArrayMax(arr, start, mid - 1);
			}
		}

		return -1;
	}

	public static int searchBitonicArray(int[] arr, int key) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		return searchBitonicArray(arr, key, 0, arr.length - 1);
	}

	private static int searchBitonicArray(int[] arr, int key, int start, int end) {

		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			if (start == end) {
				return -1;
			}

			if (start == mid) {
				return searchBitonicArray(arr, key, mid + 1, end);
			}

			if (end == mid) {
				return searchBitonicArray(arr, key, start, mid - 1);
			}

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				int left = searchBitonicArray(arr, key, start, mid - 1);
				int right = searchBitonicArray(arr, key, mid + 1, end);

				if (left != -1 || right != -1) {
					if (left != -1) {
						return left;
					} else {
						return right;
					}
				} else {
					return -1;
				}
			} else if (arr[mid + 1] < arr[mid]) {
				if (key > arr[mid]) {
					return searchBitonicArray(arr, key, start, mid - 1);
				} else {
					return searchBitonicArray(arr, key, mid + 1, end);
				}
			} else {
				if (key > arr[mid]) {
					return searchBitonicArray(arr, key, mid + 1, end);
				} else {
					return searchBitonicArray(arr, key, start, mid - 1);
				}
			}
		}
		return -1;
	}

	public static int searchInRotatedArray(int[] arr, int key) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		return searchInRotatedArray(arr, key, 0, arr.length - 1);
	}

	private static int searchInRotatedArray(int[] arr, int key, int start, int end) {

		if (start <= end) {
			if (start == end) {
				if (arr[start] == key) {
					return start;
				} else
					return -1;
			}

			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			if (end == mid) {
				if (arr[end] == key) {
					return end;
				} else {
					return searchInRotatedArray(arr, key, start, mid - 1);
				}
			}

			if (arr[mid] > arr[mid + 1]) {
				if (key < arr[start]) {
					return searchInRotatedArray(arr, key, mid + 1, end);
				} else {
					return searchInRotatedArray(arr, key, start, mid - 1);
				}
			}
			if (key < arr[start]) {
				return searchInRotatedArray(arr, key, mid + 1, end);
			} else

			if (key > arr[start]) {
				if (key < arr[mid]) {
					return searchInRotatedArray(arr, key, start, mid - 1);
				} else {
					return searchInRotatedArray(arr, key, mid + 1, end);
				}

			} else {
				return start;
			}
		}
		return -1;
	}

	public static int specialArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= nums.length - i) {
				if (i == 0 || nums[i - 1] < nums.length - i) {
					return nums.length - i;
				}
			}
		}

		return -1;
	}

}

class ArrayReader {
	int[] arr;

	public ArrayReader(int[] a) {
		arr = a;
	}

	public int get(int index) {
		if (index >= arr.length) {
			return Integer.MAX_VALUE;
		}
		return arr[index];
	}
}
