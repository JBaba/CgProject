package com.amazon.set_392;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

	public static void main(String[] args) {
		IsAnagram ia = new IsAnagram();
		String word = "nameis";
		String anagram = "is name";
		
		word=word.replaceAll("\\s", "");
		anagram=anagram.replaceAll("\\s", "");
		
		System.out.println("Word:"+word+" Anagram:"+anagram);
		
		ia.isAnagramUsingSort(word,anagram);
		ia.isAnagramUsingSubString(word,anagram);
		ia.isAnagramUsingStringBuffer(word,anagram);
		ia.isAnagramUsingHashMap(word,anagram);
	}

	private boolean isAnagramUsingHashMap(String word, String anagram) {
		if(word.length() != anagram.length()){
			System.out.println("Not anagram");
			return false;
		}else{
			
			Map<Character,Integer> charCount = new HashMap<>();
			
			for(int i=0;i<anagram.length();i++){
				char c = anagram.charAt(i);
				
				int count = 0;
				
				if(charCount.containsKey(c)){
					count = charCount.get(c);
				}
				
				count++;
				
				charCount.put(c, count);
				
				// part 2
				
				count = 0;
				
				c = word.charAt(i);
				
				if(charCount.containsKey(c)){
					count = charCount.get(c);
				}
				
				charCount.put(c, --count);
			}
			
			for(int val : charCount.values()){
				if(val != 0){
					System.out.println("Not anagram");
					return false;
				}
			}
			
			System.out.println("Is anagram");
			return true;
		}
	}

	private boolean isAnagramUsingStringBuffer(String word, String anagram) {
		if(word.length() != anagram.length()){
			System.out.println("Not anagram");
			return false;
		}else{
			
			StringBuffer wordSB = new StringBuffer(word);
			
			for(int i=0;i<anagram.length();i++){
				char c = anagram.charAt(i);
				int index = wordSB.indexOf(""+c);
				
				if(index == -1){
					System.out.println("Not anagram");
					return false;
				}else{
					wordSB.deleteCharAt(index);
				}
			}
			
			System.out.println("Is anagram");
			return true;
		}
	}

	private boolean isAnagramUsingSubString(String word, String anagram) {
		if(word.length() != anagram.length()){
			System.out.println("Not anagram");
			return false;
		}else{
			for(int i=0;i<anagram.length();i++){
				char c = anagram.charAt(i);
				int index = word.indexOf(c);
				
				if(index == -1){
					System.out.println("Not anagram");
					return false;
				}else{
					word = word.substring(0,index) + word.substring(index+1);
				}
			}
			
			System.out.println("Is anagram");
			return true;
		}
	}

	private boolean isAnagramUsingSort(String word, String anagram) {
		if(word.length() != anagram.length()){
			System.out.println("Not anagram");
			return false;
		}else{
			char[] wordArray = word.toCharArray();
			char[] anagramArray = anagram.toCharArray();
			
			Arrays.sort(wordArray);
			Arrays.sort(anagramArray);
			
			boolean flag = Arrays.equals(wordArray, anagramArray); 
			
			if(flag){
				System.out.println("Is anagram");
			}else{
				System.out.println("Not anagram");
			}
			
			return flag;
		}
	}

	
}
