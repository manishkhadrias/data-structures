package com.khadrias.ds.stack;

import java.util.Stack;

public class BalanceParanthesis {

	public static boolean balance(String str) {

		Stack<Character> s = new Stack<Character>();

		for (Character c : str.toCharArray()) {

			if (c.equals('{') || c.equals('(') || c.equals('[')) {
				s.push(c);
			} else if (c.equals('}')) {
				if (s.pop() == '{')
					continue;
				else
					return false;
			} else if (c.equals(')')) {
				if (s.pop() == '(')
					continue;
				else
					return false;
			} else if (c.equals(']')) {
				if (s.pop() == '[')
					continue;
				else
					return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {

		System.out.println(BalanceParanthesis.balance("[{()}]"));
	}
}