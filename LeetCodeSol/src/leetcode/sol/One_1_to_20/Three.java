package leetcode.sol.One_1_to_20;

import java.util.HashMap;
import java.util.Map;

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
