package com.khadrias.ds.maths;

public class CountDigit {

	public static void main(String[] args) {
		System.out.println(countDigit(1989787667));
	}

	// o(n)
	public static int countDigit(long number) {
		int count = 0;
		while (number > 0) {
			count++;
			number /= 10;
		}
		return count;
	}
}
