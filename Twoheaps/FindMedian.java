package Twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {

	private static Queue<Integer> maxHeap;
	private static Queue<Integer> minHeap;

	static {
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
	}

	public static void insertNum(int num) {

		if (maxHeap.isEmpty() || maxHeap.peek() > num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else {
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
		}

	}

	public static double[] medianOfSlidingWindow(int[] arr, int k) {

		double[] resArr = new double[arr.length - k + 1];

		for (int i = 0; i < k; i++) {
			insertNum(arr[i]);
		}
		resArr[0] = findMedian();

		for (int r = k, l = 0, j = 1; r < arr.length;) {
			insertNum(arr[r]);
			r++;
			removeNum(arr[l]);
			l++;
			resArr[j] = findMedian();
			j++;
		}

		return resArr;
	}

	private static void removeNum(int num) {
		if (maxHeap.contains(num)) {
			maxHeap.remove(num);
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
		} else {
			minHeap.remove(num);
			if (minHeap.size() + 1 < maxHeap.size())
				minHeap.add(maxHeap.poll());
		}
	}

	public static double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
//		FindMedian findMedian = new FindMedian();
//		findMedian.insertNum(3);
//		findMedian.insertNum(1);
//		findMedian.insertNum(5);
//		findMedian.insertNum(4);
//		findMedian.insertNum(3);
//		findMedian.insertNum(3);

		Arrays.stream(medianOfSlidingWindow(new int[] { -1, 5, 13, 8, 2, 3, 3, 1}, 4))
				.forEach(i -> System.out.print(i + ","));

	}
}
