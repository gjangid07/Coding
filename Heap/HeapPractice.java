package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class HeapPractice {

	public static void main(String[] args) {
//		System.out.println(KthLargestElement(new int[] { 10, 7, 11, 5, 27, 8, 20, 45 }, 3));
//		System.out.println(KthSmallestElement(new int[] { 10, 7, 11, 5, 27, 8, 20, 45 }, 3));
//		topKLargestElements(new int[] { 10, 7, 11, 5, 27, 30, 38, 20, 45 }, 4);
//		heapSort(new int[] { 10, 7, 11, 5, 27, 30, 38, 20, 45 });
//		topKFrequentElements(new int[] { 8, 10, 7, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8 }, 3);
//		kClosestPoints(Arrays.asList(new Point(3, 4), new Point(1, 3), new Point(1, 2), new Point(5, 1),
//				new Point(8, 9), new Point(2, 4)), 3);
//		System.out.println(costOfConnectingRopes(new int[] { 1, 3, 11, 5, 2 }));

//		KthLargestNumberInStream obj = new KthLargestNumberInStream(new int[] { 3, 1, 5, 12, 2, 11 }, 4);
//		System.out.println(obj.add(6));
//		System.out.println(obj.add(13));
//		System.out.println(obj.add(4));

		Arrays.stream(kClosestNumbersFromX(new int[] { 2, 4, 5, 6, 9}, 3, 10)).forEach(i -> System.out.print(i + ","));

	}

	public static void topKFrequentElements(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		Queue<Entry<Integer, Integer>> minHeap = new PriorityQueue<Entry<Integer, Integer>>(
				(a, b) -> a.getValue() - b.getValue());

		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> itr = set.iterator();
		int i = 0;
		for (; i < k && itr.hasNext(); i++) {
			Entry<Integer, Integer> entry = itr.next();
			minHeap.add(entry);
		}

		while (itr.hasNext()) {
			Entry<Integer, Integer> entry = itr.next();
			if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.add(entry);
			}
		}

		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.poll().getKey() + ",");
		}

	}

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		Queue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
		}

		for (int num : minHeap) {
			System.out.print(num + ",");
		}
		System.out.println()

		;

		int index = 0;
		while (!minHeap.isEmpty()) {
			arr[index++] = minHeap.poll();
		}

		Arrays.stream(arr).forEach(i -> System.out.print(i + ","));
	}

	public static void topKLargestElements(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return;
		}

		Queue<Integer> maxHeap = new PriorityQueue<Integer>();
		int i = 0;
		for (; i < k; i++) {
			maxHeap.add(arr[i]);
		}

		for (int j = i; j < arr.length; j++) {
			if (arr[j] > maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(arr[j]);
			}
		}

		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll());
		}
	}

	public static int KthLargestElement(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>(k);

		int i;
		for (i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int j = i; j < arr.length; j++) {
			if (arr[j] > pq.peek()) {
				pq.poll();
				pq.add(arr[j]);
			}
		}

		return pq.peek();
	}

	public static int KthSmallestElement(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

		int i;
		for (i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int j = i; j < arr.length; j++) {
			if (arr[j] < pq.peek()) {
				pq.poll();
				pq.add(arr[j]);
			}
		}

		return pq.peek();
	}

	public static void kClosestPoints(List<Point> points, int k) {

//		Queue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> b.distance() - a.distance());
//
//		int i=0;
//		for (; i < k; i++) {
//			maxHeap.add(points.get(i));
//		}
//		
//		for(int j=i;j<points.size();j++) {
//			if(points.get(j).distance()<maxHeap.peek().distance()) {
//				maxHeap.poll();
//				maxHeap.add(points.get(j));
//			}
//		}
//		
//		maxHeap.stream().forEach(p -> System.out.print(p.toString() + ","));

		Collections.sort(points);

		points.stream().forEach(i -> System.out.print(i.toString() + ","));

	}

	public static int costOfConnectingRopes(int[] ropes) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		int result = 0;

		for (int i = 0; i < ropes.length; i++) {
			minHeap.add(ropes[i]);
		}

		while (minHeap.size() > 1) {
			int a = minHeap.poll();
			int b = minHeap.poll();

			result += (a + b);

			minHeap.add(a + b);
		}
		return result;
	}

	public static int[] kClosestNumbersFromX(int[] arr, int k, int x) {

		int[] result = new int[k];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Queue<Entry<Integer, Integer>> maxHeap = new PriorityQueue<Entry<Integer, Integer>>(
				(a, b) -> b.getValue() - a.getValue());

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], Math.abs(arr[i] - x));
		}

		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		for (int i = 0; i < k && itr.hasNext(); i++) {
			Entry<Integer, Integer> entry = itr.next();
			maxHeap.add(entry);
		}

		while(itr.hasNext()) {
			Entry<Integer, Integer> entry = itr.next();
			if (entry.getValue() < maxHeap.peek().getValue()) {
				maxHeap.poll();
				maxHeap.add(entry);
			}
		}

		int i = 0;
		while (!maxHeap.isEmpty()) {
			result[i] = maxHeap.poll().getKey();
			i++;
		}
		return result;
	}
}

class KthLargestNumberInStream {

	Queue<Integer> minHeap;

	public KthLargestNumberInStream(int[] inputArr, int k) {
		minHeap = new PriorityQueue<Integer>();

		int i = 0;
		for (; i < k; i++) {
			minHeap.add(inputArr[i]);
		}

		for (int j = i; j < inputArr.length; j++) {
			if (minHeap.peek() < inputArr[j]) {
				minHeap.poll();
				minHeap.add(inputArr[j]);
			}
		}
	}

	public int add(int num) {
		if (num > minHeap.peek()) {
			minHeap.poll();
			minHeap.add(num);
		}
		return minHeap.peek();
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int distance() {
		return this.x * this.x + this.y * this.y;
	}

	@Override
	public int compareTo(Point p) {
		return (this.x * this.x + this.y * this.y) - (p.x * p.x + p.y * p.y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}