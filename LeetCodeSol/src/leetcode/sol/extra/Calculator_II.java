package leetcode.sol.extra;

/**
 * Implement a basic calculator to evaluate a simple expression string.
	
	The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
	
	You may assume that the given expression is always valid.
	
	Some examples:
	"3+2*2" = 7
	" 3/2 " = 1
	" 3+5 / 2 " = 5
	Note: Do not use the eval built-in library function.
	
 * @author jbaba
 *
 */

public class Calculator_II {

	 public int calculate(String s) {
		
		 s = s.replace(" ", "");
		 System.out.println(s);
		 
		 while (s.length() != 1) {
			 if(s.contains("*")){
				 
			 }
		 }
		 
		return 0;  
	 }
	
	public static void main(String[] args) {
		Calculator_II c2 = new Calculator_II();
		System.out.println(c2.calculate("3+2*2"));
		System.out.println(c2.calculate(" 3/2 "));
		System.out.println(c2.calculate(" 3+5 / 2 "));
	}

}
