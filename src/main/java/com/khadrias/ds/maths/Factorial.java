package com.khadrias.ds.maths;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(20));
	}

	//o(n)
	private static long factorial(int number) {
		long res = 1;
		while (number > 1) {
			res *= number--;
		}
		return res;
	}

}
