package Subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Subsets {

	public static void main(String[] args) {
//		System.out.println(getSubsets(new int[] { 1, 5, 3 }));
		System.out.println(getSubsetsWithDuplicates(new int[] { 1, 3, 3, 5, 5 }));
	}

	public static List<List<Integer>> getSubsets(int[] arr) {
		if (arr.length == 0) {
			return null;
		}

		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		resList.add(new ArrayList<Integer>());

		for (int i = 0; i < arr.length; i++) {

			int size = resList.size();
			for (int j = 0; j < size; j++) {
				List<Integer> l = new ArrayList<Integer>(resList.get(j));
				l.add(arr[i]);
				resList.add(l);
			}
		}
		return resList;
	}

	public static List<List<Integer>> getSubsetsWithDuplicates(int[] arr) {
		if (arr.length == 0) {
			return null;
		}

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		resList.add(new ArrayList<Integer>());

		int prev = arr[0];
		for (int i = 0; i < arr.length; i++) {

			int size = resList.size();

			if (prev != arr[i] && i!=0) {
				for (int j = 0; j < size; j++) {
					List<Integer> newList = new ArrayList<>(resList.get(j));
					newList.add(arr[i]);
					resList.add(newList);
				}
			} else {
				for (int j = size / 2; j < size; j++) {
					List<Integer> newList = new ArrayList<>(resList.get(j));
					newList.add(arr[i]);
					resList.add(newList);
				}
			}

			prev = arr[i];
		}
		return resList;
	}
}
