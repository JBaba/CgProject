package com.amazon.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargeInMaxHeap {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(3,5,6,1,9,8,7,10,15,12,13);
		Collections.sort(l);
		List<Integer> list = klarge(l,3);
		System.out.println(list);
	}

	private static List<Integer> klarge(List<Integer> A, int k) {
		PriorityQueue<HeapEntry> maxH = new PriorityQueue<HeapEntry>(16,new Compare());
		maxH.add(new HeapEntry(0, A.get(0)));
		List<Integer> r = new ArrayList<Integer>();
		
		for(int i=0;i<k;i++){
			int idx = maxH.peek().id;
			r.add(maxH.remove().val);
			
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			
			if(lc<A.size())
				maxH.add(new HeapEntry(lc, A.get(lc)));
			
			if(rc<A.size())
				maxH.add(new HeapEntry(rc, A.get(rc)));
			
		}
		
		return r;
	}
}

class Compare implements Comparator<HeapEntry>{
	@Override
	public int compare(HeapEntry o1, HeapEntry o2) {
		return Integer.compare(o1.val, o2.val);
	}
}

class HeapEntry implements Comparable<HeapEntry>{
	public int id,val;
	public HeapEntry(int i,int v) {
		id = i;
		val = v;
	}
	@Override
	public int compareTo(HeapEntry o) {
		return Integer.compare(this.val, o.val);
	}
}
