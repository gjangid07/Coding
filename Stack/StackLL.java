package Stack;

import LinkedList.LinkedList;
import LinkedList.Node;

public class StackLL {

	LinkedList ll;
	Node head;

	public StackLL() {
		ll = new LinkedList();
	}

	public void push(int value) {
		if (LinkedList.getLength() == 0) {
			head = LinkedList.insertNodeAtFront(null, value);
			return;
		}
		head = LinkedList.insertNodeAtFront(head, value);

	}

	public int pop() {
		if (LinkedList.getLength() == 0) {
			System.out.println("Error: Stack is empty and Can't pop more!");
			return -1;
		}
		int value = head.data;
		head = head.next;
		return value;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

}
