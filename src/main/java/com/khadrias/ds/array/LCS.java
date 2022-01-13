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
		int nums[] = { -1, 0, 49, 1, 3, 200, 2, 4, 70, 5 };
		System.out.println("Array elements are: " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
		System.out.println("length of Longest Consecutive Subsequence: " + longestSequence(nums));
		int nums1[] = { -6, 49, -1, 200, -2, -4, 70, -5, 0 };
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
//		String lcs = "";
//		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int length = 1;
//				lcs = "" + num;

				while (set.contains(++num)) {
					length++;
//					lcs += " " + num;
				}
				longestSequenceLength = Math.max(longestSequenceLength, length);
//				ArrayList<String> list;
//				if (map.containsKey(length)) {
//					list = map.get(length);
//				} else {
//					list = new ArrayList<>();
//				}
//				list.add(lcs);
//				map.put(length, list);
			}
		}
		// System.out.println("Longest Consecutive Subsequences : " +
		// map.get(longestSequenceLength).get(longestSequenceLength));
		return longestSequenceLength;
	}
}
