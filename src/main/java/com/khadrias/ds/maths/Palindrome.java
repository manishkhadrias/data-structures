package com.khadrias.ds.maths;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(palindrome(String.valueOf(1112111)));
	}

	// o(n/2)
	public static boolean palindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				System.out.println(i);
				return false;
			}
		}
		return true;
	}
}
