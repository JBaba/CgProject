package com.amazon.set_392;

import java.util.Arrays;

public class AllAnagramTogetherUsingSort {

	public static void main(String[] args) {
		AllAnagramTogetherUsingSort aat = new AllAnagramTogetherUsingSort();
		String[] ary = {"cat","dog","tac","god","act"};
		System.out.println(Arrays.toString(ary));
		String[] out = aat.getAllAnagramTogether(ary);
		System.out.println(Arrays.toString(out));
	}

	private String[] getAllAnagramTogether(String[] ary) {
		WordIndex[] dupAry = new WordIndex[ary.length];
		for(int i=0;i<ary.length;i++){
			dupAry[i] = new WordIndex(i,ary[i]);
		}
		
		for(int i=0;i<ary.length;i++){
			char[] chars = dupAry[i].word.toCharArray();
			Arrays.sort(chars);
			dupAry[i].word = new String(chars);
		}
		
		Arrays.sort(dupAry);
		
		String[] out = new String[ary.length];
		int i=0;
		for(WordIndex word : dupAry){
			out[i] = ary[word.i];
			i++;
		}
		
		return out;
	}

}

class WordIndex implements Comparable<WordIndex>{
	public String word;
	public int i;
	
	public WordIndex(int i2, String string) {
		i=i2;
		word=string;
	}

	@Override
	public int compareTo(WordIndex o) {
		return word.compareTo(o.word);
	}
}
