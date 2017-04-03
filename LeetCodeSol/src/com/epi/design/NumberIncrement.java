package com.epi.design;

import java.util.ArrayList;
import java.util.List;

public class NumberIncrement {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		list.add(9);
		
		System.out.println(list);
		
		list = incrementNumberByOne(list);
		
		System.out.println(list);
		
	}

	private static List<Integer> incrementNumberByOne(List<Integer> list) {
		int size = list.size()-1;
		list.set(size, list.get(size)+1);
		for(int i=size;i>0 && list.get(i) == 10 ; i--){
			list.set(i, 0);
			list.set(i-1, list.get(i-1)+1);
		}
		if(list.get(0) == 10){
			list.set(0, 0);
			list.add(0, 1);
		}
		return list;
	}

}
