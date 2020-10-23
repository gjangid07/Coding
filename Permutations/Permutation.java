package Permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Permutation {

	public static List<List<Integer>> findPermutations(int[] arr) {

		if (arr.length == 0) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<List<Integer>> permutations = new LinkedList<List<Integer>>();
		permutations.add(new ArrayList<Integer>());

		for (int k = 0; k < arr.length; k++) {
			int n = permutations.size();
			for (int i = 0; i < n; i++) {

				List<Integer> oldPermutation = permutations.poll();

				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
					newPermutation.add(j, arr[k]);

					if (newPermutation.size() == arr.length) {
						result.add(newPermutation);
					}
					permutations.add(newPermutation);
				}
			}
		}

		return result;
	}

	public static Set<String> stringPermutationsByChangingCase(String str) {

		Set<String> resultSet = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(str);
		for (int i = 0; i < str.length(); i++) {
			int n = queue.size();
			while (n > 0) {
				String newStr = queue.poll();
				String midCh = newStr.substring(i, i + 1);
				String newLString = newStr.substring(0, i) + midCh.toLowerCase()
						+ newStr.substring(i + 1, newStr.length());
				String newUString = newStr.substring(0, i) + midCh.toUpperCase()
						+ newStr.substring(i + 1, newStr.length());

				queue.add(newLString);
				queue.add(newUString);

				resultSet.add(newLString);
				resultSet.add(newUString);
				n--;
			}

		}
		return resultSet;
	}

	public static Set<String> balancedParanthesis(int n) {

		Queue<String> queue = new LinkedList<String>();
		queue.add("");

		Set<String> resSet = new HashSet<String>();
		String resString;

		for (int i = 0; i < n; i++) {

			int size = queue.size();

			while (size > 0) {
				String str = "()";
				resString = queue.poll();

				for (int j = 0; j <= resString.length(); j++) {
					String newString = resString.substring(0, j) + str + resString.substring(j, resString.length());
					if (newString.length() == n * 2) {
						resSet.add(newString);
					}
					queue.add(newString);
				}
				size--;
			}

		}
		return resSet;
	}

	public static List<String> UniqueGeneralizedAbbreviations(String str) {
		if (str.length() == 0 || str == null) {
			return null;
		}

		Set<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		Map<Character, Integer> map = new HashMap<>();
		List<String> resList = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		queue.add(str);

		for (int i = 0; i < str.length(); i++) {
			int size = queue.size();

			while (size > 0) {
				String newString = queue.poll();

				String processedString = newString.replace(str.charAt(i),
						Character.forDigit(map.get(str.charAt(i)), 10));
				queue.add(newString);
				queue.add(processedString);
				size--;

				set.add(newString);
				set.add(processedString);
			}
		}

		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			String s = itr.next();
			List<Character> list = new ArrayList<Character>();
			list.add(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i)) && Character.isDigit(list.get(list.size() - 1))) {
					char c = list.get(list.size() - 1);
					list.remove(list.size() - 1);
					list.add(Character.forDigit((s.charAt(i) - '0') + (c - '0'), 10));
				} else {
					list.add(s.charAt(i));
				}
			}
			StringBuilder strB = new StringBuilder();
			list.stream().forEach(i -> strB.append(i));
			resList.add(new String(strB));
		}
		return resList;
	}

	public static List<String> findPermutationsOfString(String str) {

		if (str.length() == 0 || str == null) {
			return null;
		}

		Queue<String> queue = new LinkedList<String>();
		queue.add("");

		List<String> resList = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			int size = queue.size();

			while (size > 0) {
				String newString = queue.poll();

				for (int j = 0; j <= newString.length(); j++) {
					String processedString = newString.substring(0, j) + str.substring(i, i + 1)
							+ newString.substring(j, newString.length());
					if (processedString.length() == str.length()) {
						resList.add(processedString);
					}
					queue.add(processedString);
				}
				size--;
			}
		}
		return resList;
	}

	public static List<Integer> KPermutation(int[] arr) {

		List<Integer> resultList = new ArrayList<Integer>();

		Queue<String> queue = new LinkedList<String>();

		queue.add("");

		for (int j = 0; j < arr.length; j++) {
			int size = queue.size();
			while (size > 0) {
				String str = queue.poll();
				for (int i = 0; i <= str.length(); i++) {
					String newString = null;
					if (str.length() == 0) {
						newString = String.valueOf(arr[j]);
					} else {
						newString = str.substring(0, i) + String.valueOf(arr[j]) + str.substring(i, str.length());
					}

					queue.add(newString);

					if (newString.length() == arr.length) {
						resultList.add(Integer.parseInt(newString));
					}
				}
				size--;
			}

		}
		return resultList;
	}
	
	public static List<List<Integer>> findAllSubsets(int[] arr){
		
		 
		 List<List<Integer>> prevList = new ArrayList<List<Integer>>();
		 List<List<Integer>> currList = new ArrayList<List<Integer>>();
		 prevList.add(new ArrayList<Integer>());
		 
		 for(int i=0;i<arr.length;i++) {
			 for(List<Integer> pList : prevList) {
				 currList.add(new ArrayList<Integer>(pList));
			 }
			 
			 for(List<Integer> pList : prevList) {
				 List<Integer> newList = new ArrayList<Integer>(pList);
				 newList.add(arr[i]);
				 currList.add(newList);
				 
			 }
			 prevList = new ArrayList<List<Integer>>(currList);
			 currList.clear();
			 
		 }
		 System.out.println(prevList.size());
		 return prevList;
	}

	public static void main(String[] args) {
//		System.out.println(findPermutations(new int[] { 1, 2, 3 }));
//		System.out.println(stringPermutationsByChangingCase("ab7c"));
//		System.out.println(balancedParanthesis(6));

//		System.out.println(UniqueGeneralizedAbbreviations("code"));

//		System.out.println(findPermutationsOfString("ABC"));

//		System.out.println(KPermutation(new int[] { 1, 2, 3 }));
		System.out.println(findAllSubsets(new int[] { 2, 3, 4}));
	}

}
