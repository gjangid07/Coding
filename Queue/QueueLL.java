package Queue;

import LinkedList.LinkedList;
import LinkedList.Node;

public class QueueLL {

	LinkedList ll;
	Node front;
	Node rear;

	public QueueLL() {
		front = null;
		rear = null;
	}

	public void enqueue(int value) {
		if (front == null && rear == null) {
			front = LinkedList.insertNodeAtEnd(front, value);
			rear = front;
		} else {
			front = LinkedList.insertNodeAtEnd(front, value);
			rear = rear.next;
		}
		System.out.println("Enqueued: " + value);
		LinkedList.printLinkedList(front);
	}

	public int dequeue() {
		Node tmp = null;
		if (front == null && rear == null) {
			System.out.println("Error: Queue is empty and Can't dequeue!");
			return -1;
		} else {
			if (front != null) {
				tmp = front;
				front = front.next;
				System.out.println("Dequeued: " + tmp.data);
				LinkedList.printLinkedList(front);
				return tmp.data;
			}
		}
		return -1;
	}

}
