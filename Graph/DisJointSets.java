package Graph;

import java.util.HashMap;
import java.util.Map;

class Node {
	int rank;
	int data;
	Node parent;
}

public class DisJointSets {

	Map<Integer, Node> map = new HashMap<>();

	public void makeSet(int val) {
		Node newNode = new Node();
		newNode.rank = 0;
		newNode.data = val;
		newNode.parent = newNode;
		map.put(val, newNode);
	}
	
	public Node findSet(int val) {
		Node tmpNode = map.get(val);
		return findSet(tmpNode);
	}
	

	public Node findSet(Node tmpNode) {

		if (tmpNode.parent == tmpNode) {
			return tmpNode;
		}
		tmpNode.parent = findSet(map.get(tmpNode.parent.data));
		return tmpNode.parent;
	}

	public void union(int data1, int data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		if (node1.parent == node2.parent) {
			return;
		}

		if (node1.parent.rank >= node2.parent.rank) {
			node1.parent.rank = (node1.parent.rank == node2.parent.rank) ? node1.parent.rank + 1 : node1.parent.rank;
			node2.parent = node1;
		}else {
			node1.parent = node2;
		}
	}
	
	public static void main(String[] args) {
		DisJointSets djs = new DisJointSets();
		
		djs.makeSet(1);
		djs.makeSet(2);
		djs.makeSet(3);
		djs.makeSet(4);
		djs.makeSet(5);
		djs.makeSet(6);
		djs.makeSet(7);
		
		djs.union(1, 2);
		djs.union(2, 3);
		djs.union(4, 5);
		djs.union(6, 7);
		djs.union(5, 6);
		djs.union(1, 4);
		
		System.out.println(djs.findSet(1).data);
		System.out.println(djs.findSet(2).data);
		System.out.println(djs.findSet(3).data);
		System.out.println(djs.findSet(4).data);
		System.out.println(djs.findSet(5).data);
		System.out.println(djs.findSet(6).data);
		System.out.println(djs.findSet(7).data);
		
		
	}

}
