package leetcode.sol.One_1_to_20;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an integer, convert it to a roman numeral.

   Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Q : https://leetcode.com/problems/integer-to-roman/
 * 
 * @author jbaba
 *
 */
public class N_12 {
	
	// list of number to Roman latter
	Map<Integer,String> initNumbers = new HashMap<Integer,String>();
	
	public N_12() {
		// init Roman numbers
		initNumbers.put(0, "");
		initNumbers.put(1, "I");
		initNumbers.put(2, "II");
		initNumbers.put(3, "III");
		initNumbers.put(4, "IV");
		initNumbers.put(5, "V");
		initNumbers.put(6, "VI");
		initNumbers.put(7, "VII");
		initNumbers.put(8, "VIII");
		initNumbers.put(9, "IX");
		initNumbers.put(10, "X");
		initNumbers.put(50, "L");
		initNumbers.put(100, "C");
		initNumbers.put(500, "D");
		initNumbers.put(1000, "M");
	}
	
	/**
	 * Method to convert init To Roman
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		
		if(num == 0){
			return "";
		}
		
		if(initNumbers.containsKey(num)){
			return initNumbers.get(num);
		}
		
		// variable returns string
		String ans = "";
		
		// copy of number
		int copyNum = num;
		int digit = 0;
		
		// 1st digit
		digit = copyNum%10;
		copyNum = copyNum - digit;
		ans += initNumbers.get(digit);
		System.out.println("2. Num:"+copyNum+" digit:"+digit+" Ans:"+ans);
		
		// number is smaller return
		if(num < 10){
			return ans;
		}
		
		//2nd digit
		digit = copyNum%100;
		copyNum = copyNum - digit;
		
		// check for 10,50
		if(initNumbers.containsKey(digit)){
			ans = initNumbers.get(digit)+ans;
		}
		System.out.println("3. Num:"+copyNum+" digit:"+digit+" Ans:"+ans);
		
		// number is smaller return
		if(num < 100){
			return ans;
		}
		
		//3rd digit
		digit = copyNum%1000;
		copyNum = copyNum - digit;
		
		// check for 100,500
		if(initNumbers.containsKey(digit)){
			ans = initNumbers.get(digit)+ans;
		}
		System.out.println("4. Num:"+copyNum+" digit:"+digit+" Ans:"+ans);		
		
		return ans;
	}

	public static void main(String[] args) {
		N_12 n = new N_12();
		System.out.println("1 -> I :"+n.intToRoman(1));
		System.out.println("11 -> XI :"+n.intToRoman(11));
		System.out.println("14 -> XIV :"+n.intToRoman(14));
		System.out.println("16 -> XVI :"+n.intToRoman(16));
	}

}
