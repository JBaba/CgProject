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
	
	Map<Integer,String> initNumbers = new HashMap<Integer,String>();
	
	public N_12() {
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
	
	public String intToRoman(int num) {
		return null;
	}

	public static void main(String[] args) {
		N_12 n = new N_12();
		System.out.println(n.intToRoman(1));
	}

}
