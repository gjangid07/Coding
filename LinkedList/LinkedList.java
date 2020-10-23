package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedList {

	static int length;

	public static Node insertNodeAtEnd(Node root, int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			Node tmp = root;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node(value);

		}
		length++;
		return root;
	}

	public static Node insertNodeAtFront(Node root, int value) {
		Node newNode = new Node(value);

		if (root == null) {
			root = newNode;
		} else {
			newNode.next = root;
			root = newNode;
		}
		length++;
		return root;
	}

	public static Node insertNodeAtGivenPosition(Node root, int value, int pos) {

		if (pos < 1 || pos > length) {
			System.out.println("Not a valid position");
			return null;
		}

		Node newNode = new Node(value);

		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node prev = null;
			while (pos - 1 > 0) {
				prev = current;
				current = current.next;
				pos--;
			}
			prev.next = newNode;
			newNode.next = current;
		}
		length++;
		return root;
	}

	public static Node deleteNodeFromLast(Node root) {
		if (root == null || root.next == null) {
			return null;
		}

		Node tmp = root;
		while (tmp.next.next != null) {
			tmp = tmp.next;
		}
		tmp.next = null;
		length--;
		return root;
	}

	public static Node deleteNodeFromFront(Node root) {
		if (root == null || root.next == null) {
			return null;
		}
		length--;
		return root = root.next;

	}

	public static Node deleteNodeAtGivenPosition(Node root, int pos) {

		if (pos < 1 || pos > length) {
			System.out.println("Not a valid position");
			return null;
		}

		if (root == null) {
			return null;
		} else {
			if (pos == 1) {
				root = root.next;
				length--;
				return root;
			} else {
				Node tmp = root;
				while (pos - 2 > 0) {
					tmp = tmp.next;
					pos--;
				}
				tmp.next = tmp.next.next;
			}
		}
		length--;
		return root;
	}

	public static int searchIndex(Node root, int value) {
		if (root == null) {
			return -1;
		} else {
			Node tmp = root;
			int count = 0;
			while (tmp != null) {
				if (tmp.data == value) {
					return count;
				}
				count++;
				tmp = tmp.next;
			}

		}
		return -1;
	}

	public static Node rotateLinkedListByKNodesClockwise(Node root, int k) {
		k %= length;

		if (k <= 0) {
			return root;
		}

		int count = length - k - 1;
		Node tmp = root;

		if (root == null) {
			return null;
		} else {
			while (count > 0) {
				tmp = tmp.next;
				count--;
			}
			Node frontLL = tmp.next;
			tmp.next = null;

			Node backLL = root;

			Node newroot = frontLL;

			while (newroot.next != null) {
				newroot = newroot.next;
			}
			newroot.next = backLL;

			return frontLL;
		}
	}

	public static Node rotateLinkedListByKNodesAntiClockwise(Node root, int k) {
		k %= length;

		if (k <= 0 || root == null) {
			return root;
		} else {
			Node tmp = root;
			while (k > 1) {
				tmp = tmp.next;
				k--;
			}
			Node newRoot = tmp.next;
			tmp.next = null;

			Node backLL = root;
			root = newRoot;

			while (newRoot.next != null) {
				newRoot = newRoot.next;
			}
			newRoot.next = backLL;

			return root;
		}
	}

	public static Node reverseLinkedListIteratively(Node root) {

		if (root == null || root.next == null) {
			return root;
		}

		Node current = root;
		Node prev = null;

		while (current != null) {
			root = current.next;
			current.next = prev;
			prev = current;
			current = root;
		}
		return prev;
	}

	public static Node reverseLinkedListRecursively(Node root) {

		if (root == null || root.next == null) {
			return root;
		}

		Node tmp = reverseLinkedListRecursively(root.next);
		root.next.next = root;
		root.next = null;
		return tmp;
	}

	public static Node getMiddleNode(Node root) {

		if (root == null || root.next == null) {
			return root;
		}
		Node slow = root;
		Node fast = root.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node removeDuplicateNodes(Node node) {
		if (node == null || node.next == null) {
			return node;
		} else {
			if (node.data == node.next.data) {
				node.next = node.next.next;
				removeDuplicateNodes(node);
			} else {
				removeDuplicateNodes(node.next);
			}

		}
		return node;
	}

	public static Node sortLinkedList(Node root) {
		if (root == null || root.next == null) {
			return root;
		} else {
			Node midNode = getMiddleNode(root);
			Node secondLL = midNode.next;
			midNode.next = null;

			root = sortLinkedList(root);
			secondLL = sortLinkedList(secondLL);

			return mergeLL(root, secondLL);
		}
	}

	static Node mergeLL(Node firstLL, Node secondLL) {
		Node newLL = null;
		Node root = null;

		while (firstLL != null && secondLL != null) {
			if (firstLL.data < secondLL.data) {
				if (newLL == null) {
					newLL = new Node(firstLL.data);
					root = newLL;
				} else {
					newLL.next = new Node(firstLL.data);
					newLL = newLL.next;
				}
				firstLL = firstLL.next;
			} else if (firstLL.data > secondLL.data) {
				if (newLL == null) {
					newLL = new Node(secondLL.data);
					root = newLL;
				} else {
					newLL.next = new Node(secondLL.data);
					newLL = newLL.next;
				}
				secondLL = secondLL.next;
			} else {
				if (newLL == null) {
					newLL = new Node(secondLL.data);
					root = newLL;
				} else {
					newLL.next = new Node(secondLL.data);
					newLL = newLL.next;
				}
				secondLL = secondLL.next;
				firstLL = firstLL.next;
			}
		}

		newLL.next = (firstLL != null) ? firstLL : secondLL;

		return root;
	}

	public static Node mergeLLs(Node firstLL, Node secondLL) {
		Node mergedLLHead = null;
		Node mergedLLTail = null;
		Node firstNext = null;
		Node secondNext = null;

		while (firstLL != null && secondLL != null) {
			if (firstLL.data < secondLL.data) {
				firstNext = firstLL.next;
				if (mergedLLHead == null) {
					mergedLLHead = firstLL;
					mergedLLTail = firstLL;
				} else {
//					firstNext = firstLL.next;
					mergedLLTail.next = firstLL;
					mergedLLTail = mergedLLTail.next;

				}

				firstLL = firstNext;
			} else {
				secondNext = secondLL.next;
				if (mergedLLHead == null) {
					mergedLLHead = secondLL;
					mergedLLTail = secondLL;
				} else {
//					secondNext = secondLL.next;
					mergedLLTail.next = secondLL;
					mergedLLTail = mergedLLTail.next;
				}
				secondLL = secondNext;
			}
		}

		if (secondLL == null && firstLL != null) {
			mergedLLTail.next = firstLL;
		}

		if (firstLL == null && secondLL != null) {
			mergedLLTail.next = secondLL;
		}

		return mergedLLHead;
	}

	public static Node getIntersection(Node a, Node b) {
		return mergeIntersection(sortLinkedList(a), sortLinkedList(b));
	}

	private static Node mergeIntersection(Node a, Node b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		Node newRoot = null;
		Node root = null;
		while (a != null && b != null) {
			if (a.data == b.data) {
				if (newRoot == null) {
					newRoot = new Node(a.data);
					root = newRoot;
				} else {
					newRoot.next = new Node(a.data);
					newRoot = newRoot.next;
				}
			}
			a = a.next;
			b = b.next;

		}
		return root;
	}

	public static Node deleteNNodesPostMNodes(Node node, int n, int m) {
		if (node == null || node.next == null) {
			return node;
		}

		if (n < 0 || n > getLength()) {
			System.out.println("Not valid value of n");
			return node;
		}

		if (m < 0 || m > getLength()) {
			System.out.println("Not valid value of m");
			return node;
		}

		Node tmpNode = node;
		Node tmpNode2 = node;
		while (tmpNode != null && tmpNode.next != null) {
			for (int i = 0; i < m - 1 && tmpNode != null; i++) {
				tmpNode = tmpNode.next;
			}
			tmpNode2 = tmpNode.next;

			for (int i = 0; i < n && tmpNode2 != null; i++) {
				tmpNode2 = tmpNode2.next;
			}
			tmpNode.next = tmpNode2;
			tmpNode = tmpNode2;
		}

		return node;
	}

	public static Node flattenList(Node root) {
		if (root == null || root.right == null) {
			return root;
		}
		Node tmpNode = flattenList(root.right);
		Node mergeNode = mergeLL(root, tmpNode);
		return mergeNode;
	}

	public static Node removeDuplicateFromUnsorterLL(Node root) {
		Set<Integer> set = new HashSet<>();

		Node tmpNode = root;
		Node prev = null;

		while (tmpNode != null && tmpNode.next != null) {
			if (set.contains(tmpNode.data)) {
				Node next = tmpNode.next;
				prev.next = next;
				tmpNode = tmpNode.next;
			} else {
				set.add(tmpNode.data);
				prev = tmpNode;
				tmpNode = tmpNode.next;
			}
		}

		if (tmpNode != null && set.contains(tmpNode.data)) {
			tmpNode = null;
			prev.next = null;
		}

		return root;
	}

	public static Node KthNodeFromLast(Node root, int k) {
		if (root == null) {
			return root;
		}

		if (k < 0 || k > getLength()) {
			System.out.println("Invalid K Value");
			return null;
		}

		if (k == 0) {
			return root;
		}

		Node p1 = root;
		Node p2 = root;

		while (k-- > 0) {
			p2 = p2.next;
		}

		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void printLinkedList(Node node) {
		if (node == null) {
			return;
		}
		while (node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public static int getLength() {
		return length;
	}

	public static boolean hasCycle(Node root) {
		if (root == null || root.next == null) {
			return false;
		}

		Node slow = root;
		Node fast = root.next;

		while (slow != fast && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast.next != null && slow == fast) {
			return true;
		}
		return false;
	}

	public static int lengthOfCycle(Node root) {
		if (hasCycle(root)) {
			if (root == null || root.next == null) {
				return -1;
			}

			Node slow = root;
			Node fast = root.next;

			while (slow != fast && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			Node tmpNode = null;
			if (fast.next != null && slow == fast) {
				tmpNode = slow;
			}

			int count = 1;
			tmpNode = tmpNode.next;
			while (tmpNode != slow) {
				tmpNode = tmpNode.next;
				count++;
			}
			return count;
		}
		return -1;
	}

	public static Node startOfCycle(Node root) {
		int cycleLength = 0;
		if (hasCycle(root)) {
			cycleLength = lengthOfCycle(root);

			Node p1 = root;
			Node p2 = root;

			while (cycleLength-- != 0) {
				p1 = p1.next;
			}

			while (p1 != p2) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}
		return null;
	}

	public static Node removeCycle(Node root) {
		int cycleLength = 0;
		if (hasCycle(root)) {
			cycleLength = lengthOfCycle(root);

			Node p1 = root;
			Node p2 = root;

			while (cycleLength-- != 0) {
				p1 = p1.next;
			}

			Node prev = null;
			while (p1 != p2) {
				prev = p1;
				p1 = p1.next;
				p2 = p2.next;
			}
			prev.next = null;
			return root;
		}
		return null;
	}

	public static Node deleteNodesHavingGreaterValueOnRight(Node root) {
		Node tmpNode = root;

		Node reverse = reverseLinkedListIteratively(root);

		Node revTmpNode = reverse;

		Node prev = revTmpNode;
		int max = prev.data;
		revTmpNode = revTmpNode.next;
		while (revTmpNode != null) {
			if (max < revTmpNode.data) {
				max = revTmpNode.data;
				prev = revTmpNode;
				revTmpNode = revTmpNode.next;
			} else {
				Node next = revTmpNode.next;
				prev.next = next;
				revTmpNode = next;
			}
		}
		return reverseLinkedListIteratively(reverse);
	}

	public static Node pairwiseSwap(Node root) {

		if (root == null || root.next == null) {
			return root;
		}

		Node tmp = root;
		Node prev = tmp;
		tmp = tmp.next;
		root = tmp;
		Node next = tmp;

		while (tmp != null) {
			next = tmp.next;
			tmp.next = prev;

			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			prev.next = next.next;
			prev = next;
			tmp = prev.next;
		}

		return root;

	}

	public static boolean isHappyNumber(int num) {
		Set<Integer> set = new HashSet<Integer>();

		int res = 0;
		while (res != 1) {
			res = 0;
			while (num > 0) {
				int rem = num % 10;
				res = rem * rem + res;
				num = num / 10;
			}
			if (set.contains(res)) {
				return false;
			}
			set.add(res);
			num = res;

		}
		if (num == 1) {
			return true;
		}
		return false;
	}

	public static boolean isLLPalindrome(Node root) {
		Node tmpRoot = root;
		Node midNode = getMiddleNode(tmpRoot);

		Node midNodeReverse = reverseLinkedListIteratively(midNode);

		Node copyMidNodeReverse = midNodeReverse;

		while (tmpRoot != null && midNodeReverse != null) {
			if (tmpRoot.data != midNodeReverse.data) {
				midNode = reverseLinkedListIteratively(copyMidNodeReverse);
				return false;
			}
			tmpRoot = tmpRoot.next;
			midNodeReverse = midNodeReverse.next;
		}
		midNode = reverseLinkedListIteratively(copyMidNodeReverse);
		return true;
	}

	public static Node rearrangeLL(Node root) {
		Node tmpRoot = root;
		Node midNode = getMiddleNode(tmpRoot);
		Node midNodeReverse = reverseLinkedListIteratively(midNode);

		while (tmpRoot != null && midNodeReverse != null) {
			Node rootNext = tmpRoot.next;
			Node midrevNext = midNodeReverse.next;
			tmpRoot.next = midNodeReverse;
			midNodeReverse.next = rootNext;
			tmpRoot = rootNext;
			midNodeReverse = midrevNext;
		}

		return root;
	}

	public static Node reverse(Node root) {
		Node curr = root;
		Node prev = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static Node reverseSubList(Node root, int p, int q) {
		if (root == null) {
			return root;
		}

		if (p <= 0 || q <= 0 || p > length || q > length) {
			return reverse(root);
		}

		Node prev = null;
		Node curr = root;

		int count = 0;

		Node firstPrev = null;
		while (count != p - 1) {
			firstPrev = curr;
			curr = curr.next;
			count++;
		}
		Node lastNodeOfSubList = curr;
		while (count != q) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (firstPrev != null) {
			firstPrev.next = prev;
		} else {
			root = prev;
		}

//		while (prev.next != null) {
//			prev = prev.next;
//		}

		lastNodeOfSubList.next = curr;

		return root;

	}

	public static Node reverseKSubList(Node root, int k) {

		int count = 0;
		Node curr = root;
		Node tmpLastNodeOfSubList = null;

		while (curr != null) {
			Node lastNodeOfSubList = curr;

			Node prev = null;

			while (count != k && curr != null) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			count = 0;

			if (tmpLastNodeOfSubList != null) {
				tmpLastNodeOfSubList.next = prev;
			} else {
				root = prev;
			}

			tmpLastNodeOfSubList = lastNodeOfSubList;
			lastNodeOfSubList.next = curr;
		}
		return root;
	}

	public static Node reverseAlternateKNodes(Node root, int k) {

		if (root == null || k <= 1) {
			return root;
		}

		Node curr = root;
		Node lastNodeOfSubList = curr;
		Node prev = null;
		int count = 0;
		Node startNode = null;
		boolean flag = false;
		Node endNodeOfReverse = null;

		while (curr != null) {

			while (count != k && curr != null) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}

			if (flag) {
				lastNodeOfSubList.next = prev;
			} else {
				lastNodeOfSubList.next = curr;
				flag = true;
			}

			if (endNodeOfReverse != null) {
				endNodeOfReverse.next = curr;
			}

			if (startNode == null) {
				startNode = prev;
			}

			count = 0;
			prev = null;

			while (count != k && curr != null) {
				lastNodeOfSubList = curr;
				curr = curr.next;
				endNodeOfReverse = curr;
				count++;
			}

			count = 0;
		}

		return startNode;
	}

	public static boolean cycleInCircularArray(int[] arr) {
		int start = 0, slow = 0, fast = 0;

		do {
			slow = move(arr[slow], slow, arr);
			fast = move(arr[fast], fast, arr);
			fast = move(arr[fast], fast, arr);
		} while (slow != fast);

		if (slow == fast) {
			return true;
		}
		return false;
	}

	private static int move(int value, int index, int[] arr) {
		int newIndex = index + value;
		if (newIndex < 0) {
			newIndex = arr.length - newIndex;
		} else if (newIndex > arr.length - 1) {
			newIndex = (index + value) % arr.length;
		}
		return newIndex;
	}

	public static Node mergeInBetween(Node list1, Node list2, int a, int b) {
		// Write your code here
		if (list1 == null || list2 == null) {
			return null;
		}

		Node head = list1;
		Node prevlist1 = null;

		while (list1 != null && (list1.data != a && list1.data != b) && list1.next != null) {
			prevlist1 = list1;
			list1 = list1.next;
		}

		Node nextList1 = list1;

		if (nextList1 != null)
			nextList1 = nextList1.next;

		while (nextList1 != null && (nextList1.data != a && nextList1.data != b) && nextList1.next != null) {
			nextList1 = nextList1.next;
		}

		if (nextList1 != null) {
			nextList1 = nextList1.next;
		}
		Node head2 = list2;

		while (list2.next != null) {
			list2 = list2.next;
		}

		if (prevlist1 != null) {
			prevlist1.next = head2;
		} else {
			head = head2;
		}

		if (nextList1 != null)
			list2.next = nextList1;

		return head;

	}

	public static Node clone(Node node) {

		Node tmpNode = node;

		Node copyNodeHead = null;
		Node copyNodeTail = null;

		Map<Node, Node> map = new HashMap<Node, Node>();

		while (tmpNode != null) {
			Node newNode = new Node(tmpNode.data);

			if (copyNodeHead == null) {
				copyNodeHead = newNode;
				copyNodeTail = newNode;
			} else {
				copyNodeTail.next = newNode;
				copyNodeTail = copyNodeTail.next;
			}
			copyNodeTail.arbitary = tmpNode.arbitary;

			map.put(tmpNode, copyNodeTail);

			tmpNode = tmpNode.next;
		}

		Node currentCopyNode = copyNodeHead;
		Node currentNode = node;

		while (currentNode != null) {
			currentCopyNode.arbitary = map.get(currentNode.arbitary);
			currentNode = currentNode.next;
			currentCopyNode = currentCopyNode.next;
		}

		return copyNodeHead;
	}

	public static String reverseTheVowels(String s) {

		// Write your code here

		int k = 0;
		char[] str = s.toCharArray();
		String vowel = "";
		for (int i = 0; i < str.length; i++) {
			if (isVowel(str[i])) {
				k++;
				vowel += str[i];
			}
		}

		for (int i = 0; i < str.length; i++) {
			if (isVowel(str[i])) {
				str[i] = vowel.charAt(--k);
			}
		}

		return String.valueOf(str);

	}

	public static boolean isVowel(char c) {
		return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U');
	}

	public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
		// Write your code here

		List<String> res = new ArrayList<String>();

		outer: for (int i = 0; i < s.size(); i++) {
			String sStr = s.get(i);
			String tStr = t.get(i);

			Map<Character, Integer> smap = new HashMap<>();
			Map<Character, Integer> tmap = new HashMap<>();

			for (int j = 0; j < sStr.length(); j++) {
				smap.put(sStr.charAt(j), smap.getOrDefault(sStr.charAt(j), 0) + 1);
			}

			for (int j = 0; j < tStr.length(); j++) {
				tmap.put(tStr.charAt(j), tmap.getOrDefault(tStr.charAt(j), 0) + 1);
			}

			if (smap.size() >= tmap.size()) {
				for (Entry entry : smap.entrySet()) {
					if (tmap.get(entry.getKey()) == null) {
						if ((Integer) entry.getValue() > 3) {
							res.add("NO");
							break outer;
						}

					}
					if (tmap.get(entry.getKey()) != null
							&& Math.abs((Integer) entry.getValue() - (Integer) tmap.get(entry.getKey())) > 3) {
						res.add("NO");
						break outer;
					}

				}

			} else {
				for (Entry entry : tmap.entrySet()) {

					if (smap.get(entry.getKey()) == null) {
						if ((Integer) entry.getValue() > 3) {
							res.add("NO");
							break outer;
						}

					}

					if (smap.get(entry.getKey()) != null
							&& Math.abs((Integer) entry.getValue() - (Integer) smap.get(entry.getKey())) > 3) {
						res.add("NO");
						break outer;
					}
				}
			}
			res.add("YES");
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		List<String> t = new ArrayList<String>();

		s.add("dddd");
//		s.add("aaaaabb");

//		t.add("bbabbc");
		t.add("klmn");

		System.out.println(areAlmostEquivalent(s, t));
//		System.out.println(reverseTheVowels("aeiou"));
	}

//	public static Node getUnionOfLL(Node a, Node b) {
//		Node resNode = null;
//		Node tmpNode = null;
//
//		while (a != null && b != null) {
//			if (a.data < b.data) {
//				if (tmpNode == null) {
//					tmpNode = new Node(a.data);
//					resNode = tmpNode;
//				} else {
//					tmpNode.next = new Node(a.data);
//					a = a.next;
//				}
//
//			} else if (a.data > b.data) {
//				if (tmpNode == null) {
//					tmpNode = new Node(b.data);
//					resNode = tmpNode;
//				} else {
//					tmpNode.next = new Node(b.data);
//					b = b.next;
//				}
//
//			} else {
//				if (tmpNode == null) {
//					tmpNode = new Node(b.data);
//					resNode = tmpNode;
//				} else {
//					tmpNode.next = new Node(b.data);
//					b = b.next;
//					a = a.next;
//				}
//			}
//		}
//		resNode.next = (a != null) ? a.next : b.next;
//		return resNode;
//	}

}
