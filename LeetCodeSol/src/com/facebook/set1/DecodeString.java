package com.facebook.set1;

/**
 * 
 * Examples:

	Input : str[] = "1[b]"
	Output : b
	
	Input : str[] = "2[ab]"
	Output : abab
	
	Input : str[] = "2[a2[b]]"
	Output : abbabb
	
	Input : str[] = "3[b2[ca]]"
	Output : bcacabcacabcaca
 * 
 * @author nviradia
 *
 */

public class DecodeString {

	public static void main(String[] args) {

		String input = "";
		
		input = "1[b]";
		decodeString(input);
		
		input = "2[ab]";
		decodeString(input);
		
		input = "2[a2[b]]";
		decodeString(input);
		
		input = "3[b2[ca]]";
		decodeString(input);
		
	}

	
	private static void decodeString(String input) {
		int num = input.charAt(0)-'0';
		decodeString(num,input.substring(2, input.length()-1));
		System.out.println();
	}


	private static void decodeString(int num, String input) {
		
		if(input.length()<=0){
			return;
		}
		
		for(int i=0;i<num;i++){
			
			int indexOfBracket = input.indexOf('[');
			
			String pre = input;
			
			if(indexOfBracket != -1)
				pre = input.substring(0,indexOfBracket-1);
			
			System.out.print(pre);
			
			if(indexOfBracket != -1){
				int nextNum = input.charAt(indexOfBracket-1)-'0';
				String nextInput = input.substring(indexOfBracket+1,input.length()-1);
				decodeString(nextNum,nextInput);
			}
		}
		
	}

}
