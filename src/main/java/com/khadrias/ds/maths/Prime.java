package com.khadrias.ds.maths;

public class Prime {

	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor: " + isPrime(37));
		System.out.println("Greatest Common Divisor: " + isPrimeOptimized(37));
	}

	// o(n)
	public static boolean isPrime(int number) {
		if (number == 1)
			return false;
		for (int i = 2; i < number; i++)
			if (number % i == 0)
				return false;
		return true;
	}

	// o(square root of n)
	public static boolean isPrimeOptimized(int number) {
		if (number == 1)
			return false;
		for (int i = 2; i * i <= number; i++)
			if (number % i == 0)
				return false;
		return true;
	}
}
