package leetcode.sol.One_1_to_20;

/**
 * Find the Difference
 * Given two strings s and t which consist of only lowercase letters.

	String t is generated by random shuffling string s and then add one more letter at a random position.

	Find the letter that was added in t.
 * @author nviradia
 *
 */
public class N_389 {

	public char findTheDifference(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!=t.charAt(i)){
				return t.charAt(i);
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		N_389 n =new N_389();
		System.out.println(n.findTheDifference("abc", "atbc"));	
	}

}
