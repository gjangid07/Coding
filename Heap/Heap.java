package Heap;

public class Heap {

	static int[] maxHeap = new int[100];
	static int lastIndex = -1;

	public static int getMax() {
		heapify();
		int max = maxHeap[0];
		maxHeap[0] = maxHeap[lastIndex];
		maxHeap[lastIndex] = 0;
		lastIndex--;
		return max;
	}

	public static void heapify() {

		while (!isHeapified()) {
			for (int i = 0; i < lastIndex; i++) {
				if (2 * i + 1 <= lastIndex && 2 * i + 2 <= lastIndex
						&& maxHeap[i] < Math.max(maxHeap[2 * i + 1], maxHeap[2 * i + 2])) {
					if (maxHeap[i] < maxHeap[2 * i + 1]) {
						int tmp = maxHeap[i];
						maxHeap[i] = maxHeap[2 * i + 1];
						maxHeap[2 * i + 1] = tmp;
					} else {
						int tmp = maxHeap[i];
						maxHeap[i] = maxHeap[2 * i + 2];
						maxHeap[2 * i + 2] = tmp;
					}
				}
			}
		}
	}

	public static boolean isHeapified() {
		for (int i = 0; i < lastIndex; i++) {
			if (2 * i + 1 <= lastIndex && 2 * i + 2 <= lastIndex
					&& maxHeap[i] < Math.max(maxHeap[2 * i + 1], maxHeap[2 * i + 2])) {
				return false;
			}
		}
		return true;
	}

	public static void addElement(int element) {
		lastIndex++;
		maxHeap[lastIndex] = element;
	}

	public static void main(String[] args) {

		addElement(15);
		addElement(11);
		addElement(10);
		addElement(12);
		System.out.println(getMax());
		addElement(9);
		addElement(19);
		System.out.println(getMax());
		addElement(18);
		addElement(2);
		System.out.println(getMax());

//		System.out.println(getMax());
//		System.out.println(getMax());
//		System.out.println(getMax());
//		System.out.println(getMax());
//		System.out.println(getMax());
//		System.out.println(getMax());

	}
}
