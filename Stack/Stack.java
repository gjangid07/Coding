package Stack;

import java.lang.reflect.Array;

public class Stack<T> {

	private T[] stack;
	private int capacity;
	private int top;

	public Stack(Class<T> clazz, int c) {
		capacity = c;
		stack = (T[]) Array.newInstance(clazz, c);
		top = -1;
	}

	public boolean push(T t) {
		if (!isFull()) {
			stack[++top] = t;
			return true;
		}
		System.out.println("Error: Stack is full and Can't push more!");
		return false;
	}

	public T pop() {
		T t = null;
		if (!isEmpty()) {
			t = stack[top--];
		}else {
			System.out.println("Error: Stack is empty and Can't pop more!");
		}
		return t;
	}

	public T top() {
		T t = null;
		if (!isEmpty()) {
			t = stack[top];
		}
		return t;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top == capacity - 1) {
			return true;
		}
		return false;
	}
}
