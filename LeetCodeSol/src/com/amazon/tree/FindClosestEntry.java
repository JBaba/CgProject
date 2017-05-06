package com.amazon.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class FindClosestEntry {

	public static void main(String[] args) {
		FindClosestEntry fc = new FindClosestEntry();
		
		
		List<Integer> one = Arrays.asList(10,12,16);
		List<Integer> two = Arrays.asList(12,15,16);
		List<Integer> three = Arrays.asList(15,15,16);
		
		List<List<Integer>> l = Arrays.asList(one,two,three);
		
		fc.findMinDistance(l);
	}

	private int findMinDistance(List<List<Integer>> sAry) {
		List<Integer> heads = new ArrayList<>(sAry.size());
		for(List<Integer> arr : sAry){
			heads.add(0);
		}
		
		int result = Integer.MAX_VALUE;
		NavigableSet<ArrayData> curHeads = new TreeSet<>();
		
		for(int i=0;i<sAry.size();i++){
			curHeads.add(new ArrayData(i, sAry.get(i).get(heads.get(i))));
		}
		
		while(true){
			result = Math.min(result, curHeads.last().val-curHeads.first().val);
			int idNextMin = curHeads.first().idx;
			
			heads.set(idNextMin, heads.get(idNextMin)+1);
			if(heads.get(idNextMin) >= sAry.get(idNextMin).size()){
				return result;
			}
			curHeads.pollFirst();
			curHeads.add(new ArrayData(idNextMin, sAry.get(idNextMin).get(heads.get(idNextMin))));
		}
	}

}

class ArrayData implements Comparable<ArrayData>{
	public int val,idx;
	
	public ArrayData(int id,int v) {
		val = v;
		idx = id;
	}
	
	@Override
	public int compareTo(ArrayData o) {
		int r = Integer.compare(val, o.val);
		if(r==0){
			r = Integer.compare(idx, o.idx);
		}
		return r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ArrayData)){
			return false;
		}
		if(this == obj)
			return true;
		
		ArrayData that = (ArrayData) obj;
		
		return this.val==that.val && this.idx==that.idx;
	}
	
	@Override
	public String toString() {
		return "["+idx+":"+val+"]";
	}
}
