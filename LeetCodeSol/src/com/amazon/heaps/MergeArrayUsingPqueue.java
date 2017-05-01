package com.amazon.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeArrayUsingPqueue {

	public static void main(String[] args) {

		int[][] ary = {
				{3,5,7},
				{0,6},
				{0,6,28}
		};
		
		CAry[] cary = {
				new CAry(ary[0]),
				new CAry(ary[1]),
				new CAry(ary[2])
		};

		List<Integer> list = mergeSortedArrays(cary);
		System.out.println(list);
	}

	private static List<Integer> mergeSortedArrays(CAry[] cary) {
		PriorityQueue<CAry> pq = new PriorityQueue<CAry>(3,new Comparator<CAry>() {
			@Override
			public int compare(CAry o1, CAry o2) {
				int l = o1.getValue();
				int r = o2.getValue();
				if(l > r) return 1;
				if(l == r) return 0;
				return -1;
			}
		});
		List<Integer> list = new ArrayList<Integer>();
		pq.add(cary[0]);
		pq.add(cary[1]);
		pq.add(cary[2]);

		while(!pq.isEmpty()){
			CAry ary = pq.poll();
			list.add(ary.getValue());
			if((ary.iX+1)<ary.ary.length){
				ary.iX++;
				pq.add(ary);
			}
		}
		
		return list;
	}

}

class CAry{
	int iX = 0;
	int ary[] = null;
	public CAry(int[] ary) {
		this.ary = ary;
	}
	public int getValue(){
		return ary[iX];
	}
	@Override
	public String toString() {
		return "["+iX+":"+ary[iX]+"]";
	}
}
