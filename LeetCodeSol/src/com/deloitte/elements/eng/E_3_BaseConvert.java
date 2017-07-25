package com.deloitte.elements.eng;

public class E_3_BaseConvert {

	public static String convertBase(String numAsString, int b1, int b2) {
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
			numAsInt *= b1;
			numAsInt += Character.isDigit(numAsString.charAt(i)) ? numAsString
					.charAt(i) - '0' : numAsString.charAt(i) - 'A' + 10;
		}
		System.out.println(numAsInt);
		return (isNegative ? "-" : "")
				+ (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
	}

	private static String constructFromBase(int numAsInt, int base) {
		return numAsInt == 0 ? "" : constructFromBase(numAsInt / base, base)
				+ (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10
						: '0' + numAsInt % base);
	}
	
	public static void main(String[] args) {
		System.out.println(convertBase("897", 10,11));
	}

}
