package String;

import java.util.Stack;

public class StringProblems {

	public static void main(String[] args) {
		System.out.println(reverseWordsInSentence(" Hello World asdf "));
	}

	private static String reverseWordsInSentence(String str) {
		Stack<String> stack = new Stack<>();
		for (int i = 0, j = 0; i < str.length() && j <= str.length();) {
			if (j==str.length() || str.charAt(j) == ' ' ) {
				stack.push(str.substring(i, j));
				i=j;
				i++;
			}
			j++;
		}
		
		StringBuilder strB = new StringBuilder();
		while(!stack.isEmpty()) {
			strB.append(stack.pop());
			strB.append(" ");
		}
		return new String(strB);
	}
}
