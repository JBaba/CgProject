package leetcode.sol.One_1_to_20;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * @author nviradia
 *
 */

public class Five {

	public String longestPalindrome(String s) {
		
		String longestPalindrome = "";
		
		if(s.length()==1 || s.length()==0 || s.trim().length()==0){
			return s;
		}
		
		for(int i=0;i<s.length();i++){
			int index = isPalindromeOdd(i,s);
			String temp = s.substring(i-index,i+index+1);
			if(longestPalindrome.length()<temp.length()){
				longestPalindrome = temp;
			}
			
			index = isPalindromeEven(i,s);
			if(index != 0){
				temp = s.substring(i-(index-1),i+index+1);
				if(longestPalindrome.length()<temp.length()){
					longestPalindrome = temp;
				}
			}
		}
		
		return longestPalindrome;
    }
	
	private int isPalindromeEven(int i, String s) {
		int left = i,right = i+1;
		int size = 0;
		for(int j=0;j<i+1;j++){
			try{
				char leftChar = s.charAt(left-j);
				char rightChar = s.charAt(right+j);
				if(leftChar != rightChar)
					return size;
				else
					size++;
			}catch(Exception e){
				return size;
			}
		}
		return size;
	}
	
	private int isPalindromeOdd(int i, String s) {
		int left = i,right = i;
		for(int j=0;j<i+1;j++){
			try{
				char leftChar = s.charAt(left-j);
				char rightChar = s.charAt(right+j);
				if(leftChar != rightChar)
					return j-1;
			}catch(Exception e){
				return j-1;
			}
		}
		return i;
	}

	public static void main(String[] args) {

		Five f = new Five();
		System.out.println(f.longestPalindrome("abb"));
		System.out.println(f.longestPalindrome("aa"));
		System.out.println(f.longestPalindrome("aacaa"));
		System.out.println(f.longestPalindrome("aaa"));
		
		
	}

}
