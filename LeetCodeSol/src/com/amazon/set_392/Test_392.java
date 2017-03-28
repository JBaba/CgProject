package com.amazon.set_392;

public class Test_392 {

	public static void main(String[] args) {
		int ps = 10;
		BuddyMemmoryManagement ms =new BuddyMemmoryManagement(4, 128);
		System.out.println(ms.findClosestPowerOf2(ps));
		System.out.println(Functions.log2(128) + 1);
		ms.allocateMemory(10, 1);
		ms.allocateMemory(110, 2);
	}
	
}
