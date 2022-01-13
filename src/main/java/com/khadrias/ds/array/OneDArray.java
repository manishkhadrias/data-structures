/**
 * 
 */
package com.khadrias.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author manishkhadria
 *
 */
public class OneDArray {

	public static void main(String[] args) {
		// int[] nums = new int[] {1,2,3,4,5};
		int[] nums = new int[5];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		for (int num : nums) {
			System.out.print(num + " ");
		}

		List<Integer> list11 = Arrays.stream(nums).boxed().collect(Collectors.toList());

		list11.add(6);

		System.out.println("\n" + list11);

		Integer[] integers = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> list21 = Arrays.asList(integers); // returns a fixed-size list backed by the specified array.
		List<Integer> list22 = new ArrayList<>(Arrays.asList(integers)); // good
		// list21.add(5); // java.lang.UnsupportedOperationException
		list22.add(6);

		// The method println(char[]) is ambiguous for the type PrintStream
//		System.out.println(null); 
		String s = null;
		System.out.println(s);
		System.out.println("null");
	}

}
