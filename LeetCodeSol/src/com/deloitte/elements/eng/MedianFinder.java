package com.deloitte.elements.eng;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MedianFinder {

	PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half
 
    public MedianFinder(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
 
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
 
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
 
    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		NavigableSet<Integer> set = new TreeSet<>();
		for(int i=10;i<20;i++){
			set.add(i);
			mf.addNum(i);
			System.out.println(mf.findMedian());
		}
		System.out.println(set);
	}

}
