package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

	public static int longestContSubArrHaving1WithK0Replacement(int[] arr, int k) {
		int zeroCount = 0;
		int l, r;
		int resLength = Integer.MIN_VALUE;

		for (l = 0, r = 0; r < arr.length;) {
			if (arr[r] == 0) {
				zeroCount++;
			}
			if (zeroCount <= k) {
				resLength = Math.max(r - l + 1, resLength);

			} else {
				if (arr[l] == 0) {
					zeroCount--;
				}
				l++;
			}
			r++;
		}

//		if (r - l - zeroCount <= k) {
//			resLength++;
//		}
		return resLength;
	}

	public static int longestSubstringWithSameLettersAfterReplacement(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int resLength = Integer.MIN_VALUE;
		int l, r;
		int maxFreq = 0;

		for (l = 0, r = 0; r < str.length();) {
			if (map.size() != 0) {
				maxFreq = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
			}
			if (r - l - maxFreq <= k) {
				map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);
				resLength = Math.max(r - l, resLength);
				r++;
			} else {
				if (map.get(str.charAt(l)) == 1) {
					map.remove(str.charAt(l));
				} else {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) - 1);
				}
				l++;
			}
		}

		maxFreq = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
		if (r - l - maxFreq <= k) {
			resLength = Math.max(r - l, resLength);
		}
		return resLength;
	}

	public static int longestSubstringLengthWithoutRepetation(String str) {
		Set<Character> set = new HashSet<>();
		int res = Integer.MIN_VALUE;

		int l, r;

		for (l = 0, r = 0; r < str.length();) {
			if (!set.contains(str.charAt(r))) {
				set.add(str.charAt(r));
				res = Math.max(r - l + 1, res);
				r++;
			} else {
				set.remove(str.charAt(l));
				l++;
			}
		}
		if (!set.contains(str.charAt(r - 1))) {
			res++;
		}
		return res;
	}

	public static double[] findAverages(int[] arr, int k) {

		int windowStart = 0;
		double windowSum = 0;

		double[] resArr = new double[arr.length - k + 1];

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd >= k - 1) {
				resArr[windowStart] = windowSum / k;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return resArr;
	}

	public static int maxFruitCountOf2Types(char[] fruits) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxFruits = Integer.MIN_VALUE;
		int l, r;

		for (l = 0, r = 0; l <= r && r < fruits.length;) {
			if (map.size() <= 2) {
				maxFruits = Math.max(r - l, maxFruits);
				if (map.get(fruits[r]) == null) {
					map.put(fruits[r], 1);
				} else {
					map.put(fruits[r], map.getOrDefault(fruits[r], 1) + 1);
				}
				r++;
			} else {
				if (map.get(fruits[l]) == 1) {
					map.remove(fruits[l]);
				} else {
					map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
				}
				l++;
			}

		}

		if (map.get(fruits[r - 1]) != null && map.size() <= 2) {
			maxFruits = Math.max(r - l, maxFruits);
		}
		return maxFruits;
	}

	public static int longestSubstringLenWithKDistinctChars(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();

		int resLength = Integer.MIN_VALUE;
		int l, r;

		for (l = 0, r = 0; l <= r && r < str.length();) {

			if (map.size() <= k) {
				resLength = Math.max(r - l, resLength);
				if (map.get(str.charAt(r)) == null) {
					map.put(str.charAt(r), 1);
				} else {
					map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 1) + 1);
				}
				r++;
			} else {
				if (map.get(str.charAt(l)) > 1) {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 1) - 1);
				} else if (map.get(str.charAt(l)) == 1) {
					map.remove(str.charAt(l));
				}
				l++;
			}
		}
		if (map.get(str.charAt(r - 1)) != null && map.size() <= k) {
			resLength = Math.max(r - l, resLength);
		}
		return resLength;
	}

	public static int maxSumSubArr(int[] arr, int k) {
		int windowStart = 0;
		int windowSum = 0;
		int resMAX = Integer.MIN_VALUE;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd >= k - 1) {
				resMAX = Math.max(resMAX, windowSum);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}

		return resMAX;
	}

	public static int findMinSubArray(int S, int[] arr) {
		int windowStart = 0;
		int windowSum = 0;
		int minLength = Integer.MAX_VALUE;

		for (int windowEnd = 0; windowStart <= windowEnd && windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			while (windowSum >= S) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return minLength;
	}

	public static boolean findPermutation(String str, String pattern) {

		Map<Character, Integer> map = new HashMap<>();

		int matched = 0;

		for (Character c : pattern.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int l, r;

		for (l = 0, r = 0; r < str.length();) {
			if (map.containsKey(str.charAt(r))) {
				map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) - 1);

				if (map.get(str.charAt(r)) < 0) {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) + 1);
					matched--;
					l++;
				}

				if (map.get(str.charAt(r)) == 0) {
					matched++;
				}

			}

			if (matched == map.size()) {
				return true;
			}

			if (r - l + 1 > pattern.length()) {
				if (map.containsKey(str.charAt(l))) {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) + 1);
					matched--;
				}
				l++;
			}

			r++;
		}
		return false;
	}

	public static List<Integer> anagramIndices(String str, String pattern) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> mapCopy = new HashMap<Character, Integer>();

		for (Character c : pattern.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		mapCopy.putAll(map);

		int matched = 0;
		List<Integer> resList = new ArrayList<>();

		int l, r;

		for (l = 0, r = 0; r < str.length();) {

			if (matched == map.size()) {
				resList.add(l);
				map = new HashMap<Character, Integer>();
				map.putAll(mapCopy);
				l++;
				r = l;
				matched = 0;
			}

			if (map.containsKey(str.charAt(r))) {
				map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) - 1);

				if (map.get(str.charAt(r)) < 0) {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) + 1);
					matched--;
					l = r;
				}

				if (map.get(str.charAt(r)) == 0) {
					matched++;
				}

			}

			if (r - l + 1 > pattern.length()) {
				if (map.containsKey(str.charAt(l))) {
					map.put(str.charAt(l), map.getOrDefault(str.charAt(l), 0) + 1);
					matched--;
				}
				l++;
			}

			r++;
		}
		
		if (matched == map.size()) {
			resList.add(l);
		}
		return resList;

	}

	public static void main(String[] args) {
//		double[] result = SlidingWindow.findAverages(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
//		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

//		System.out.println("Max Sum of size K: " + SlidingWindow.maxSumSubArr(new int[] { 2, 3, 4, 1, 5 }, 2));
//		System.out.println("findMinSubArray: " + SlidingWindow.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 }));
//		System.out.println(SlidingWindow.longestSubstringLenWithKDistinctChars("cbbebbe", 2));
//		System.out.println(SlidingWindow.maxFruitCountOf2Types(new char[] { 'A', 'B', 'C', 'A', 'C' }));

//		System.out.println(SlidingWindow.longestSubstringLengthWithoutRepetation("bcccabeccbcccc"));
//		System.out.println(SlidingWindow.longestSubstringWithSameLettersAfterReplacement("abccde", 1));
//		System.out.println(longestContSubArrHaving1WithK0Replacement(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
//		System.out.println(findPermutation("abbcb", "abc"));

		System.out.println(anagramIndices("ppqp", "pq"));
	}
}
