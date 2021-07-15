package com.khadrias.ds.array;

import java.util.ArrayList;

/**
 * @author manishkhadria
 * 
 *         Amazon Interview Find longest sequence of 1’s with one flip
 *
 */
public class LSOnes {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 0, 1, 0, 1, 1, 0, 1, 0 }; // input

		// first convert the problem into onesTotal array
		ArrayList<Integer> convertedList = new ArrayList<Integer>();

		int OnesTotal = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				OnesTotal++;
				// if last element is 1
				if (OnesTotal > 0 && i == arr.length - 1) {
					convertedList.add(OnesTotal);
				}
			} else {
				if (OnesTotal > 0) {
					convertedList.add(OnesTotal);
				}
				convertedList.add(arr[i]);
				OnesTotal = 0;
			}
		}

		System.out.println("Converted List " + convertedList);
		int longestSequence = 0;
		for (int i = 0; i < convertedList.size(); i = i + 2) {
			int len = convertedList.get(i);
			if ((i + 1) < convertedList.size()) {
				len += 1;
			}
			if ((i + 2) < convertedList.size()) {
				len += convertedList.get(i + 2);
			}
			if (len > longestSequence) {
				longestSequence = len;
			}
		}
		System.out.println("Longest Sequence: " + longestSequence);

	}

}