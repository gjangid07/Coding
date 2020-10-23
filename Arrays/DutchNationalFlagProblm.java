package Arrays;

public class DutchNationalFlagProblm {

	public static void main(String[] args) {
		sort012(new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
	}

	public static int[] sort012(int[] arr) {
		int l = 0;
		int r = arr.length - 1;

		for (int i = 0; i <= r;) {
			if (arr[i] == 0) {
				swap(arr, l, i);
				i++;
				l++;
			} else if (arr[i] == 1) {
				i++;
			} else if (arr[i] == 2) {
				if (arr[r] != 2) {
					swap(arr, r, i);
				}
				r--;
			}
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {

		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
