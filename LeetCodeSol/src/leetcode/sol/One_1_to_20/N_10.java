package leetcode.sol.One_1_to_20;

/**
 * 	Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 * 
 *  Q: https://leetcode.com/problems/regular-expression-matching/
 * @author nviradia
 *
 */
public class N_10 {
	
	public N_10() {
	}
	
	public boolean isMatch(String s, String p) {
		
		if(!p.contains(".") && !p.contains("*") && s.length()!=p.length())
			return false;
		if(!p.contains(".") && !p.contains("*") && s.length()==p.length())
			return s.equals(p);
		if(!p.contains("*") && p.length()==1)
			return true;
		
		boolean ans = true;
		
		if(!p.contains(".")){
			int index = 0;
			boolean findNextMatch = false;
			for(int i=0;i<p.length() && index<s.length();i++){
				char c = p.charAt(i);
				if(c == '*'){
					findNextMatch = true;
					if(i == (p.length()))
						return true;
					continue;
				}else if(c == s.charAt(index)){
					index++;
				}else{
					return false;
				}
			}
			return ans;
		}
		
		return false;
    }

	public static void main(String[] args) {

		N_10 n = new N_10();
		
		boolean ans = false;
		
		ans = n.isMatch("aa","a");
		System.out.println("isMatch('aa','a') → false :->"+ans);
		ans = n.isMatch("aa","aa");
		System.out.println("isMatch('aa','aa') → true :->"+ans);
		ans = n.isMatch("aaa","aa");
		System.out.println("isMatch('aaa','aa') → false :->"+ans);
		ans = n.isMatch("aa", "a*");
		System.out.println("isMatch('aa', 'a*') → true :->"+ans);
		ans = n.isMatch("aa", "b*");
		System.out.println("isMatch('aa', 'b*') → true :->"+ans);
		ans = n.isMatch("aa", ".*");
		System.out.println("isMatch('aa', '.*') → true :->"+ans);
		ans = n.isMatch("ab", ".*");
		System.out.println("isMatch('ab', '.*') → true :->"+ans);
		ans = n.isMatch("aab", "c*a*b");
		System.out.println("isMatch('aab', 'c*a*b') → true :->"+ans);
	}

}
