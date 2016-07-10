package leetcode.sol.One_1_to_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public int lengthOfLongestSubstring2(String s) {
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
	
	public int lengthOfLongestSubstring3(String s) {
		int resultLength = 0;
		
		if(s==null){
			throw new IllegalArgumentException();
		}
		
		if(s.length() == 0){
			return resultLength;
		}
		
		String subStr = s.substring(0,1);
		for (int i = 1; i < s.length(); i++) {
			if(subStr.contains(s.substring(i,i+1))){
				if(resultLength < subStr.length()){
					resultLength = subStr.length();
				}
				subStr = s.substring(i,i+1);
			}else{
				subStr += s.substring(i,i+1);
			}
		}
		if(resultLength < subStr.length()){
			resultLength = subStr.length();
		}
		return resultLength;
    }
	
	public int lengthOfLongestSubstring(String s) {
		int resultLength = 0;
		
		if(s==null){
			throw new IllegalArgumentException();
		}
		
		if(s.length() == 0){
			return resultLength;
		}
		
		String subStr = s.substring(0,1);
		for (int i = 1; i < s.length(); i++) {
			if(subStr.contains(s.substring(i,i+1))){
				int index = subStr.indexOf(s.substring(i,i+1));
				if(resultLength < subStr.length()){
					resultLength = subStr.length();
				}
				subStr = subStr.substring(index+1,subStr.length());
				subStr += s.substring(i,i+1);
			}else{
				subStr += s.substring(i,i+1);
			}
		}
		if(resultLength < subStr.length()){
			resultLength = subStr.length();
		}
		return resultLength;
    }

	/**
	 * using set solution
	 * @param s
	 * @return
	 */
	 public int lengthOfLongestSubstring4(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	
	public static void main(String[] args) {
		Three t = new Three();
		long startTime = System.currentTimeMillis();
		int output = t.lengthOfLongestSubstring("abcabcbb");
		long endTime = System.currentTimeMillis();
		
		String s = "abcabcbb";
		System.out.println(s);
		
		t.lengthOfLongestSubstring(s);
		t.lengthOfLongestSubstring(s);
		t.lengthOfLongestSubstring(s);
		t.lengthOfLongestSubstring(s);
		t.lengthOfLongestSubstring4(s);
		t.lengthOfLongestSubstring4(s);
		t.lengthOfLongestSubstring4(s);
		t.lengthOfLongestSubstring4(s);
		
		startTime = System.currentTimeMillis();
		output = t.lengthOfLongestSubstring(s);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		startTime = System.currentTimeMillis();
		output = t.lengthOfLongestSubstring4(s);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		/*System.out.println(output);
		output = t.lengthOfLongestSubstring("bbbbb");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("pwwkew");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("x");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("dvdf");
		System.out.println(output);
		output = t.lengthOfLongestSubstring("abcadxbb");
		System.out.println(output);*/
	}

}
