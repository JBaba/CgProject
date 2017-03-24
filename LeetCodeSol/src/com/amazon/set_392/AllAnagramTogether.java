package com.amazon.set_392;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramTogether {

	public static void main(String[] args) {
		AllAnagramTogether aat = new AllAnagramTogether();
		String[] ary = {"cat","dog","tac","god","act"};
		System.out.println(Arrays.toString(ary));
		String[] out = aat.getAllAnagramTogether(ary);
		System.out.println(Arrays.toString(out));
	}

	private String[] getAllAnagramTogether(String[] ary) {
		
		IsAnagram ia = new IsAnagram();
		
		if(ary == null || ary.length == 0)
			return new String[]{};
		
		List<String>[] outList = new ArrayList[ary.length];
		outList[0] = new ArrayList<String>();
		outList[0].add(ary[0]);
		
		int position = 1;
		
		for(int i=1;i<ary.length;i++){
			String anagram = ary[i];
			boolean anagramFound = false;
			for(int j=0;j<position;j++){
				String word = outList[j].get(0);
				if(ia.isAnagramUsingHashMap(word, anagram)){
					outList[j].add(anagram);
					anagramFound = true;
					break;
				}
			}
			if(!anagramFound){
				outList[position] = new ArrayList<String>();
				outList[position].add(anagram);
				position++;
			}
		}
		
		// convert collection to arry
		String[] outAry = new String[ary.length];
		position = 0;
		int count = 0;
		while(outList[position]!=null){
			for(String word:outList[position]){
				outAry[count]=word;
				count++;
			}
			position++;
		}
		
		return outAry;
	}

}
