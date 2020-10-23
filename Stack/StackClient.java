package Stack;

import LinkedList.LinkedList;
import LinkedList.Node;

public class StackClient {

	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>(Integer.class, 5);
//		
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		stack.push(6);
//		stack.push(7);
//		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}

//		StackLL stack = new StackLL();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		
//		while(stack.head!=null) {
//			System.out.print(stack.pop()+"->");
//		}

		// System.out.println(reverseString("abcd"));
//		LinkedList ll = new LinkedList();
//		Node head = LinkedList.insertNodeAtEnd(null, 1);
//		head = LinkedList.insertNodeAtEnd(head, 2);
//		head = LinkedList.insertNodeAtEnd(head, 3);
//		head = LinkedList.insertNodeAtEnd(head, 4);
//		head = LinkedList.insertNodeAtEnd(head, 5);
//
//		head = reverseLL(head);

//		System.out.println(balanceParanthesisExp("[{(A+B)*(Z}"));
		System.out.println(evaluationOfPrefix("-+*23*549"));

	}

	public static int evaluationOfPrefix(String str) {
		Stack<Integer> stack = new Stack<Integer>(Integer.class, 100);
		char[] chArr = str.toCharArray();
		int resultValue = 0;
		int op1 = 0;
		int op2 = 0;

		for (int i = str.length() - 1; i >= 0; i--) {
			if (chArr[i] == '*' || chArr[i] == '/' || chArr[i] == '+' || chArr[i] == '-' || chArr[i] == '^') {
				op1 = stack.pop();
				op2 = stack.pop();

				switch (chArr[i]) {
				case '*':
					resultValue = op1 * op2;
					stack.push(resultValue);
					break;

				case '/':
					resultValue = op1 / op2;
					stack.push(resultValue);
					break;
				case '+':
					resultValue = op1 + op2;
					stack.push(resultValue);
					break;
				case '-':
					resultValue = op1 - op2;
					stack.push(resultValue);
					break;
				case '^':
					resultValue = op1 ^ op2;
					stack.push(resultValue);
					break;
				default:
					break;
				}
			} else {
				stack.push(Character.digit(chArr[i], 10) );
			}
		}
		
		return resultValue;
	}

	public static boolean balanceParanthesisExp(String str) {
		Stack<Character> stack = new Stack<Character>(Character.class, 100);

		for (char ch : str.toCharArray()) {
			if (ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '(' || ch == ')') {
				if (ch == '[' || ch == '{' || ch == '(') {
					stack.push(ch);
				} else {
					if (ch == ']') {
						if (stack.top() != '[') {
							return false;
						}
						stack.pop();
					} else if (ch == '}') {
						if (stack.top() != '{') {
							return false;
						}
						stack.pop();
					} else if (ch == ')') {
						if (stack.top() != '(') {
							return false;
						}
						stack.pop();
					}
				}
			}
		}
		return stack.isEmpty();
	}

	private static Node reverseLL(Node head) {

		Node tmpHead = head;
		Stack<Node> stack = new Stack<Node>(Node.class, 100);
		while (tmpHead.next != null) {
			stack.push(tmpHead);
			tmpHead = tmpHead.next;
		}

		Node root = tmpHead;
		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			tmpHead.next = tmp;
			tmpHead = tmpHead.next;
		}
		tmpHead.next = null;
		return root;
	}

	private static String reverseString(String str) {
		Stack<Character> stack = new Stack<Character>(Character.class, 100);

		for (char ch : str.toCharArray()) {
			stack.push(ch);
		}

		StringBuilder strB = new StringBuilder();
		while (!stack.isEmpty()) {
			strB = strB.append(stack.pop());
		}
		return new String(strB);
	}

}
