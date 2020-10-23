package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

class Interval {
	int start;
	int end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Intervals {

	public static Stack<Interval> merge(List<Interval> intervals) {
		intervals.sort((a, b) -> a.start - b.start);

		Stack<Interval> resStack = new Stack<Interval>();

		Interval prevInterval = intervals.get(0);
		resStack.push(prevInterval);

		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			prevInterval = resStack.pop();
			if (prevInterval.end > interval.start) {
				Interval newInterval;
				if (prevInterval.end >= interval.end) {
					newInterval = new Interval(prevInterval.start, prevInterval.end);
				} else {
					newInterval = new Interval(prevInterval.start, interval.end);
				}
				resStack.push(newInterval);
			} else {
				resStack.push(prevInterval);
				resStack.push(interval);
			}

		}
		return resStack;
	}

	public static Stack<Interval> insertInterval(List<Interval> intervals, Interval intrvl) {
		Stack<Interval> resStack = new Stack<Interval>();

		resStack.push(intrvl);

		for (int i = 0; i < intervals.size(); i++) {
			Interval tmpIntrvl = resStack.pop();
			if (tmpIntrvl.start > intervals.get(i).end) {
				resStack.push(intervals.get(i));
				resStack.push(tmpIntrvl);
			} else {
				if (tmpIntrvl.end >= intervals.get(i).end) {
					Interval newInterval = new Interval(Math.min(tmpIntrvl.start, intervals.get(i).start),
							tmpIntrvl.end);
					resStack.push(newInterval);
				} else{
					if(tmpIntrvl.end<intervals.get(i).start) {
						resStack.push(tmpIntrvl);
						resStack.push(intervals.get(i));
						
					}
					Interval newInterval = new Interval(Math.min(tmpIntrvl.start, intervals.get(i).start),
							Math.max(tmpIntrvl.end, intervals.get(i).end));
					resStack.push(newInterval);
				}

			}

		}
		return resStack;
	}

	public static int solution(int[] blocks) {
		// write your code in Java SE 8
//		int min = Integer.MAX_VALUE;
//		int p = 0;
//
//		for (int i = 0; i < blocks.length; i++) {
//			if (blocks[i] < min) {
//				min = blocks[i];
//				p = i;
//			}
//		}
		int maxDistance = Integer.MIN_VALUE;

		for (int p = 0; p < blocks.length; p++) {
			int j = p, k = p;

			if (p > 0) {
				for (int l = p, prevHighest = blocks[p]; l >= 0; l--) {
					if (blocks[l] >= prevHighest) {
						j = l;
						prevHighest = blocks[l];
					} else {
						break;
					}
				}
			}

			for (int r = p, prevHighest = blocks[p]; r < blocks.length; r++) {
				if (blocks[r] >= prevHighest) {
					k = r;
					prevHighest = blocks[r];
				} else {
					break;
				}
			}

			maxDistance = Math.max(maxDistance, k - j + 1);
		}

		return maxDistance;
	}

	public static int removeDuplicates(char[] chars, int[] arr) {
		char prev = '\0';
//		int k = 0;

		int i = 0;
		int index = 0;
		int minCost = 0;
		for (char c : chars) {
			if (prev != c) {
//				chars[k++] = c;
				prev = c;
				index = i;
			} else {
				minCost = minCost + Math.min(arr[index], arr[i]);
				index = i;
			}
			i++;
		}

//		return new String(chars).substring(0, k);
		return minCost;
	}

	public static void main(String[] args) {
//		List<Interval> input = new ArrayList<Interval>();
//		input.add(new Interval(1, 4));
//		input.add(new Interval(2, 5));
//		input.add(new Interval(7, 9));
//		System.out.print("Merged intervals: ");
//		for (Interval interval : Intervals.merge(input))
//			System.out.print("[" + interval.start + "," + interval.end + "] ");
//		System.out.println();
//
//		input = new ArrayList<Interval>();
//		input.add(new Interval(6, 7));
//		input.add(new Interval(2, 4));
//		input.add(new Interval(5, 9));
//		System.out.print("Merged intervals: ");
//		for (Interval interval : Intervals.merge(input))
//			System.out.print("[" + interval.start + "," + interval.end + "] ");
//		System.out.println();
//
//		input = new ArrayList<Interval>();
//		input.add(new Interval(1, 4));
//		input.add(new Interval(2, 6));
//		input.add(new Interval(3, 5));
//		System.out.print("Merged intervals: ");
//		for (Interval interval : Intervals.merge(input))
//			System.out.print("[" + interval.start + "," + interval.end + "] ");
//		System.out.println();

//		String s = "ababab";

//		System.out.println(removeDuplicates(s.toCharArray(), new int[] { 0, 1, 2, 3, 4, 5 }));
//		System.out.println(s);

//		System.out.println(solution(new int[] {1,5,5,2,6}));

		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : Intervals.insertInterval(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : Intervals.insertInterval(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : Intervals.insertInterval(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
