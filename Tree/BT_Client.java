package Tree;

import java.util.ArrayList;

public class BT_Client {

	public static void main(String[] args) {
		Node root = BinarySearchTree.insertNode(null, 11);
		
		root.left = new Node(8);
		root.right = new Node(6);
//
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(9);
		root.right.right = new Node(11);

		root.left.left.left = new Node(12);
		root.left.left.right = new Node(8);
		root.right.left.left = new Node(6);
		root.right.right.right = new Node(2);
		
		System.out.println(BinaryTree.isEvenOddTree(root));
		
//		root.left.left.right.left = new Node(8);
		
//		root.left.left.right.left = new Node(8);
//		root.left.right.right.left = new Node(12);
//		root.left.right.right.right = new Node(13);
//		
//		root.left.left.right.left.left = new Node(9);
//		root.left.left.right.left.right = new Node(10);
//		root.left.right.right.right.right = new Node(14);
		
	
//		System.out.println(BinaryTree.height(root));
//		System.out.println(BinaryTree.diameterOfTree(root));
		
//		System.out.println(BinaryTree.maxWidthRecur(root));
//		BinaryTree.getBinaryTreePathSum(root, 14, new ArrayList<Integer>());
//		System.out.println(BinaryTree.resList);
		
//		System.out.println(BinaryTree.maxRootToLeafPathSum(root));
//		System.out.println(BinaryTree.maxPathSum);
//		System.out.println(BinaryTree.ifSequencePresent(root, new int[] {1,2,4,7},0));
//		
//		BinaryTree.countPathsForASum(root, 13);
//		System.out.println(BinaryTree.countPathsForSum);
		
//		System.out.println(BinaryTree.diameterOfBinaryTree(root));
		
//		BinaryTree.pathWithMaxSum(root);
//		System.out.println(BinaryTree.pathWithMaxSumValue);
		
//		System.out.println(BinaryTree.sumOfLeftLeaves(root));
	}
}
