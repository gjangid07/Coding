package Tree;

public class Node {

	int data;
	Node left;
	Node right;
	Node levelRight;
	int horizontalDistance;
	
	public Node() {
		
	}
	
	public Node(int value) {
		data = value;
		left = null;
		right = null;
		levelRight = null;
		horizontalDistance = 0;
	}
}
