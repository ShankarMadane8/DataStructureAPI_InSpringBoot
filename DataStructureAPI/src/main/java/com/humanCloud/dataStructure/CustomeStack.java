package com.humanCloud.dataStructure;

import com.humanCloud.customeException.EmptyStackException;

public class CustomeStack {

	private int dynamicSize;
	private int stackArray[];
	private int top;

	public CustomeStack() {
		this(5);
	}

	public CustomeStack(int initalSize) {
		this.dynamicSize = initalSize;
		this.stackArray = new int[initalSize];
		this.top = -1;
	}

	public void push(int val) {

		if (!isFull()) {
			stackArray[++top] = val;
		} else {
			reSize(dynamicSize * 2);
			push(val);
		}

	}

	public int pop() throws EmptyStackException {
		if (!isEmpty()) {
			return stackArray[top--];
		} else {
			// System.out.println("The stack is already empty");
			throw new EmptyStackException("The stack is empty");
			// return -1;
		}
	}

	public int peek() throws EmptyStackException {
		if (!isEmpty()) { // Checks for an empty stack
			return stackArray[top];
		} else {
			// System.out.println("The stack is empty, cant peek");
			throw new EmptyStackException("The stack is empty, can not peek value");
			// return -1;
		}
	}

	public void reSize(int newDynamicSize) {
		int newStackArray[] = new int[newDynamicSize];
		for (int i = 0; i < stackArray.length; i++) {
			newStackArray[i] = stackArray[i];

		}
		stackArray = newStackArray;
		dynamicSize = newDynamicSize;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top + 1 == dynamicSize;
	}

	public int[] display() throws EmptyStackException {
		int[] newArray = new int[top + 1];
		if (!isEmpty()) {
			for (int i = 0; i <= top; i++) {
				System.out.print(stackArray[i] + " ");
				newArray[top - i] = stackArray[i];
			}
			return newArray;
		} else {
			// System.out.println("The stack is already empty");
			throw new EmptyStackException("The stack is empty");
			// return -1;
		}

	}

}
