package com.khadrias.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLengthFromArray {

	Set<Integer> visited = new HashSet<>();

	private int length(int[] ints, int index) {
		if (visited.contains(index))
			return 1;
		visited.add(index);
		if (ints[index] == -1)
			return 1;
		return 1 + length(ints, ints[index]);
	}

	public int findLength(int[] ints) {
		return length(ints, 0);
	}

	public static void main(String[] args) {
		System.out.println(new LinkedListLengthFromArray().findLength(new int[] { 2, -1, 3, 1, 5 }));
		System.out.println(new LinkedListLengthFromArray().findLength(new int[] { 2, 0, 3, 1, 5 }));
	}

}
