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
	public static StringBuffer mingle(String s1,String s2){
		if(s1.length()==0)
			return new StringBuffer();
		return (new StringBuffer()).append(s1.charAt(0)).append(s2.charAt(0)).append(mingle(s1.substring(1), s2.substring(1)));
	}
	
	public static void main(String[] args) {
		System.out.println(mingle("abc", "abc"));
		System.out.println(mingle("hacker", "ranker"));
	}

}
