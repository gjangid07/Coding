package DP;

public class DP {

	public static int fibonacciTopDown(int n, int[] arr) {
		if (n < 2) {
			return 1;
		}

		if (arr[n] == 0) {
			arr[n] = fibonacciTopDown(n - 1, arr) + fibonacciTopDown(n - 2, arr);
		}

		return arr[n];
	}

	public static int fibonacciBottomUp(int n, int[] arr) {
		if (n < 2) {
			return 1;
		}

		for (int i = 2; i <= n; i++) {
			arr[i] = fibonacciBottomUp(i - 1, arr) + fibonacciBottomUp(i - 2, arr);
		}
		return arr[n];
	}

	public static int countOfNumberOfSteps(int[] arr, int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (arr[n] == 0) {
			arr[n] = countOfNumberOfSteps(arr, n - 1) + countOfNumberOfSteps(arr, n - 2)
					+ countOfNumberOfSteps(arr, n - 3);
		}
		return arr[n];
	}

	public static int minJumpsToReachN(int[] arr, int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1 || n == 2 || n == 3) {
			return arr[n] = 1;
		}

		if (arr[n] == 0) {
			arr[n] = 1 + Math.min(Math.min(minJumpsToReachN(arr, n - 1), minJumpsToReachN(arr, n - 2)),
					minJumpsToReachN(arr, n - 3));

		}
		return arr[n];
	}

	public static int longestIncreasingSubsequence(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		int resLength = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int prevVal = arr[i];
			int count =0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= prevVal) {
					count++;
					prevVal = arr[j];
					resLength = Math.max(resLength, count+1);
				}
			}
		}
		return resLength;
	}
	
	public static int longestSubsequence(int[] arr) {
		
		if(arr==null || arr.length==0) {
			return -1;
		}
		
		int[] lis = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			lis[i]=1;
		}
		int maxSubseq = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				if(arr[i]>arr[j] && lis[j]+1>lis[i]) {
					lis[i]=lis[j]+1;
					maxSubseq = Math.max(maxSubseq, lis[i]);
				}
			}
		}
		return maxSubseq;
	}

	public static void main(String[] args) {
		int[] arr = new int[8];
//		System.out.println(fibonacciTopDown(5, arr));
//		System.out.println(countOfNumberOfSteps(arr, 5));
//		System.out.println(minJumpsToReachN(arr, 7));
//		System.out.println(longestIncreasingSubsequence(new int[] { 7, 1, 4, 8, 11, 2, 14,15, 3 }));
		System.out.println(longestSubsequence(new int[] {7, 1, 4, 8, 11, 2, 14, 15, 3}));
	}
}
