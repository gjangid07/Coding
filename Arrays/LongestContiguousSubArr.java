package Arrays;

public class LongestContiguousSubArr {

	public static void main(String[] args) {
		System.out.println(LongestContiguousSubArr(new int[] { -3, -4, 4, -1, -2, 1, 5, -3 }));
	}

	public static int LongestContiguousSubArr(int[] arr) {
		int current_max = arr[0];

		int max_so_far = Integer.MIN_VALUE;
		
		max_so_far = Math.max(max_so_far, current_max);

		for (int i = 1; i < arr.length; i++) {
			current_max = Math.max(current_max + arr[i], arr[i]);
			max_so_far = Math.max(max_so_far, current_max);
		}
		return max_so_far;
	}
}
