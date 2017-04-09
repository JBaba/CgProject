package com.epi.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeleteDuplicateNum {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list = CanReachEnd.getList("2,3,5,5,7,11,11,11,13",list);

		System.out.println(list);
		list = deleteDuplicateFromList(list);
		System.out.println(list);
		
		int[] ary = {2,3,5,5,7,11,11,11,13,13,13};
		
		System.out.println(Arrays.toString(ary));
		ary = deleteDuplicateFromAry(ary);
		System.out.println(Arrays.toString(ary));
		
	}

	private static int[] deleteDuplicateFromAry(int[] ary) {
		int index = 1;
		for(int i=1;i<ary.length;i++){
			if(ary[index-1]!=ary[i]){
				ary[index++]=ary[i];
			}
		}
		System.out.println(index);
		return ary;
	}

	private static void swap(int[] ary, int p1, int p2) {
		int temp = ary[p1];
		ary[p1]=ary[p2];
		ary[p2]=temp;
	}

	private static List<Integer> deleteDuplicateFromList(List<Integer> list) {
		int index = 1;
		for(int i = 1;i<list.size();i++){
			if(!list.get(index-1).equals(list.get(i))){
				list.set(index++, list.get(i));
			}
		}
		System.out.println(index);
		return list;
	}

}
