package com.deloitte.elements.eng;

public class E_2_Conversation {


	
	public static void main(String[] args) {
		String numS = intToString(-51);
		System.out.println(numS);
		
		int numN = StringToInt("-51");
		System.out.println(numN);
	}

	private static int StringToInt(String string) {
		
		int result = 0;
		
		for(int i = ((string.indexOf("-") == 0) ? 1 : 0) ; i < string.length() ; i++){
			int digit = string.charAt(i) - '0';
			result = (result * 10) + digit;
		}
		
		return (string.indexOf("-") == 0) ? -result : result;
	}

	private static String intToString(int i) {
		String result = "";
		
		boolean isNagative = false;
		
		if(i < 0)
			isNagative = true;
		
		while (i!=0) {
			int digit = Math.abs(i%10);
			result = digit+result;
			i = i/10;
		}
		
		return isNagative ? "-"+result : result;
	}

}
