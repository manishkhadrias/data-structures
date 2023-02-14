package com.khadrias.ds.queue;

import java.util.Stack;

class Queue2<T> {
	private Stack<T> s1, s2;

	// Constructor
	Queue2() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	// Add an item to the queue
	public void enqueue(T data) {
		// push item into the first stack
		s1.push(data);
	}

	// Remove an item from the queue
	public T dequeue() {
		// if both stacks are empty
		if (s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Underflow!!");
			System.exit(0);
		}

		// if the second stack is empty, move elements from the first stack to it
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		// return the top item from the second stack
		return s2.pop();
	}

	public static void main(String[] args) {
		int[] keys = { 1, 2, 3, 4, 5 };
		Queue2<Integer> q = new Queue2<>();

		// insert above keys
		for (int key : keys) {
			q.enqueue(key);
		}

		System.out.println(q.dequeue()); // print 1
		System.out.println(q.dequeue()); // print 2
	}
}