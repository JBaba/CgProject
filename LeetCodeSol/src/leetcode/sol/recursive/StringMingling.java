package leetcode.sol.recursive;

/**
 * Sample Input #00
	abcde
	pqrst
	
	Sample Output #00
	apbqcrdset
	
	Sample Input #01
	hacker
	ranker
	
	Sample Output #01
	hraacnkkeerr
 * @author nviradia
 *
 */
public class StringMingling {

	public StringMingling() {
	}

	/**
	 * Merge two strings
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String mingle(String s1,String s2){
		if(s1.length()==0)
			return "";
		return s1.charAt(0)+""+s2.charAt(0)+""+mingle(s1.substring(1), s2.substring(1));
	}
	
	public static void main(String[] args) {
		System.out.println(mingle("abc", "abc"));
		System.out.println(mingle("hacker", "ranker"));
	}

}
