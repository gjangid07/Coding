package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Queue;

public class BinarySearchTree {

	static int countKthElement = 0;
	static DNode linkedList = null;
	static Node newLinkedList = null;
	static Node prev = null;
	static Node inorderPredessor = null;
	static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
	static List<Integer> topViewlist = new ArrayList<Integer>();

	public static Node insertNode(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (root.data >= value) {
			root.left = insertNode(root.left, value);
		} else {
			root.right = insertNode(root.right, value);
		}
		return root;
	}

	public static boolean searchNode(Node root, int value) {
		if (root == null) {
			return false;
		}
		if (root.data == value) {
			return true;
		}

		if (root.data >= value) {
			return searchNode(root.left, value);
		} else {
			return searchNode(root.right, value);
		}

	}

	public static Node deleteNode(Node root, int value) {
		if (root == null) {
			return root;
		}

		if (root.data == value) {
			return root;
		}

		Node left = null;
		Node right = null;

		if (root.data >= value) {
			left = deleteNode(root.left, value);
			if (left != null) {
				if (left.left == null && left.right == null && left.data == value) {
					root.left = null;
				} else {
					if (left.left != null && left.right == null) {
						Node tmpLeft = left.left;
						while (tmpLeft.right != null) {
							tmpLeft = tmpLeft.right;
						}
						left.left = deleteNode(left.left, tmpLeft.data);
						left.data = tmpLeft.data;
					} else if (left.left == null && left.right != null) {
						Node tmpRight = left.right;
						while (tmpRight.left != null) {
							tmpRight = tmpRight.left;
						}
						left.right = deleteNode(left.right, tmpRight.data);
						left.data = tmpRight.data;
					} else if (left.left != null && left.right != null) {
						Node tmpLeft = left.left;
						while (tmpLeft.right != null) {
							tmpLeft = tmpLeft.right;
						}
						left.left = deleteNode(left.left, tmpLeft.data);
						if (left.left != null) {
							if (left.left.left == null && left.left.right == null && left.left.data == tmpLeft.data) {
								left.left = null;
							}
						}
						left.data = tmpLeft.data;
					}
				}
			}
			return root;
		} else {
			right = deleteNode(root.right, value);
			if (right != null) {
				if (right.left == null && right.right == null && right.data == value) {
					root.right = null;
				} else {
					if (right.left != null && right.right == null) {
						Node tmpLeft = right.left;
						while (tmpLeft.right != null) {
							tmpLeft = tmpLeft.right;
						}
						right.left = deleteNode(right.left, tmpLeft.data);
						right.data = tmpLeft.data;
					} else if (right.left == null && right.right != null) {
						Node tmpRight = right.right;
						while (tmpRight.left != null) {
							tmpRight = tmpRight.left;
						}
						right.right = deleteNode(right.right, tmpRight.data);
						right.data = tmpRight.data;
					} else if (right.left != null && right.right != null) {
						Node tmpRight = right.right;
						while (tmpRight.left != null) {
							tmpRight = tmpRight.left;
						}
						right.right = deleteNode(right.right, tmpRight.data);
						if (right.right != null) {
							if (right.right.left == null && right.right.right == null
									&& right.right.data == tmpRight.data) {
								right.right = null;
							}
						}
						right.data = tmpRight.data;
					}
				}
			}
			return root;
		}
	}

