package leetcode.sol.string;

import java.util.Scanner;

public class StringRev {

	public StringRev() {
	}
	
	// Reverse string
	public static String reverseString(String s){
		return (s.length()==0)?"":reverseString(s.substring(1))+s.charAt(0);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your String : ");
		String input = sc.next();
		System.out.println(reverseString(input));
		
	}

}
