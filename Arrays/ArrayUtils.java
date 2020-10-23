package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtils {

	public static void main(String[] args) {
//		System.out.println(find1stOccurenceIfAdjacentValuesDifferby1(
//				new int[] { 2, 3, 2, 3, 4, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1, 2, 1 }, 5));

//		System.out.println(mostVisited(17, new int[] { 16, 8 }));

//		System.out.println(
//				find1stOccurenceIfAdjacentValuesDifferbyK(new int[] { 70, 60, 70, 80, 90, 110, 130 }, 110, 20));
//		System.out.println(firstRepeatingElement(new int[] {2,3,4,4,3,7, 2}));
//		Arrays.stream(UnionOfArrays(new int[] { 2, 2, 2, 3, 3, 4, 7, 8 }, new int[] { 1, 2, 4, 4, 6, 6, 7, 8, 10 }))
//				.forEach(i -> System.out.print(i + ","));

//		Arrays.stream(intersectionOfArrays(new int[] { 2, 3,4, 7, 8, 10, 11 }, new int[] { 1, 2, 4, 6, 7, 8, 10 }))
//		.forEach(i -> System.out.print(i + ","));

//		intersectionOfUnsortedArrays(new int[] { 4, 2, 3, 5, 4, 2, 3 }, new int[] { 9, 1, 7, 2, 4, 2, 1, 2 });
//		System.out.println(maxMultiOf2Num(new int[] { -4, 7, -1, 8, -7, 9 }));

//		Arrays.stream(findSubArrHavingTargetSum(new int[] { 4, 2, 5, 3, 1, 8 }, 4))
//				.forEach(i -> Arrays.stream(i).forEach(j -> System.out.println(j + ",")));

//		findSubArrHavingTargetSum(new int[] { 4, 2, 5, 3, 1, 8 }, 10).stream().forEach(i->System.out.println(i));
//		System.out.println(findSmalllestSubArrLengthHavingTargetSum(new int[] { 3, 2, 5, 5, 10, 3, 2, 5 }, 11));
//		System.out.println(maxSumSubarr(new int[] { -3, 2, -7, 6, -2, 4, 2, -8 }));

//		printMaxOfAllSubArrOfKSize(new int[] { 2, 5, 3, 4, 1, 7, 8, 9, -3, -4, -5, -4 }, 3);

//		printElementsUsingFrequency(Arrays.asList(10, 7, 10, 11, 10, 7, 5, 6, 12, 12, 12));
//		removeDuplicateElementsInSortedArr(new int[] { 1,1, 4, 4, 5, 6,6, 7, 7, 8 });
//		sortSquareArr(new int[] { -4, -3, -1, 1, 4, 5, 6 });
//		findTripletsHavingLesserTargetSum(new int[] { 1, 2, -3, 4, -2 }, 4);

//		System.out.println(closestTripletSumToTarget(new int[] { 2, -3, 4, -2, 3 }, 1));

//		System.out.println(minSubArrLengthToSortArrSorted(new int[] { 1, 2, 3, 5, 4, 12, 13, 8, 15, 18 }));
//		System.out.println(findSubArrHavingMultLessThanTarget1(new int[] { 4, 2, 5, 3, 6 }, 45));
//		System.out.println(containsCycle(new int[] { 1, 1, 2, 1 }));
//		System.out.println(findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
//		System.out.println(isPalindrome(-123321));
//		System.out.println(secondMaxElement(new int[] { 9, 7, 6, 5, 8 }));
//		System.out.println(lengthOfLongestSubstring("dvdf"));

		System.out.println(longestPalindrome("cbbd"));
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0) {
			return -1;
		}

		int res = Integer.MIN_VALUE;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			res = Math.max(res, i - j + 1);
		}

		return res;

	}

	public static String longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return null;
		}

		int res = Integer.MIN_VALUE;
		String resString = null;

		for (int i = 0; i < s.length(); i++) {
			for (int l = i, r = i; l >= 0 && r < s.length();) {
				while (l >= 0 && r < s.length() && isPalindrome(s.substring(l, r+1))) {
					if (r - l + 1 >= res) {
						res = r - l + 1;
						if(r<s.length()) {
							resString = s.substring(l, r+1);
						}
						
					}
					l--;
					r++;
				}
				break;
			}
		}
		return resString;

	}

	private static boolean isPalindrome(String str) {
		if (str.length() == 1) {
			return true;
		}

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean containsCycle(int[] arr) {
		boolean forward = false;
		int n = arr.length;
		int slowIndex = 0;
		int fastIndex = arr[0] > 0 ? arr[0] % n : n + arr[0] % n;

		if (slowIndex == fastIndex) {
			return false;
		}

		forward = arr[0] > 0 ? true : false;

		if (forward) {
			while (slowIndex != fastIndex) {
				if (arr[slowIndex] < 0 || arr[fastIndex] < 0) {
					return false;
				}
				slowIndex = (slowIndex + arr[slowIndex]) % n;
				if (arr[slowIndex] < 0)
					return false;
				fastIndex = (fastIndex + arr[fastIndex]) % n;
				if (arr[fastIndex] < 0) {
					return false;
				}
				fastIndex = (fastIndex + arr[fastIndex]) % n;
				if (arr[fastIndex] < 0) {
					return false;
				}
			}
		} else {
			while (slowIndex != fastIndex) {
				if (arr[slowIndex] > 0 || arr[fastIndex] > 0) {
					return false;
				}
				slowIndex = slowIndex <= 0 ? n + (slowIndex + arr[slowIndex]) % n : (slowIndex + arr[slowIndex]) % n;
				if (arr[slowIndex] > 0)
					return false;
				fastIndex = fastIndex <= 0 ? n + (fastIndex + arr[fastIndex]) % n : (fastIndex + arr[fastIndex]) % n;
				if (arr[fastIndex] > 0)
					return false;
				fastIndex = fastIndex <= 0 ? n + (fastIndex + arr[fastIndex]) % n : (fastIndex + arr[fastIndex]) % n;
				if (arr[fastIndex] > 0)
					return false;
			}
		}

		if (slowIndex == fastIndex) {
			return true;
		}
		return false;
	}

	public static List<List<Integer>> findSubArrHavingMultLessThanTarget1(int[] arr, int target) {
		if (arr.length == 0 || arr == null) {
			return null;
		}

		int mult = 1;
		int start = 0;

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			mult = mult * arr[i];

			while (mult > target) {
				mult = mult / arr[start];
				start++;
			}

			List<Integer> list = new ArrayList<Integer>();
			for (int j = i; j >= start; j--) {
				list.add(0, arr[j]);
				resList.add(new ArrayList<Integer>(list));
			}
		}
		return resList;
	}

	public static List<List<Integer>> findSubArrHavingMultLessThanTarget(int[] arr, int target) {

		if (arr.length == 0 || arr == null) {
			return null;
		}

		int l = 0;
		int r = 1;
		int mult = arr[l] * arr[r];

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		for (; l < r && r < arr.length;) {
			while (mult < target) {
				resList.add(Arrays.asList(l, r));
				r++;
				if (r < arr.length) {
					mult *= arr[r];
				} else {
					break;
				}

			}

			l++;
			mult /= arr[l];

			while (l < r) {
				resList.add(Arrays.asList(l, r));
				l++;
				if (l < arr.length) {
					mult /= arr[l];
				} else {
					break;
				}
			}
			r++;
			if (r < arr.length) {
				mult *= arr[r];
			} else {
				break;
			}
		}

		return resList;

	}

	public static int minSubArrLengthToSortArrSorted(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}

		int l = 0, r = arr.length - 1, i = 0, j = arr.length - 1;

		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		boolean flag1 = false;
		boolean flag2 = false;

		while (i < arr.length - 1 && j >= 0) {
			if (arr[i] > arr[i + 1] && !flag1) {
				l = i;
				flag1 = true;
			}
			i++;

			if (arr[j] < arr[j - 1] && !flag2) {
				r = j - 1;
				flag2 = true;
			}
			j--;
		}

		for (int m = l; m <= r; m++) {
			minVal = Math.min(minVal, arr[m]);
			maxVal = Math.max(maxVal, arr[m]);
		}

		l--;
		r++;

		while (l >= 0 && arr[l] > minVal) {
			l--;
		}

		while (r < arr.length && arr[r] < maxVal) {
			r++;
		}

		return r - l - 1;

	}

	public static int closestTripletSumToTarget(int[] arr, int target) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}

		Arrays.sort(arr);

		int minDiff = Integer.MAX_VALUE;
		int closestSum = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1;
			int r = arr.length - 1;
			while (l < r) {
				while (l < r) {
					int sum = arr[i] + arr[l] + arr[r];

					if (minDiff > Math.abs(target - sum)) {
						minDiff = Math.abs(target - sum);
						closestSum = sum;
					}
					r--;
				}
				l++;
				r = arr.length - 1;
			}

		}

		return closestSum;
	}

	public static List<List<Integer>> findTripletsHavingLesserTargetSum(int[] arr, int target) {
		if (arr.length == 0 || arr == null) {
			return null;
		}

		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int l = i + 1;
			int r = arr.length - 1;
			int rem = target - arr[i];

			while (l < r) {
				while (l < r) {
					if (arr[l] + arr[r] < rem) {
						triplets.add(Arrays.asList(arr[i], arr[l], arr[r]));
						r--;
					} else {
						r--;
					}
				}
				l++;
				r = arr.length - 1;
			}
		}

		return triplets;

	}

	public static double[] sortSquareArr(int[] arr) {
		int l = 0, r = 0, k = 0;
		double[] res = new double[arr.length];

		while (arr[r] < 0) {
			r++;
		}

		l = r > 0 ? r - 1 : 0;

		for (; l >= 0 && r < arr.length;) {
			if (Math.pow(arr[l], 2) > Math.pow(arr[r], 2)) {
				res[k++] = Math.pow(arr[r], 2);
				r++;
			} else if (Math.pow(arr[l], 2) < Math.pow(arr[r], 2)) {
				res[k++] = Math.pow(arr[l], 2);
				l--;
			} else {
				res[k++] = Math.pow(arr[l], 2);
				res[k++] = Math.pow(arr[r], 2);
				l--;
				r++;
			}
		}

		while (r < arr.length) {
			res[k++] = Math.pow(arr[r], 2);
			r++;
		}

		while (l >= 0) {
			res[k++] = Math.pow(arr[l], 2);
			l--;
		}
		return res;
	}

	public static void removeDuplicateElementsInSortedArr(int[] arr) {

		if (arr.length == 0 || arr == null) {
			return;
		}

		int l = 0;
		int r = 0;

		for (int i = 0; i < arr.length && l < arr.length && r < arr.length;) {
			while (arr[l] == arr[r]) {
				r++;
			}
			i++;
			arr[i] = arr[r];
			l = r;
			r++;
		}

		Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
	}

	public static void printElementsUsingFrequency(List<Integer> list) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		list.stream().forEach(i -> {
			map.put(i, map.getOrDefault(i, 0) + 1);
		});

		Collections.sort(list, (a, b) -> {
			int freqA = map.get(a);
			int freqB = map.get(b);

			if (freqA != freqB) {
				return freqB - freqA;
			} else {
				if (freqA == 1)
					return a - b;
				else
					return b - a;
			}
		});

		System.out.println(list);
	}

	public static void printMaxOfAllSubArrOfKSize(int[] arr, int k) {

		if (arr.length == 0 || arr == null) {
			return;
		}

		Deque<Integer> queue = new LinkedList<Integer>();

		int i;
		for (i = 0; i < k; i++) {
			if (queue.isEmpty()) {
				queue.addLast(i);
			} else {
				while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
					queue.removeLast();
				}
				queue.addLast(i);
			}
		}

		int j;

		for (j = i; j < arr.length; j++) {

			System.out.println("Max of Subarr start index " + Integer.toString(j - k) + " end index "
					+ Integer.toString(j - 1) + " is " + arr[queue.peekFirst()]);
			if (queue.contains(j - k)) {
				queue.remove(j - k);
			}
			while (!queue.isEmpty() && arr[queue.peekLast()] < arr[j]) {
				queue.removeLast();
			}
			queue.addLast(j);
		}

		System.out.println("Max of Subarr start index " + Integer.toString(j - k) + " end index "
				+ Integer.toString(j - 1) + " is " + arr[queue.peekFirst()]);

	}

	public static int maxSumSubarr(int[] arr) {

		if (arr.length == 0 || arr == null) {
			return -1;
		}

		int currSum = arr[0];
		int maxSoFar = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currSum = Math.max(currSum + arr[i], arr[i]);
			maxSoFar = Math.max(maxSoFar, currSum);
		}
		return maxSoFar;
	}

	public static int findSmalllestSubArrLengthHavingTargetSum(int[] arr, int target) {

		if (arr.length == 0 || arr == null) {
			return -1;
		}

		int l = 0, r = 0;
		int sum = arr[l];
		int minLength = Integer.MAX_VALUE;

		for (; l < arr.length && r < arr.length;) {
			if (sum == target) {
				minLength = Math.min(minLength, r - l + 1);
				r++;
				if (r < arr.length)
					sum = sum + arr[r] - arr[l];
				l++;
			} else if (sum < target) {
				r++;
				if (r < arr.length)
					sum += arr[r];
			} else {
				sum -= arr[l];
				l++;
			}
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}

	public static List<SubArr> findSubArrHavingTargetSum(int[] arr, int target) {
		int l = 0, r = 0, k = 0;
		int sum = arr[l];
		List<SubArr> resList = new ArrayList<>();
		for (; r < arr.length;) {
			if (sum == target) {
				resList.add(new SubArr(l, r));
				sum = sum - arr[l];
				l++;
				r++;
				if (r < arr.length)
					sum = sum + arr[r];
			} else if (sum > target) {
				sum = sum - arr[l];
				l++;
			} else {
				r++;
				if (r < arr.length)
					sum = sum + arr[r];
			}
		}
		return resList;

	}

	static class SubArr {
		int start;
		int end;

		SubArr(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "SubArr [start=" + start + ", end=" + end + "]";
		}

	}

	public static int maxMultiOf2Num(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secMax = max;
		int min = Integer.MAX_VALUE;
		int secMin = min;

		if (arr[0] < arr[1]) {
			max = arr[1];
			secMax = arr[0];
			min = arr[0];
			secMin = arr[1];
		} else {
			max = arr[0];
			secMax = arr[1];
			min = arr[1];
			secMin = arr[0];
		}

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > secMax && arr[i] < max) {
				secMax = arr[i];
			} else if (arr[i] > max) {
				secMax = max;
				max = arr[i];
			}

			if (arr[i] < min) {
				secMin = min;
				min = arr[i];
			} else if (arr[i] > min && arr[i] < secMin) {
				secMin = arr[i];
			}
		}

		return Math.max(min * secMin, max * secMax);
	}

	public static void intersectionOfUnsortedArrays(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<Integer>();

		Arrays.stream(arr1).forEach(i -> set.add(i));

		Arrays.stream(arr2).forEach(j -> {
			if (set.contains(j)) {
				System.out.println(j);
				set.remove(j);
			}
		});
	}

	public static int[] intersectionOfArrays(int[] arr1, int[] arr2) {
		int[] resArr = new int[arr1.length + arr2.length];
		int i, j, k;

		for (i = 0, j = 0, k = 0; i < arr1.length && j < arr2.length;) {

			while (i != arr1.length - 1 && arr1[i] == arr1[i + 1]) {
				i++;
			}

			while (j != arr2.length - 1 && arr2[j] == arr2[j + 1]) {
				j++;
			}

			if (arr1[i] == arr2[j]) {
				resArr[k] = arr1[i];
				i++;
				j++;
				k++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return resArr;
	}

	public static int[] UnionOfArrays(int[] arr1, int[] arr2) {

		int[] resArr = new int[arr1.length + arr2.length];
		int i, j, k;

		for (i = 0, j = 0, k = 0; i < arr1.length && j < arr2.length;) {

			while (i != arr1.length - 1 && arr1[i] == arr1[i + 1]) {
				i++;
			}

			while (j != arr2.length - 1 && arr2[j] == arr2[j + 1]) {
				j++;
			}

			if (arr1[i] == arr2[j]) {
				resArr[k] = arr1[i];
				i++;
				j++;
				k++;
			} else if (arr1[i] < arr2[j]) {
				resArr[k] = arr1[i];
				i++;
				k++;
			} else {
				resArr[k] = arr2[j];
				j++;
				k++;
			}
		}

		while (i < arr1.length) {
			resArr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < arr2.length) {
			resArr[k] = arr2[j];
			j++;
			k++;
		}

		return resArr;
	}

	public static int find1stOccurenceIfAdjacentValuesDifferby1(int[] arr, int val) {

		for (int i = 0; i < arr.length;) {
			if (arr[i] == val) {
				return i;
			} else {
				i = i + Math.abs(arr[i] - val);
			}
		}
		return -1;
	}

	public static int find1stOccurenceIfAdjacentValuesDifferbyK(int[] arr, int val, int k) {

		for (int i = 0; i < arr.length;) {
			if (arr[i] == val) {
				return i;
			}
			i = i + Math.abs(val - arr[i]) / k;
		}
		return -1;

	}

	public static int firstRepeatingElement(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int res = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (set.contains(arr[i])) {
				res = arr[i];
			} else
				set.add(arr[i]);
		}
		return res;
	}

	public static List<Integer> mostVisited(int n, int[] rounds) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<Integer>();

		int j = 0, k = 0;
		for (int i = 0; i < rounds.length - 1; i++) {
			for (j = rounds[i], k = rounds[i]; j < ((rounds[i] < rounds[i + 1]) ? rounds[i + 1] : rounds[i + 1] + n);) {
				map.put(k, map.getOrDefault(k, 0) + 1);
				j++;
				k++;
				if (j != n) {
					k %= n;
				}
			}
		}

		map.put(k, map.getOrDefault(k, 0) + 1);

		map = map.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b) -> {
			return b - a;
		})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		int max = Integer.MIN_VALUE;
		for (Entry entry : map.entrySet()) {
			if ((int) entry.getValue() > max) {
				max = (int) entry.getValue();
			}
		}

		for (Entry entry : map.entrySet()) {
			if ((int) entry.getValue() == max) {
				list.add((int) entry.getKey());
			}
		}
		list.sort((a, b) -> a - b);
		return list;
	}

	public static double findMaxAverage(int[] nums, int k) {
		if (nums.length == 0) {
			return -1;
		}
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += nums[i];
		}
		maxSum = Math.max(maxSum, currSum);

		for (int r = k, l = 0; r < nums.length;) {
			currSum += nums[r];
			r++;
			currSum -= nums[l];
			l++;
			maxSum = Math.max(maxSum, currSum);
		}
		return (double) maxSum / k;
	}

	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}
		List<Integer> list = new ArrayList<Integer>();

		while (x > 0) {
			list.add(x % 10);
			x = x / 10;
		}

		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static int secondMaxElement(int arr[]) {
		int max = Integer.MIN_VALUE;
		int secMax = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > secMax) {
				secMax = arr[i];
			}

			if (arr[i] > max) {
				secMax = max;
				max = Math.max(max, arr[i]);
			}
		}
		return secMax;
	}
}
