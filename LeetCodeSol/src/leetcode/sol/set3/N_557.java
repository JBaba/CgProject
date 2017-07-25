package leetcode.sol.set3;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

	Example 1:
	Input: "Let's take LeetCode contest"
	Output: "s'teL ekat edoCteeL tsetnoc"
	Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * @author nviradia
 *
 */

public class N_557 {

	public String reverseWords(String s) {
		String words[] = s.split(" ");
		String[] rWords = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			StringBuffer sf = new StringBuffer(words[i]);
			rWords[i]=sf.reverse().toString();
		}
		
		String result = "";
		for (int i = 0; i < rWords.length; i++) {
			result += rWords[i];
			if(i != rWords.length-1)
				result += " ";
		}
		return result;
    }
	
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		N_557 n = new N_557();
		System.out.println(n.reverseWords(s));
	}

}
