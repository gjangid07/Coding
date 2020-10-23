package Queue;

import java.lang.reflect.Array;

public class Queue<T> {

	int capacity;
	T[] queue;
	int front;
	int rear;

	public Queue(Class clazz, int c) {
		capacity = c;
		front = -1;
		rear = -1;
		queue = (T[]) Array.newInstance(clazz, c);
	}

	public void enqueue(T t) {
		if (isEmpty()) {
			front = rear = 0;
			queue[rear] = t;
			System.out.println("Enqueued: " + t);
			return;
		}

		rear++;
		rear = rear % capacity;

		if (rear == front) {
			System.out.println("Error: Queue is full and Can't enqueue!");
			if (rear == 0) {
				rear = capacity - 1;
			} else
				rear--;
			return;
		}

		queue[rear] = t;
		System.out.println("Enqueued: " + t);
	}

	public T dequeue() {
		T t = null;
		front = front % capacity;

		if (!isEmpty()) {
			if (front == rear) {
				t = queue[front];
				front = rear = -1;
			}else {
				t = queue[front++];
			}
		} else {
			System.out.println("Error: Queue is empty and Can't dequeue!");
		}
		return t;
	}

	public boolean isEmpty() {
		if (rear == -1 && front == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (rear == capacity - 1) {
			return true;
		}
		return false;
	}

}
