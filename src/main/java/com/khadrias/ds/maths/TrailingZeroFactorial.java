package com.khadrias.ds.maths;

public class TrailingZeroFactorial {

	public static void main(String[] args) {
		System.out.println(countTrailingZerosOfFactorial(25));
	}

	public static int countTrailingZerosOfFactorial(int number) {
		int res = 0;
		for (int i = 5; i <= number; i = i * 5) {
			res += number / i;
		}
		return res;
	}

}
