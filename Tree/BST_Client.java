package Tree;

public class BST_Client {

//	BinarySearchTree bst = new BinarySearchTree();

	public static void main(String[] args) {
		Node root = BinarySearchTree.insertNode(null, 10);
//		root  = BinarySearchTree.insertNode(root, 5);
//		root  = BinarySearchTree.insertNode(root, 6);
//		root  = BinarySearchTree.insertNode(root, 3);
//		root  = BinarySearchTree.insertNode(root, 4);
//		root  = BinarySearchTree.insertNode(root, 1);
//		root  = BinarySearchTree.insertNode(root, 12);
//		root  = BinarySearchTree.insertNode(root, 15);
//		
//		root  = BinarySearchTree.insertNode(root, 17);
//		root  = BinarySearchTree.insertNode(root, 9);
//		root  = BinarySearchTree.insertNode(root, 8);
//		root  = BinarySearchTree.insertNode(root, 13);
//		root  = BinarySearchTree.insertNode(root, 10);
//		root  = BinarySearchTree.insertNode(root, 16);

		root.left = new Node(5);
		root.right = new Node(15);

		root.left.left = new Node(2);
		root.left.right = new Node(8);
		root.right.left = new Node(13);
		root.right.right = new Node(18);

		root.left.left.left = new Node(1);
		root.left.left.right = new Node(3);
//		root.left.right.left = new Node(7);
//		root.left.right.right = new Node(9);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(14);
		root.right.right.left = new Node(17);
		root.right.right.right = new Node(19);

		Node root2 = BinarySearchTree.insertNode(null, 10);

		root2.left = new Node(5);
		root2.right = new Node(15);

		root2.left.left = new Node(2);
		root2.left.right = new Node(8);
		root2.right.left = new Node(13);
		root2.right.right = new Node(18);

		root2.left.left.left = new Node(1);
		root2.left.left.right = new Node(3);
		root2.left.right.left = new Node(7);
		root2.left.right.right = new Node(9);
		root2.right.left.left = new Node(12);
		root2.right.left.right = new Node(14);
		root2.right.right.left = new Node(17);
		root2.right.right.right = new Node(19);

//		BinarySearchTree.printBST(root);

//		System.out.println(BinarySearchTree.searchNode(root, 11));
//		System.out.println(BinarySearchTree.minNode(root).data);

//		BinarySearchTree.levelOrderTraversal(root);
//		System.out.println(BinarySearchTree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

//		System.out.println(BinarySearchTree.isBST2(root));

//		root = BinarySearchTree.delete(root, 12);
//		BinarySearchTree.levelOrderTraversal(root);

//		System.out.println(BinarySearchTree.getParent(root, 62).data);

//		System.out.println(BinarySearchTree.getParentIteratively(root, 15).data);

//		System.out.println(BinarySearchTree.getSiblingIteratively(root, 10).data);
//		System.out.println(BinarySearchTree.getInorderParentNode(root, 3).data);
//		System.out.println(BinarySearchTree.getInorderSuccessorNodeRecursively(root, null, 13).data);
//		System.out.println(BinarySearchTree.getEvenOddLevelDiffRecursively(root));
//		System.out.println(BinarySearchTree.getLevelOrderNodes(root));
//		System.out.println(BinarySearchTree.getZigZagLevelOrderNodes(root));
//		System.out.println(BinarySearchTree.getLevelOrderAverageNodes(root));
//		System.out.println(BinarySearchTree.minDepth(root));
//		System.out.println(BinarySearchTree.levelOrderSuccessor(root, 10).data);
//		System.out.println(BinarySearchTree.sizeOfTree(root));

//		BinarySearchTree.connectLevelOrderNodes(root);
//		BinarySearchTree.connectAllLevelOrderSiblings(root);
//		BinarySearchTree.leftViewOfTree(root);
//		System.out.println(BinarySearchTree.LowestCommonAncestor(root, 5,9).data);
//		BinarySearchTree.KthLargestElement(root, 5);

//		System.out.println(BinarySearchTree.compareTwoBSTs(root, root2));
//		BinarySearchTree.convertBSTToDLinkedListNew(root);
//		System.out.println(BinarySearchTree.newLinkedList);

//		Node node = BinarySearchTree.createBalancedBST(new int[] { 8, 6, 12, 18, 34, 23, 3 });
//		BinarySearchTree.inorderTraversal(node);
		
//		BinarySearchTree.inorderPredessor(root, 9);
		
//		BinarySearchTree.topViewOfTree(root);
//		System.out.println(BinarySearchTree.map);
//		System.out.println(BinarySearchTree.topViewlist);
		
		BinarySearchTree.bottonViewOfTree(root);
	}
}
