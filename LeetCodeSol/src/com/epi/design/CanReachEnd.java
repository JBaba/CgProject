package com.epi.design;

import java.util.ArrayList;
import java.util.List;

public class CanReachEnd {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = getList("3,3,1,0,2,0,1",list);
		System.out.println(list);
		
		boolean ans = canReachEnd(list);
		
	}

	private static boolean canReachEnd(List<Integer> list) {
		int reachSoFar = 0, lastIndex = list.size()-1;
		for(int i=0;i<=reachSoFar && reachSoFar < lastIndex;i++){
			reachSoFar = Math.max(reachSoFar, i+list.get(i));
		}
		return reachSoFar>=lastIndex;
	}

	static List<Integer> getList(String string, List<Integer> list) {
		String[] split = string.split(",");
		for(String s:split){
			int num = Integer.parseInt(s);
			list.add(num);
		}
		return list;
	}

}
