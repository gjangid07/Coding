package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DynamicProgramming {

	static int longestCommonSubstringLength = 0;

	public static void main(String[] args) {
//		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
//		System.out.println(longestSubsequwnceLength(new int[] { 7, 1, 4, 8, 11, 2, 14, 3 }));
//		System.out.println(maxSumOfLongestIncreasingSubSequence(new int[] { 7, 1, 4, 8, 11, 2, 14, 3 }));

		String str1 = "abcde";
		String str2 = "edbyx";
		Integer[][] arr = new Integer[str1.length()][str2.length()];
//		System.out.println(longestCommonSubsequenceDynamically("abcde", "edbca"));
//		System.out.println(lcsTopDown(str1, str2, str1.length() - 1, str2.length() - 1, arr));

//		System.out.println(LCSM1(str1.toCharArray(), str2.toCharArray(), str1.length() - 1, str2.length() - 1));

		Set<String> dic = new HashSet<String>();
		dic.addAll(Arrays.asList("apple", "pear", "pie"));
//		System.out.println(completeStringSegmentationInDictionary("abefg", dic));
//		System.out.println(
//				completeStringSegmentationInDictionaryDynamically("applepeer", dic, new HashMap<String, Boolean>()));

//		System.out.println(longestCommonSubstring("dabc", "daec"));

//		System.out.println(lcsubstringBottomUp("dabc", "daec"));

//		System.out.println(longestCommonSubstringDynamically("dabc", "daec"));
//		System.out.println(lcsubstring("dabc",  "daec", 4, 4));
//		System.out.println(noOfClimbingStairs(5, new int[6]));

//		System.out.println(maxSteelingProfit(6, new int[] { 3, 7, 8, 2, 4, 5 }, new int[7]));
//		System.out.println(maxSteelingProfit(6, new int[] { 3, 7, 8, 2, 4, 5}, new int[7]));
//		System.out.println(maxSteelingProfitBottomUp(6, new int[] { 3, 7, 8, 2, 4, 5 }, new int[7]));
//		System.out.println(minCostClimbingStairs(6, new int[] { 3, 7, 8, 2, 4, 5 }, new int[7]));

//		System.out.println(uniquePathsBottomUp(3, 3, new int[4][4]));

//		System.out.println(uniquePathsWithObstacles(2, 2, new int[][] { { 0, 0 }, { 0, 1 } }, new int[2][]));
//		System.out.println(minPathSum(new int[][] { { 1, 5, 3 }, { 4, 7, 8 }, { 9, 2, 6 } }));
//		System.out.println(uniqueBinarySearchTrees(4));
//		System.out.println(maxSubArray(new int[] { 3, -1, 2, 4, 1, -5 }));
//		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
//		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(lengthOfLIS1(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public static int lengthOfLIS1(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;
	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] lis = new int[nums.length];
		int resMaxLis = 1;

		for (int i = 0; i < nums.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i] && lis[j] + 1 > lis[i]) {
					lis[i]++;
				}
			}
			resMaxLis = Math.max(resMaxLis, lis[i]);
		}
		return resMaxLis;
	}

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int[] maxProductArr = new int[nums.length];

		maxProductArr[0] = nums[0];
		int resMaxProd = maxProductArr[0];

		for (int i = 1; i < nums.length; i++) {
			maxProductArr[i] = Math.max(maxProductArr[i - 1] * nums[i], nums[i]);
			resMaxProd = Math.max(resMaxProd, maxProductArr[i]);
		}
		return resMaxProd;
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return -1;
		}

		int min = prices[0];
		int profit = 0;

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				profit = 0;
			} else {
				profit = prices[i] - min;
			}
			maxProfit = Math.max(maxProfit, profit);
		}

		return maxProfit;
	}

	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int[] maxSubArr = new int[nums.length];

		maxSubArr[0] = nums[0];
		int res = maxSubArr[0];

		for (int i = 1; i < nums.length; i++) {
			maxSubArr[i] = Math.max(maxSubArr[i - 1] + nums[i], nums[i]);
			res = Math.max(res, maxSubArr[i]);
		}

		return res;
	}

	public static int uniquePaths(int n, int m, int[][] paths) {

		if (n == 0 || m == 0) {
			return 1;
		}

		if (paths[n][m] == 0) {
			paths[n][m] = uniquePaths(n - 1, m, paths) + uniquePaths(n, m - 1, paths);
		}
		return paths[n][m];
	}

	public static int uniquePathsBottomUp(int n, int m, int[][] paths) {

		for (int i = 0; i <= n; i++) {
			paths[i][0] = 1;
		}

		for (int j = 0; j <= m; j++) {
			paths[0][j] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[n][m];
	}

	public static int uniquePathsWithObstacles(int n, int m, int[][] obstacleGrid, int[][] paths) {

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[i][0] == 0) {
				paths[i][0] = 1;
			} else {
				for (int j = i; j < n; j++) {
					paths[j][0] = 0;
				}
				break;
			}
		}

		for (int j = 0; j < m; j++) {
			if (obstacleGrid[0][j] == 0) {
				paths[0][j] = 1;
			} else {
				for (int i = j; i < m; i++) {
					paths[0][i] = 0;
				}
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0) {
						paths[i][j] = paths[i][j - 1];
					}

					if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 0) {
						paths[i][j] = paths[i - 1][j];
					}

					if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 0) {
						paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
					}
				} else {
					paths[i][j] = 0;
				}

			}
		}
		return paths[n - 1][m - 1];
	}

	public static int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] minPathSum = new int[n][m];

		minPathSum[0][0] = grid[0][0];
		for (int j = 1; j < m; j++) {
			minPathSum[0][j] = grid[0][j] + minPathSum[0][j - 1];
		}

		for (int i = 1; i < n; i++) {
			minPathSum[i][0] = grid[i][0] + minPathSum[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				minPathSum[i][j] = grid[i][j] + Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]);
			}
		}
		return minPathSum[n - 1][m - 1];
	}

	public static int uniqueBinarySearchTrees(int n) {

		int[] dp = new int[n + 1];
		int sum = 0;

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = dp[i] + (dp[j - 1] * dp[i - j]);
			}
		}
		return dp[n];
	}

	public static int noOfClimbingStairs(int n, int[] arr) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (arr[n] == 0) {
			arr[n] = noOfClimbingStairs(n - 1, arr) + noOfClimbingStairs(n - 2, arr);
		}
		return arr[n];
	}

	public static int maxSteelingProfit(int n, int[] houses, int[] maxSteeledProfit) {

		if (n == 0) {
			return maxSteeledProfit[0] = 0;
		}

		if (n == 1) {
			return maxSteeledProfit[1] = houses[0];
		}

		if (n == 2) {
			return maxSteeledProfit[2] = Math.max(houses[0], houses[1]);
		}

		if (maxSteeledProfit[n] == 0) {
			maxSteeledProfit[n] = Math.max(houses[n - 1] + maxSteelingProfit(n - 2, houses, maxSteeledProfit),
					maxSteelingProfit(n - 1, houses, maxSteeledProfit));
		}
		return maxSteeledProfit[n];
	}

	public static int maxSteelingProfitBottomUp(int n, int[] houses, int[] maxSteeledProfit) {
		if (n == 0) {
			return maxSteeledProfit[0] = 0;
		}

		if (n == 1) {
			return maxSteeledProfit[1] = houses[0];
		}

		if (n == 2) {
			return maxSteeledProfit[2] = Math.max(houses[0], houses[1]);
		}
		maxSteeledProfit[0] = 0;
		maxSteeledProfit[1] = houses[0];
		maxSteeledProfit[2] = Math.max(houses[0], houses[1]);
		for (int i = 3; i <= n; i++) {
			maxSteeledProfit[i] = Math.max(houses[i - 1] + maxSteeledProfit[i - 2], maxSteeledProfit[i - 1]);
		}
		return maxSteeledProfit[n];
	}

	public static int minCostClimbingStairs(int n, int[] houses, int[] minCostClimbing) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return houses[0];
		}

		if (n == 2) {
			return houses[0] + houses[1];
		}

		minCostClimbing[0] = 0;
		minCostClimbing[1] = houses[0];
		minCostClimbing[2] = houses[0] + houses[1];
		for (int i = 3; i <= n; i++) {
			minCostClimbing[i] = houses[i - 1] + Math.min(minCostClimbing[i - 1], minCostClimbing[i - 2]);
		}
		return minCostClimbing[n];
	}

	private static int longestCommonSubsequenceDynamically(String str1, String str2) {
		int[][] arr = new int[str1.length()][str2.length()];

		int x = longestCommonSubsequenceDynamically(str1, str2, arr, str1.length() - 1, str2.length() - 1);
		System.out.println(arr);
		return arr[str1.length() - 1][str2.length() - 1] + 1;
	}

	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];
		return Math.min(minCost(cost, dp, n - 1), minCost(cost, dp, n - 2));
	}

	private static int minCost(int[] cost, int[] dp, int i) {

		if (i < 0) {
			return 0;
		}

		if (dp[i] != 0) {
			return dp[i];
		}

		if (i == 0 || i == 1) {
			return cost[i];
		}
		return dp[i] = cost[i] + Math.min(minCost(cost, dp, i - 1), minCost(cost, dp, i - 2));
	}

	public static int longestSubsequwnceLength(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int[] lis = new int[arr.length];

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
					res = Math.max(res, lis[i]);
				}
			}
		}

		return res;
	}

	public static int maxSumOfLongestIncreasingSubSequence(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		int[] lis = new int[arr.length];
		int[] maxSum = new int[arr.length];
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
			maxSum[i] = arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			maxSum[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
						maxSum[i] = Math.max(maxSum[i], maxSum[j] + arr[i]);
						res = Math.max(res, maxSum[i]);
					} else {
						maxSum[i] = Math.max(maxSum[i], arr[j] + arr[i]);
//						maxSum[i] = arr[i];
//						maxSum[i] = arr[j] + maxSum[i];
					}

				}
			}
		}
		return res;
	}

	public static int longestCommonSubsequence(String str1, String str2) {
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return -1;
		}

		int counter = 0;
		if (str1.length() > str2.length()) {
			for (int i = 0; i < str2.length(); i++) {
				for (int j = 0; j < str1.length(); j++) {
					if (str2.charAt(i) == str1.charAt(j)) {
						counter++;
					}
				}
			}
		} else {
			for (int i = 0; i < str1.length(); i++) {
				for (int j = 0; j < str2.length(); j++) {
					if (str1.charAt(i) == str2.charAt(j)) {
						counter++;
					}
				}
			}
		}
		return counter;
	}

	public static int longestCommonSubsequenceDynamically(String str1, String str2, int[][] arr, int n, int m) {

		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return 0;
		}
		if (arr[n][m] == 0) {
			if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {

				arr[n][m] = 1 + longestCommonSubsequenceDynamically(str1.substring(0, str1.length() - 1),
						str2.substring(0, str2.length() - 1), arr, n - 1, m - 1);
			} else {
				arr[n][m] = Math.max(
						longestCommonSubsequenceDynamically(str1.substring(0, str1.length() - 1), str2, arr, n - 1, m),
						longestCommonSubsequenceDynamically(str1, str2.substring(0, str2.length() - 1), arr, n, m - 1));
			}
		}
		return arr[n][m];

	}

	public static int lcsTopDown(String s1, String s2, int n, int m, Integer[][] arr) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (arr[n][m] == null) {
			if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
				arr[n][m] = 1 + lcsTopDown(s1, s2, n - 1, m - 1, arr);
			} else {
				arr[n][m] = Math.max(lcsTopDown(s1, s2, n - 1, m, arr), lcsTopDown(s1, s2, n, m - 1, arr));
			}
		}

		return arr[n][m];
	}

	public static int LCSM1(char[] X, char[] Y, int i, int j) {
		if (i <= 0 || j <= 0)
			return 0;
		if (X[i - 1] == Y[j - 1])
			return 1 + LCSM1(X, Y, i - 1, j - 1);
		else
			return Math.max(LCSM1(X, Y, i, j - 1), LCSM1(X, Y, i - 1, j));

	}

	public static boolean completeStringSegmentationInDictionary(String str, Set<String> dic) {

		int length = str.length();
		int countLength = 0;

		for (int i = 0, j = 1; i < length && j <= length;) {
			if (dic.contains(str.substring(i, j))) {
				countLength = countLength + (j - i);
				i = j;
			}
			j++;
		}
		if (countLength == length) {
			return true;
		}
		return false;

	}

	public static boolean completeStringSegmentationInDictionaryDynamically(String str, Set<String> dic,
			Map<String, Boolean> map) {

		if (str.length() == 0) {
			return false;
		}

		if (map.get(str) == null) {
			for (int i = 0; i < str.length(); i++) {
				if (dic.contains(str.substring(0, i))) {
					if (dic.contains(str.substring(i, str.length())) || str.substring(i, str.length()).length() == 0) {
						return true;
					} else {
						map.put(str.substring(i, str.length()), completeStringSegmentationInDictionaryDynamically(
								str.substring(i, str.length()), dic, map));
					}

					return map.get(str.substring(i, str.length()));
				}

			}
			return false;
		}

		return map.get(str);
	}

	public static int longestCommonSubstring(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();

		int[][] arr = new int[n][m];

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				arr[i][j] = 0;
//			}
//		}

		return longestCommonSubstring(str1, str2, arr, n - 1, m - 1, 0);
	}

	public static int longestCommonSubstring(String str1, String str2, int[][] arr, int n, int m, int count) {

		if (str1.length() == 0 || str2.length() == 0) {
			return count;
		}

		int b = 0;
		int c = 0;

		if (str1.charAt(n) == str2.charAt(m)) {
			count = longestCommonSubstring(str1.substring(0, n), str2.substring(0, m), arr, n - 1, m - 1, count + 1);
		} else {
			b = longestCommonSubstring(str1.substring(0, n), str2, arr, n - 1, m, 0);
			c = longestCommonSubstring(str1, str2.substring(0, m), arr, n, m - 1, 0);

		}
		arr[n][m] = Math.max(count, Math.max(b, c));

		return arr[n][m];
	}

	public static int longestCommonSubstringDynamically(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}

		int a = 0, b = 0;
		if (str1.charAt(0) == str2.charAt(0)) {
			a = 1 + longestCommonSubstringDynamically(str1.substring(1, str1.length()),
					str2.substring(1, str2.length()));
		} else {
			b = Math.max(longestCommonSubstringDynamically(str1.substring(1, str1.length()), str2),
					longestCommonSubstringDynamically(str1, str2.substring(1, str2.length())));
		}
		return Math.max(a, b);

	}

	public static int lcsubstring(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}

		int countOfLCS = 0;
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			countOfLCS = 1 + lcsubstring(s1, s2, n - 1, m - 1);
		}

		int count1 = lcsubstring(s1, s2, n - 1, m);
		int count2 = lcsubstring(s1, s2, n, m - 1);

		return Math.max(countOfLCS, Math.max(count1, count2));
	}

	public static int lcsubstringBottomUp(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int[][] arr = new int[n + 1][m + 1];
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i + 1][j + 1] = 1 + arr[i][j];
					res = Math.max(res, arr[i + 1][j + 1]);
				} else {
					arr[i][j] = 0;
				}

			}
		}

		return res;
	}
}
