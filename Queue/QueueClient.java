package Queue;

import LinkedList.LinkedList;

public class QueueClient {

	public static void main(String[] args) {
		QueueLL q = new QueueLL();
		
		q.dequeue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		
		
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(10);
		q.enqueue(9);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		q.enqueue(11);
		q.enqueue(21);
		q.enqueue(31);
		q.enqueue(41);
		q.enqueue(51);
		q.enqueue(61);
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
//		while(!q.isEmpty()) {
//			System.out.println("Dequeued: "+q.dequeue());
//		}
	}
}
