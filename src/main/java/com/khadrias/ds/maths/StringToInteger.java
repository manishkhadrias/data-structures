package com.khadrias.ds.maths;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(StringToInteger.parseInt("1234"));
		System.out.println(StringToInteger.parseIntChar("AB"));
	}

	private static int parseIntChar(String string) {

		int sum = 0;
		int power = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			sum += Math.pow(26, power) * (string.charAt(i) - ('A' - 1));
			power++;
		}
		return sum;
	}

	private static int parseInt(String string) {

		int sum = 0;
		int power = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			sum += Math.pow(10, power) * (string.charAt(i) - '0');
			power++;
		}
		return sum;
	}

}
