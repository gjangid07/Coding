package Heap;

import java.util.Arrays;

public class MaxHeap {

	private int[] maxHeap;
	private int lastIndex;

	public MaxHeap() {
		maxHeap = new int[100];
		lastIndex = -1;
	}

	public void addElement(int element) {

		if (lastIndex == -1) {
			lastIndex++;
			maxHeap[lastIndex] = element;
		} else {
			lastIndex++;

			int parentIndex = (lastIndex - 1) / 2;
			int currentIndex = lastIndex;

			if (element < maxHeap[parentIndex]) {
				maxHeap[currentIndex] = element;
			} else {
				while (parentIndex >= 0 && element > maxHeap[parentIndex]) {
					maxHeap[currentIndex] = maxHeap[parentIndex];
					maxHeap[parentIndex] = element;
					currentIndex = parentIndex;

					parentIndex = (parentIndex - 1) / 2;
				}
			}
		}
	}

	public int getMax() {
		return maxHeap[0];
	}

	public int removeMax() {
		if (lastIndex >= 0) {
			int max = maxHeap[0];
			maxHeap[0] = maxHeap[lastIndex];
			maxHeap[lastIndex] = 0;
			lastIndex--;

			maxHeapify(0, maxHeap);
			return max;
		}

		return -1;
	}

	public boolean isHeapified() {
		for (int i = 0; i < lastIndex; i++) {
			if (2 * i + 1 <= lastIndex && 2 * i + 2 <= lastIndex
					&& maxHeap[i] < Math.max(maxHeap[2 * i + 1], maxHeap[2 * i + 2])) {
				return false;
			}
		}
		return true;
	}

	public void heapifyArr(int[] arr) {
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			maxHeapify(i, arr);
		}

		Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));

	}

	private void maxHeapify(int currentIndex, int[] arr) {
		int size = arr.length - 1;
		while (currentIndex <= (arr.length / 2) - 1) {
			if (2 * currentIndex + 2 > size) {
				if (arr[currentIndex] < arr[2 * currentIndex + 1]) {
					int tmp = arr[currentIndex];
					arr[currentIndex] = arr[2 * currentIndex + 1];
					arr[2 * currentIndex + 1] = tmp;
					currentIndex = 2 * currentIndex + 1;
				} else {
					break;
				}
			} else {
				if (arr[currentIndex] < Math.max(arr[2 * currentIndex + 1], 2 * currentIndex + 2)) {
					if (arr[2 * currentIndex + 1] < arr[2 * currentIndex + 2]) {
						int tmp = arr[currentIndex];
						arr[currentIndex] = arr[2 * currentIndex + 2];
						arr[2 * currentIndex + 2] = tmp;
						currentIndex = 2 * currentIndex + 2;
					} else {
						int tmp = arr[currentIndex];
						arr[currentIndex] = arr[2 * currentIndex + 1];
						arr[2 * currentIndex + 1] = tmp;
						currentIndex = 2 * currentIndex + 1;
					}
				} else {
					break;
				}
			}

		}

	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		heap.addElement(15);
		heap.addElement(19);
		heap.addElement(20);

		System.out.println(heap.getMax());

		heap.addElement(21);
		System.out.println(heap.getMax());
		heap.addElement(14);
		heap.addElement(13);
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());
		System.out.println(heap.removeMax());

//		heap.heapifyArr(new int[] { 10, 7, 11, 30, 20, 38, 2, 45 });
	}
}
