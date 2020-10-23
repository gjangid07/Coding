package Arrays;

public class Search {

	public static int binarySearch(int[] arr, int k) {
		return binarySearch(arr, k, 0, arr.length - 1);
	}

	private static int binarySearch(int[] arr, int k, int start, int end) {
		
		if(arr[start]>k || arr[end]<k) {
			return -1;
		}

		int mid = (end - start) / 2 + start;


		if (arr[mid] == k) {
			return mid;
		} else if (k < arr[mid]) {
			return binarySearch(arr, k, start, mid);
		} else if (k > arr[mid]) {
			return binarySearch(arr, k, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 12, 18, 26, 28, 32, 99 }, 320));
	}
}
