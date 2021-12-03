package com.khadrias.ds.maths;

public class LCM {

	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor: " + findLCM(11, 12));
		System.out.println("Greatest Common Divisor: " + findLCMByGCD(11, 12));
	}

	public static int findLCM(int i, int j) {
		int res = Math.max(i, j);
		while (true) {
			if (res % i == 0 && res % j == 0)
				return res;
			res++;
		}
	}
	
	public static int findLCMByGCD(int i, int j) {
		return i*j*GCDEuclidenAlgo.findGCDOptimized(i, j);
	}

}
