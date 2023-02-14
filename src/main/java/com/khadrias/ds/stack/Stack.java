package com.khadrias.ds.stack;

import java.util.ArrayDeque;
import java.util.Queue;

// Implement stack using two queues
class Stack<T> {
	Queue<T> q1, q2;

	// Constructor
	public Stack() {
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
	}

	// Insert an item into the stack
	void add(T data) {
		// Move all elements from the first queue to the second queue
		while (!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.poll();
		}

		// Push the given item into the first queue
		q1.add(data);

		// Move all elements back to the first queue from the second queue
		while (!q2.isEmpty()) {
			q1.add(q2.peek());
			q2.poll();
		}
	}

	// Remove the top item from the stack
	public T poll() {
		// if the first queue is empty
		if (q1.isEmpty()) {
			System.out.println("Underflow!!");
			System.exit(0);
		}

		// return the front item from the first queue
		T front = q1.peek();
		q1.poll();

		return front;
	}

	public static void main(String[] args) {
		int[] keys = { 1, 2, 3, 4, 5 };

		// insert the above keys into the stack
		Stack<Integer> s = new Stack<>();
		for (int key : keys) {
			s.add(key);
		}

		for (int i = 0; i < keys.length; i++) {
			System.out.println(s.poll());
		}
	}
}