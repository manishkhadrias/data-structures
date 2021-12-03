package com.khadrias.ds.maths;

public class GCD {

	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor: " + findGCD(15, 35));
	}

	//o(n)
	public static int findGCD(int i, int j) {
		int res = Math.min(i, j);
		while (res > 0) {
			if (i % res == 0 && j % res == 0)
				break;
			res--;
		}

		return res;
	}

}