	public static Node delete(Node root, int value) {
		if (root == null) {
			return root;
		}

		if (root.data > value) {
			root.left = delete(root.left, value);
		} else if (root.data < value) {
			root.right = delete(root.right, value);
		} else if (root.data == value) {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left != null && root.right == null) {
				root = root.left;
			} else if (root.left == null && root.right != null) {
				root = root.right;
			} else {
				Node tmp = minNode(root.right);
				root.data = tmp.data;
				root.right = delete(root.right, tmp.data);
			}
		}
		return root;

	}

	public static int height(Node root) {
		if (root.left == null && root.right == null) {
			return 0;
		}

		int left = 0;
		if (root.left != null) {
			left = height(root.left);
		}

		int right = 0;
		if (root.right != null) {
			right = height(root.right);
		}

		return Math.max(left, right) + 1;
	}

	public static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();
			System.out.print(tmpNode.data + "->");

			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}
		}

	}

	public static Node maxNode(Node root) {
		if (root == null) {
			return root;
		}

		if (root.right != null) {
			return maxNode(root.right);
		} else {
			return root;
		}
	}

	public static Node minNode(Node root) {
		if (root == null) {
			return root;
		}

		if (root.left != null) {
			return minNode(root.left);
		} else {
			return root;
		}
	}

	public static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + "->");
		inorderTraversal(root.right);

	}

	public static void preorderTraversal(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + "->");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public static void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}

		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data + "->");
	}

	public static boolean isBST(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}

		boolean left = root.data >= minValue && isBST(root.left, minValue, root.data);

		boolean right = root.data < maxValue && isBST(root.right, root.data, maxValue);

		return left == right & left == true;
	}

	public static int isBST2(Node root) {
		if (root == null) {
			return 0;
		}
		int left = isBST2(root.left);

		if (root.data < left) {
			return -1;
		}

		int right = isBST2(root.right);

		if (right != 0 && root.data > right) {
			return -1;
		}

		if (left == -1 || right == -1) {
			return -1;
		} else
			return root.data;
	}

	public static Node getParent(Node root, int childData) {
		if (root == null) {
			return null;
		}

		if (root.data == childData) {
			return null;
		}

		if (root.left != null && root.left.data == childData) {
			return root;
		}

		if (root.right != null && root.right.data == childData) {
			return root;
		}

		Node left = null;
		Node right = null;

		if (root.data > childData) {
			left = getParent(root.left, childData);
		}

		if (root.data < childData) {
			right = getParent(root.right, childData);
		}

		if (left == null && right == null) {
			return null;
		} else {
			return left != null ? left : right;
		}
	}

	public static Node getParentIteratively(Node root, int childData) {

		if (root == null) {
			return null;
		}

		Node parent = null;

		while (root != null) {
			if (root.data > childData) {
				parent = root;
				root = root.left;
			} else if (root.data < childData) {
				parent = root;
				root = root.right;
			} else {
				break;
			}
		}

		return root == null ? null : parent;
	}

	public static Node getSibling(Node root, int siblingData) {
		if (root == null) {
			return root;
		}

		if (root.left != null && root.left.data == siblingData) {
			return root.right;
		}

		if (root.right != null && root.right.data == siblingData) {
			return root.left;
		}

		Node left = null;
		Node right = null;

		if (root.data > siblingData) {
			left = getSibling(root.left, siblingData);
		}

		if (root.data < siblingData) {
			right = getSibling(root.right, siblingData);
		}

		if (left == right && left == null) {
			return null;
		}

		return left == null ? right : left;
	}

	public static Node getSiblingIteratively(Node root, int siblingData) {

		if (root == null) {
			return root;
		}

		Node siblingNode = null;
		Node parentNode = null;

		while (root != null) {
			if (root.data > siblingData) {
				parentNode = root;
				root = root.left;
			} else if (root.data < siblingData) {
				parentNode = root;
				root = root.right;
			} else {
				break;
			}
		}

		if (root != null && parentNode != null) {
			if (parentNode.left == root) {
				return siblingNode = parentNode.right;
			} else {
				return siblingNode = parentNode.left;
			}
		}
		return siblingNode;
	}

	public static Node getInorderParentNode(Node root, int data) {

		if (root == null) {
			return root;
		}

		Node inorderParentNode = null;

		while (root != null) {
			if (root.data > data) {
				inorderParentNode = root;
				root = root.left;
			} else if (root.data < data) {
				root = root.right;
			} else {
				break;
			}
		}

		if (root != null && root.data == data) {
			return inorderParentNode;
		}
		return null;
	}

	public static Node getInorderSuccessorNodeRecursively(Node root, Node succ, int data) {
		if (root == null) {
			return root;
		}

		if (root.data == data) {
			if (root.right != null) {
				return minNode(root.right);
			} else
				return succ;
		}

		Node left = null;
		Node right = null;

		if (root.data > data) {
			succ = root;
			left = getInorderSuccessorNodeRecursively(root.left, succ, data);
		} else if (root.data < data) {
			right = getInorderSuccessorNodeRecursively(root.right, succ, data);
		}

		if (left == null && right == null) {
			return null;
		}

		return left != null ? left : right;

	}

	public static Node getInorderSuccessorNode(Node root, int data) {
		if (root == null) {
			return root;
		}

		Node inorderSuccessorNode = null;

		while (root != null) {
			if (root.data > data) {
				inorderSuccessorNode = root;
				root = root.left;
			} else if (root.data < data) {
				root = root.right;
			} else {
				break;
			}
		}

		if (root != null) {
			if (inorderSuccessorNode != null) {
				if (root.right == null)
					return inorderSuccessorNode;
				else
					return minNode(root.right);
			} else {
				return minNode(root.right);
			}
		}
		return null;
	}

	public static int getEvenOddLevelDiff(Node root) {

		if (root == null) {
			return -1;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		boolean isOdd = true;
		int resDiff = 0;

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (queue.isEmpty()) {
				break;
			}

			if (tmpNode == null) {
				isOdd = !isOdd;
				queue.add(null);
			} else {
				if (isOdd) {
					resDiff = resDiff + tmpNode.data;
				} else {
					resDiff = resDiff - tmpNode.data;
				}

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
			}

		}
		return resDiff;
	}

	public static int getEvenOddLevelDiffRecursively(Node root) {
		if (root == null) {
			return 0;
		}

		return root.data - getEvenOddLevelDiffRecursively(root.left) - getEvenOddLevelDiffRecursively(root.right);
	}

	public static List<List<Integer>> getLevelOrderNodes(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			List<Integer> levelList = new ArrayList<Integer>();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();
				levelList.add(tmpNode.data);

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
				levelSize--;
			}
			resList.add(levelList);
		}
		return resList;
	}

	public static List<List<Integer>> getZigZagLevelOrderNodes(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		int level = 0;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			List<Integer> levelList = new ArrayList<Integer>();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();

				if (level % 2 == 0) {
					levelList.add(tmpNode.data);
				} else {
					levelList.add(0, tmpNode.data);
				}

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}

				levelSize--;
			}
			level++;

			resList.add(levelList);
		}
		return resList;

	}

	public static List<Double> getLevelOrderAverageNodes(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		List<Double> resList = new ArrayList<Double>();

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			List<Integer> levelList = new ArrayList<Integer>();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();
				levelList.add(tmpNode.data);

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}

				levelSize--;
			}
			double avg = levelList.stream().mapToInt(i -> i).summaryStatistics().getAverage();
			resList.add(avg);
		}
		return resList;

	}

	public static int minDepth(Node root) {
		if (root == null) {
			return -1;
		}
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = minDepth(root.left);
		}

		if (root.right != null) {
			right = minDepth(root.right);
		}
		return Math.min(left, right) + 1;
	}

	public static Node levelOrderSuccessor(Node root, int data) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean found = false;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();
				if (found) {
					return tmpNode;
				}

				if (tmpNode.data == data) {
					found = true;
				}

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}

				levelSize--;
			}
		}

		return null;
	}

	public static int sizeOfTree(Node root) {
		if (root == null) {
			return -1;
		}

		int left = 0;
		int right = 0;

		if (root.left != null) {
			left = sizeOfTree(root.left);
		}

		if (root.right != null) {
			right = sizeOfTree(root.right);
		}

		return left + right + 1;
	}

	public static int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftDiameter = 0;
		int rightDiameter = 0;
		int leftHeight = 0;
		int rightHeight = 0;

		int heightOfRoot = 0;

		if (root.left != null) {
			leftDiameter = diameterOfTree(root.left) + 1;
			leftHeight = height(root.left);
		}

		if (root.right != null) {
			rightDiameter = diameterOfTree(root.right) + 1;
			rightHeight = height(root.right);
		}

		heightOfRoot = leftHeight + rightHeight + 1;

		return Math.max(Math.max(leftDiameter, rightDiameter), heightOfRoot);
	}

	public static Node connectLevelOrderNodes(Node root) {

		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int levelSize = 0;

		while (!queue.isEmpty()) {
			levelSize = queue.size();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();

				if (levelSize == 1) {
					tmpNode.levelRight = null;
					System.out.print(tmpNode.data + "->" + tmpNode.levelRight + ", ");
				} else {
					tmpNode.levelRight = queue.peek();
					System.out.print(tmpNode.data + "->" + tmpNode.levelRight.data + ", ");
				}

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
				levelSize--;
			}
		}

		return root;
	}

	public static void printLevelOrderRight(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (tmpNode.levelRight != null) {
				System.out.print(tmpNode.data + "->" + tmpNode.levelRight.data + ", ");
			} else {
				System.out.print(tmpNode.data + "->" + tmpNode.levelRight + ", ");
			}

			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}
		}
	}

	public static Node connectAllLevelOrderSiblings(Node root) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}

			if (queue.peek() == null) {
				tmpNode.levelRight = null;
				System.out.print(tmpNode.data + "->" + tmpNode.levelRight + ", ");
			} else {
				tmpNode.levelRight = queue.peek();
				System.out.print(tmpNode.data + "->" + tmpNode.levelRight.data + ", ");
			}
		}
		return root;
	}

	public static Node rightViewOfTree(Node root) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int levelSize = 0;

		while (!queue.isEmpty()) {
			levelSize = queue.size();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();

				if (levelSize == 1) {
					System.out.print(tmpNode.data + ", ");
				}
				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}

				levelSize--;
			}
		}
		return root;
	}

	public static Node leftViewOfTree(Node root) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int levelSize = 0;
		boolean startOfLevel = true;

		while (!queue.isEmpty()) {
			levelSize = queue.size();

			while (levelSize > 0) {
				Node tmpNode = queue.poll();

				if (startOfLevel) {
					System.out.print(tmpNode.data + ", ");
					startOfLevel = false;
				}

				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}

				levelSize--;
			}
			startOfLevel = true;
		}
		return root;
	}

	public static void topViewOfTree(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (map.get(tmpNode.horizontalDistance) == null) {
				LinkedList<Integer> linkedList = new LinkedList<Integer>();
				linkedList.add(tmpNode.data);
				map.put(tmpNode.horizontalDistance, linkedList);
				topViewlist.add(tmpNode.data);
				System.out.println(tmpNode.data);
			} else {
				LinkedList<Integer> linkedList = map.get(tmpNode.horizontalDistance);
				linkedList.add(tmpNode.data);
				map.put(tmpNode.horizontalDistance, linkedList);
			}

			if (tmpNode.left != null) {
				tmpNode.left.horizontalDistance = tmpNode.horizontalDistance - 1;
				queue.add(tmpNode.left);

			}

			if (tmpNode.right != null) {
				tmpNode.right.horizontalDistance = tmpNode.horizontalDistance + 1;
				queue.add(tmpNode.right);

			}
		}

	}

	public static void bottonViewOfTree(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (tmpNode.left == null && tmpNode.right == null) {
				System.out.print(tmpNode.data + ", ");
			}

			if (tmpNode.left != null) {
				queue.add(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.add(tmpNode.right);
			}
		}
	}

	public static Node LowestCommonAncestor(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		Node parent = null;

		while (true) {
			if (n1 < root.data && n2 < root.data) {
				parent = root;
				root = root.left;
			}

			if (n1 > root.data && n2 > root.data) {
				parent = root;
				root = root.right;
			}

			if (n1 > root.data && n2 < root.data || n2 > root.data && n1 < root.data) {
				break;
			}

			if (n1 == root.data || n2 == root.data) {
				return parent;
			}
		}

		return root;
	}

	public static void KthSmallestElement(Node root, int k) {
		if (root == null) {
			return;
		}
		KthSmallestElement(root.left, k);
		countKthElement++;
		if (countKthElement == k) {
			System.out.println(root.data);
		}
		KthSmallestElement(root.right, k);
	}

	public static void KthLargestElement(Node root, int k) {
		if (root == null) {
			return;
		}
		KthLargestElement(root.right, k);
		countKthElement++;
		if (countKthElement == k) {
			System.out.println(root.data);
		}
		KthLargestElement(root.left, k);
	}

	public static boolean compareTwoBSTs(Node root1, Node root2) {

		if (root1 == root2 && root1 == null) {
			return true;
		}

		if (root1.data != root2.data) {
			return false;
		}

		boolean left = compareTwoBSTs(root1.left, root2.left);

		boolean right = compareTwoBSTs(root1.right, root2.right);

		return left && right;

	}

	public static void convertBSTToDLinkedList(Node root) {
		if (root == null) {
			return;
		}
		convertBSTToDLinkedList(root.left);
		linkedList = DNode.insertAtEnd(linkedList, root.data);
		convertBSTToDLinkedList(root.right);
	}

	public static void convertBSTToDLinkedListNew(Node root) {
		if (root == null) {
			return;
		}

		convertBSTToDLinkedListNew(root.left);

		if (prev == null) {
			newLinkedList = root;
		} else {
			root.left = prev;
			prev.right = root;
		}

		prev = root;

		convertBSTToDLinkedListNew(root.right);
	}

	public static Node createBalancedBST(int[] arr) {
		if (arr.length == 0) {
			return null;
		}

		Arrays.sort(arr);

		return createBalancedBST(arr, 0, arr.length - 1);

	}

	private static Node createBalancedBST(int[] arr, int start, int end) {

		if (end == start) {
			return new Node(arr[end]);
		}

		int mid = (end + 1 - start) / 2 + start;

		Node left = createBalancedBST(arr, start, mid - 1);
		Node right = createBalancedBST(arr, mid + 1, end);

		Node root = new Node(arr[mid]);
		root.left = left;
		root.right = right;

		return root;

	}

	public static void inorderPredessor(Node root, int data) {
		if (root == null) {
			return;
		}

		inorderPredessor(root.left, data);

		if (root.data == data) {
			if (inorderPredessor != null) {
				System.out.println(inorderPredessor.data);
			} else {
				System.out.println("null");
			}

		}
		inorderPredessor = root;

		inorderPredessor(root.right, data);

	}

}
