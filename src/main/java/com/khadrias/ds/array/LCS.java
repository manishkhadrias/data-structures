/**
 * 
 */
package com.khadrias.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @author manishkhadria
 *
 *         Longest Consecutive Subsequence
 */
public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = { 49, 1, 3, 200, 2, 4, 70, 5 };
		System.out.println("Array elements are: " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
		System.out.println("length of Longest Consecutive Subsequence: " + longestSequence(nums));
		int nums1[]= { 49, -1, -3, 200, -2, -4, 70, -5 };
		System.out.println("length of Longest Consecutive Subsequence: " + longestSequence1(nums1));

	}

	public static int longestSequence(int[] nums) {
		final HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			set.add(i);

		int longestSequenceLength = 0;
		for (int i : nums) {
			int length = 1;
			for (int j = i - 1; set.contains(j); --j) {
				set.remove(j);
				++length;
			}
			for (int j = i + 1; set.contains(j); ++j) {
				set.remove(j);
				++length;
			}
			longestSequenceLength = Math.max(longestSequenceLength, length);
		}
		return longestSequenceLength;
	}

	public static int longestSequence1(int[] nums) {
		final HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			set.add(i);

		int longestSequenceLength = 0;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int length = 1;
				while (set.contains(currentNum + 1)) {
					currentNum += 1;
					length += 1;
				}
				longestSequenceLength = Math.max(longestSequenceLength, length);
			}
		}
		return longestSequenceLength;
	}
}
