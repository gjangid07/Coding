package Arrays;

import java.sql.Array;
import java.util.Arrays;

public class CountTriplets {

	public static int countTripletsHavingSumEqualToThird(int[] arr) {
		Arrays.sort(arr);
		int count = 0;

		for (int i = arr.length - 1; i >= 2; i--) {
			for (int l = 0, r = i - 1; l < r;) {
				if (arr[l] + arr[r] == arr[i]) {
					if (arr[l] != arr[r]) {
						r--;
					}
					count++;
					l++;
				} else if (arr[l] + arr[r] < arr[i]) {
					l++;
				} else
					r--;
			}
		}
		return count;
	}

	public static int maxContiguosSubArrSum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int windowStart = 0;
		int windowEnd = 1;
		int sum = arr[windowStart];
		int prev = sum;
		boolean flag = true;

		for (; windowStart <= windowEnd && windowEnd < arr.length;) {
			if (sum < prev) {
				prev = sum;
				sum -= arr[windowStart++];
//				flag = false;
			} else {
				prev = sum;
				sum += arr[windowEnd++];
//				flag = true;
			}

			maxSum = Math.max(sum, maxSum);
		}

		return maxSum;
	}

	public static int maxSumSubArr(int[] arr) {
		int maxSubArr = arr[0], maxCurrent = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxCurrent = Math.max(maxCurrent + arr[i], arr[i]);
			if (maxSubArr <= maxCurrent) {
				maxSubArr = maxCurrent;
			}
		}
		return maxSubArr;
	}

	public static void main(String[] args) {
//		System.out.println(countTripletsHavingSumEqualToThird(new int[] { 1, 1, 1, 2, 2 }));
		System.out.println(maxSumSubArr(new int[] { -2, 3, -2, 5, 6, -4, 8 }));
	}
}
