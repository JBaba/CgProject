package leetcode.sol.One_1_to_20;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

	Examples:
	
	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer 
	must be a substring, "pwke" is a subsequence and not a substring.
	
 * @author nviradia
 *
 */

public class Three {

	public int lengthOfLongestSubstring(String s) {
		int resultLength = 0;
		Map<Integer,String> map = new HashMap<>();
		
		if(s==null){
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String subString = (map.get(i)==null)?"":map.get(i);
				if(subString.contains(s.substring(j, j+1))){
					break;
				}else{
					subString+=s.substring(j, j+1);
					map.put(i, subString);
				}
				if(resultLength<subString.length()){
					resultLength=subString.length();
				}
			}
		}
		
		return resultLength;
    }
	
	public static void main(String[] args) {
		Three t = new Three();
		int output = t.lengthOfLongestSubstring("abcabcbb");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("bbbbb");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("pwwkew");
		System.out.println(output);
	}

}
