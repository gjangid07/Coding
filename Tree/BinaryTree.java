package Tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class BinaryTree {

	public static List<List<Integer>> resList = new ArrayList<List<Integer>>();

	public static int maxPathSum = 0;

	public static int countPathsForSum = 0;

	public static int pathWithMaxSumValue = 0;

	public static int leftLeavesSum = 0;

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

	public static int height(Node root) {

		if (root == null) {
			return 0;
		}

		int left = height(root.left);

		int right = height(root.right);

		return Math.max(left, right) + 1;
	}

	public static int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftDiameter = 0;
		int rightDiameter = 0;
		int leftHeight = 0;
		int rightHeight = 0;

		leftHeight = height(root.left);
		rightHeight = height(root.right);

		leftDiameter = diameterOfTree(root.left);
		rightDiameter = diameterOfTree(root.right);

		return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight);
	}

	public static int maxWidthRecur(Node root) {
		if (root == null) {
			return 0;
		}
		int[] count = new int[height(root)];
		maxWidthRecur(root, count, 0);

		return Arrays.stream(count).summaryStatistics().getMax();
	}

	private static void maxWidthRecur(Node root, int[] count, int level) {
		if (root != null) {
			count[level]++;
			maxWidthRecur(root.left, count, level + 1);
			maxWidthRecur(root.right, count, level + 1);
		}
	}

	public static boolean binaryTreePathSum(Node root, int sum) {
		if (root == null) {
			return false;
		}

		if (sum - root.data == 0) {
			return true;
		}
		boolean left = binaryTreePathSum(root.left, sum - root.data);
		boolean right = binaryTreePathSum(root.right, sum - root.data);

		return left || right;
	}

	public static int countBinaryTreePathSum(Node root, int sum, int count) {
		if (root == null) {
			return 0;
		}

		if (sum - root.data == 0) {
			count++;
			return count;
		}
		int left = countBinaryTreePathSum(root.left, sum - root.data, count);
		int right = countBinaryTreePathSum(root.right, sum - root.data, count);

		return left + right;

	}

	public static boolean getBinaryTreePathSum(Node root, int sum, List<Integer> list) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null && sum - root.data != 0) {
			if (list.contains(root.data)) {
				list.remove((Integer) root.data);
			}
			return false;
		}

		if (root.left == null && root.right == null && sum - root.data == 0) {
			list.add(root.data);
			resList.add(new ArrayList<Integer>(list));
			list.remove((Integer) root.data);
			return true;
		}

		list.add(root.data);

		boolean left = getBinaryTreePathSum(root.left, sum - root.data, list);
		boolean right = getBinaryTreePathSum(root.right, sum - root.data, list);

		if (list.contains(root.data)) {
			list.remove((Integer) root.data);
		}

		return left && right;
	}

	public static boolean ifSequencePresent(Node root, int[] arr, int index) {
		if (root == null || index >= arr.length) {
			return false;
		}

		if (root.data != arr[index]) {
			return false;
		}

		if (root.left == null && root.right == null && root.data == arr[index] && index == arr.length - 1) {
			return true;
		}

		index = index + 1;
		boolean left = ifSequencePresent(root.left, arr, index);
		boolean right = ifSequencePresent(root.right, arr, index);

		index = index - 1;

		return left || right;
	}

	public static int maxRootToLeafPathSum(Node root) {
		if (root == null) {
			return 0;
		}
		WrapperClass wc = new WrapperClass();
		maxRootToLeafPathSum(root, wc, 0);
		return wc.maxPathSum1;
	}

	private static void maxRootToLeafPathSum(Node root, WrapperClass wc, int sum) {
		if (root == null) {
			return;
		} else {
			sum = sum + root.data;
			wc.maxPathSum1 = Math.max(wc.maxPathSum1, sum);
			maxRootToLeafPathSum(root.left, wc, sum);
			maxRootToLeafPathSum(root.right, wc, sum);
		}
		sum = sum - root.data;
	}

	public static int sumOfPathNumbers(Node root) {
		if (root == null) {
			return 0;
		}

		List<Integer> resList = new ArrayList<Integer>();
		sumOfPathNumbers(root, resList, 0);
		return resList.stream().mapToInt(i -> i).sum();
	}

	private static void sumOfPathNumbers(Node root, List<Integer> list, int val) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			val = val * 10 + root.data;
			list.add(val);
		} else {
			val = val * 10 + root.data;
			sumOfPathNumbers(root.left, list, val);
			sumOfPathNumbers(root.right, list, val);
		}
		val = val / 10;
	}

	public static void countPathsForASum(Node root, int sum) {
		if (root == null) {
			return;
		}

		List<Integer> currentPathList = new ArrayList<Integer>();

		countPathsForASum(root, currentPathList, sum);
	}

	private static void countPathsForASum(Node root, List<Integer> currentPathList, int sum) {

		if (root == null) {
			return;
		}
		currentPathList.add(root.data);

		ListIterator<Integer> listIterator = currentPathList.listIterator(currentPathList.size());

		int currentPathSum = 0;
		while (listIterator.hasPrevious()) {
			currentPathSum = currentPathSum + listIterator.previous();

			if (currentPathSum == sum) {
				countPathsForSum++;
				break;
			}
		}

		countPathsForASum(root.left, currentPathList, sum);
		countPathsForASum(root.right, currentPathList, sum);

		currentPathList.remove((Integer) root.data);
	}

	public static int diameterOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		int leftDiameter = diameterOfBinaryTree(root.left);
		int diameterThroughRoot = heightOfTree(root.left) + heightOfTree(root.right);
		int rightDiameter = diameterOfBinaryTree(root.right);

		return Math.max(Math.max(leftDiameter, rightDiameter), diameterThroughRoot);
	}

	private static int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int left = heightOfTree(root.left) + 1;
		int right = heightOfTree(root.right) + 1;

		return Math.max(left, right);
	}

	public static int pathWithMaxSum(Node root) {
		if (root == null) {
			return 0;
		}

		int left = pathWithMaxSum(root.left);
		int right = pathWithMaxSum(root.right);

		if (left == right && left == 0) {
			return root.data;
		}
		pathWithMaxSumValue = Math.max(Math.max(pathWithMaxSumValue, Math.max(left, right) + root.data),
				left + right + root.data);

		return Math.max(left, right) + root.data;

	}

	public static int sumOfLeftLeaves(Node root) {
		return sumOfLeftLeaves(root, false);
	}

	public static int sumOfLeftLeaves(Node root, boolean isLeft) {

		if (root == null) {
			return 0;
		}

		sumOfLeftLeaves(root.left, true);

		if (root.left == null && root.right == null && isLeft) {
			leftLeavesSum += root.data;
		}

		sumOfLeftLeaves(root.right, false);

		return leftLeavesSum;

	}

	public static boolean isEvenOddTree(Node root) {
		if (root == null) {
			return false;
		}

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		boolean isEven = true;

		while (!q.isEmpty()) {
			Node prevNode = null;

			int size = q.size();

			while (size > 0) {
				Node tmpNode = q.poll();

				if (isEven) {
					if (prevNode == null) {
						if (tmpNode.data % 2 == 0) {
							return false;
						}
					} else {
						if (tmpNode.data % 2 == 0 || prevNode.data >= tmpNode.data) {
							return false;
						}
					}
				} else {
					if (prevNode == null) {
						if (tmpNode.data % 2 != 0) {
							return false;
						}
					} else {
						if (tmpNode.data % 2 != 0 || prevNode.data <= tmpNode.data) {
							return false;
						}
					}

				}
				if (tmpNode.left != null) {
					q.add(tmpNode.left);
				}

				if (tmpNode.right != null) {
					q.add(tmpNode.right);
				}
				prevNode = tmpNode;
				size--;

			}
			isEven = !isEven;

		}
		return true;
	}
}

class WrapperClass {
	public int maxPathSum1;
}
