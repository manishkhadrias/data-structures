package com.khadrias.ds.recursion;

public class PrintPattern {

	public void printPattern(int n) {
		if (n <= 0)
			return;
		printPattern(n - 1);
		if (n % 2 == 0) {
			System.out.print("Codility");
		}
		if (n % 3 == 0) {
			System.out.print("Test");
		}
		if (n % 5 == 0) {
			System.out.print("Coders");
		}
		if (n % 5 != 0 && n % 3 != 0 && n % 2 != 0) {
			System.out.print(n);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		new PrintPattern().printPattern(15);
	}

}
