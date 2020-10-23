package LinkedList;

import java.util.Random;

public class LinkedListClient {
	public static void main(String[] args) {
//		LinkedList linkedList = new LinkedList();
		Node node = LinkedList.insertNodeAtEnd(null, 1);
		node = LinkedList.insertNodeAtEnd(node, 2);
		node = LinkedList.insertNodeAtEnd(node, 3);
		node = LinkedList.insertNodeAtEnd(node, 4);
		node = LinkedList.insertNodeAtEnd(node, 5);
//		node = LinkedList.insertNodeAtEnd(node, 21);
//		node = LinkedList.insertNodeAtEnd(node, 7);
//		node = LinkedList.insertNodeAtEnd(node, 8);
//		node = LinkedList.insertNodeAtEnd(node, 9);
//		node = LinkedList.insertNodeAtEnd(node, 10);
//		node = LinkedList.insertNodeAtEnd(node, 11);
//		node = LinkedList.insertNodeAtEnd(node, 12);
//		node = LinkedList.insertNodeAtEnd(node, 13);
//		node = LinkedList.insertNodeAtEnd(node, 14);

		Node tmpNode = node;

		while (tmpNode != null) {
			int i = 1 + (int) (Math.random() * LinkedList.length);
			Node newTmpNode = tmpNode;
			while (i > 0 && newTmpNode.next!=null) {
				newTmpNode = newTmpNode.next;
				i--;
			}
			tmpNode.arbitary = newTmpNode;
			tmpNode = tmpNode.next;
		}

		Node clonedNode = LinkedList.clone(node);
		
		Node tmpClonedNode = clonedNode;
		
		tmpClonedNode.arbitary = new Node(10);
		
		System.out.println(tmpClonedNode);

//		Node node2 = LinkedList.insertNodeAtEnd(null, 7);
//		node2 = LinkedList.insertNodeAtEnd(node2, 9);
//		node2 = LinkedList.insertNodeAtEnd(node2, 10);
//		node2 = LinkedList.insertNodeAtEnd(node2, 16);
//		node2 = LinkedList.insertNodeAtEnd(node2, 20);
//		node2 = LinkedList.insertNodeAtEnd(node2, 2);
//		node2 = LinkedList.insertNodeAtEnd(node2, 1);
////		
//		LinkedList.printLinkedList(LinkedList.mergeInBetween(node,node2, 1, 1)); 

//		Node tmpNode = node;
//		while(tmpNode.next!=null) {
//			tmpNode = tmpNode.next;
//		}
//		tmpNode.next =  node.next.next.next;
//		
//		System.out.println(LinkedList.hasCycle(node));
//		System.out.println(LinkedList.lengthOfCycle(node));
//		System.out.println(LinkedList.startOfCycle(node).data);
//		
//		LinkedList.printLinkedList(LinkedList.removeCycle(node));

//		System.out.println(LinkedList.isLLPalindrome(node));

//		LinkedList.printLinkedList(node);
//
//		node = LinkedList.rearrangeLL(node);
//
//		LinkedList.printLinkedList(node);

//		System.out.println(LinkedList.cycleInCircularArray(new int[] {2, 1, -1, -2}));
//		LinkedList.printLinkedList(node);
//		LinkedList.printLinkedList(LinkedList.deleteNodesHavingGreaterValueOnRight(node));
//		LinkedList.printLinkedList(LinkedList.reverseAlternateKNodes(node, 2));
//		LinkedList.printLinkedList(LinkedList.KthNodeFromLast(node, 6));
//		node = LinkedList.removeDuplicateFromUnsorterLL(node);
//		LinkedList.printLinkedList(node);

//		Node node2 = LinkedList.insertNodeAtEnd(null, 18);
//		node2 = LinkedList.insertNodeAtEnd(node2, 14);
//		node2 = LinkedList.insertNodeAtEnd(node2, 8);
//		node2 = linkedList.insertNodeAtEnd(node2, 37);

//		node = linkedList.getMiddleNode(node);

//		Node node = LinkedList.insertNodeAtEnd(null, 20);
//		node = LinkedList.insertNodeAtEnd(node, 22);
//		node = LinkedList.insertNodeAtEnd(node, 25);
//		node = LinkedList.insertNodeAtEnd(node, 65);
//		node = LinkedList.insertNodeAtEnd(node, 70);
//		
//		node.right = LinkedList.insertNodeAtEnd(node.right, 7);
//		node.right = LinkedList.insertNodeAtEnd(node.right, 12);
//		node.right = LinkedList.insertNodeAtEnd(node.right, 23);
//		node.right = LinkedList.insertNodeAtEnd(node.right, 34);
//		
//		node.right.right = LinkedList.insertNodeAtEnd(node.right.right, 10);
//		node.right.right = LinkedList.insertNodeAtEnd(node.right.right, 15);
//		node.right.right = LinkedList.insertNodeAtEnd(node.right.right, 17);
//		node.right.right = LinkedList.insertNodeAtEnd(node.right.right, 18);

//		LinkedList.printLinkedList(node.right.right);

//		node = LinkedList.flattenList(null);
//		
//		LinkedList.printLinkedList(node);
//		System.out.println(LinkedList.getLength());

//		node = LinkedList.deleteNNodesPostMNodes(node, 1, 2);

//		node = LinkedList.sortLinkedList(node);
//		node = LinkedList.removeDuplicateNodes(node);

//		LinkedList.printLinkedList(node);
//		node2 = LinkedList.sortLinkedList(node2);
//		
//		Node node3 = LinkedList.mergeLL(node, node2);

//		Node node3 =  LinkedList.getIntersection(node, node2);
//

//
//		linkedList.printLinkedList(node);
//
//		node = linkedList.insertNodeAtFront(node, 0);
//
//		linkedList.printLinkedList(node);
//
//		node = linkedList.insertNodeAtGivenPosition(node, 3, 4);
//
//		linkedList.printLinkedList(node);
//
//		node = linkedList.reverseLinkedListIteratively(node);
//
////		node = linkedList.rotateLinkedListByKNodesAntiClockwise(node, 10);
//
//		linkedList.printLinkedList(node);

		/*
		 * node = linkedList.deleteNodeFromLast(node);
		 * 
		 * linkedList.printLinkedList(node);
		 * 
		 * node = linkedList.deleteNodeFromFront(node);
		 * 
		 * linkedList.printLinkedList(node); node =
		 * linkedList.deleteNodeAtGivenPosition(node, 1);
		 * linkedList.printLinkedList(node);
		 */

//		LinkedList.printLinkedList(LinkedList.mergeLLs(node, node2));

	}
}
