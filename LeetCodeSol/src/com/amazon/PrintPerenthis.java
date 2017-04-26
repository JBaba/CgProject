package com.amazon;

public class PrintPerenthis {

	/**
	 * 
	 * input 3 ke 2
	 * 2
	 * ()()   (())
	 * 3
	 * ()()() 
	 * (())()
	 * ()(()) 
	 * ((())) 
	 * (()())
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		//permute(3);
		int n = 3;
        char[] str = new char[100];
        printParenthesis(n);
	}
	
	static void printParenthesis(int n){
		if(n > 0)
			_printParenthesis("",n, 0, 0);
	}	 

	static void _printParenthesis(String test, int n, int open, int close)
	{
		if(close == n) 
		{
		    System.out.println(test);
			return;
		}
		else
		{
			if(open > close) {
				_printParenthesis(test+")", n, open, close+1);
			}
			if(open < n) {
				_printParenthesis(test+"(", n, open+1, close);
			}
		}
	}

	private static void permute(int k) {
		String input = "";
		for(int i=0;i<k;i++)
			input+="()";
		System.out.println(input);
		
		permute(input,"",2);
	}

	private static void permute(String pre,String suf,int st) {
		if(pre.length() < 0)
			return;
		for(int j=st;j<pre.length();j+=2)
		for(int i=j;i<pre.length();i+=j){
			suf = pre.substring(i+1);
			String ans = print(pre, i-(j-1), i);
			permute(ans,"",i+j);
		}
	}

	private static String print(String input, int i, int j) {
		char c1 = input.charAt(i);
		char c2 = input.charAt(j);
		String ans = input.substring(0, i)+c2+input.substring(i+1, j)
				+c1+input.substring(j+1); 
		System.out.println(ans);
		return ans;
	}

}
