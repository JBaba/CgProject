package com.amazon.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {

	public static void main(String[] args) {
		TopK k = new TopK();
		
		List<String> list = new ArrayList<>();
		String a = "a";
		for (int i = 0; i < 15; i++) {
			list.add(a);
			a+="a";
		}
		
		Collections.reverseOrder();
		
		List<String> out = k.topK(4,list.iterator());
	}

	private List<String> topK(int k, Iterator<String> iter) {
		PriorityQueue<String> minHeap = new PriorityQueue<>(k,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		while (iter.hasNext()) {
			minHeap.add(iter.next());
			if(minHeap.size()>k){
				minHeap.poll();
			}
		}
		
		return new ArrayList<>(minHeap);
	}

}
