package com.khadrias.ds.maths;

public class GCDEuclidenAlgo {

	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor: " + findGCDOptimized(1, 0));
	}

	public static int findGCD(int i, int j) {
		
		while (i != j) {
			if (i > j)
				i = i - j;
			else
				j = j - i;
		}

		return i;
	}

	public static int findGCDOptimized(int i, int j) {
		if (j == 0)
			return i;
		else
			return findGCDOptimized(j, i % j);

	}
}
