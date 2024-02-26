package com.khadrias.ds;

class StaticAndInitBlock {

	StaticAndInitBlock(int x) {
		System.out.println("ONE argument constructor");
	}

	StaticAndInitBlock() {
		System.out.println("No  argument constructor");
	}

	static {
		System.out.println("1st static init");
	}

	{
		System.out.println("1st instance init");
	}

	{
		System.out.println("2nd instance init");
	}

	static {
		System.out.println("2nd static init");
	}

	public static void main(String[] args) {
		new StaticAndInitBlock();
		new StaticAndInitBlock(8);
	}
}