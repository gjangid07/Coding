package Tree;

public class DNode {

	int data;
	DNode next;
	DNode prev;

	public DNode() {

	}

	public DNode(int val) {
		data = val;
		next = null;
		prev = null;
	}

	public static DNode insertAtEnd(DNode node, int val) {
		if (node == null) {
			return new DNode(val);
		} else {
			DNode tmpNode = node;
			while (tmpNode.next != null) {
				tmpNode = tmpNode.next;
			}
			DNode newNode = new DNode(val);
			tmpNode.next = newNode;
			newNode.prev = tmpNode;
		}
		return node;
	}
	
	public static void printDLinkedList(DNode node) {
		if(node == null) {
			return;
		}
		
		while(node.next!=null) {
			System.out.print(node.data + "<->");
			node = node.next;
		}
		System.out.print(node.data + "<->null");
	}
}
