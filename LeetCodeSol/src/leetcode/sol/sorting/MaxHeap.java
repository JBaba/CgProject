package leetcode.sol.sorting;

import java.util.Arrays;

public class MaxHeap {

	int[] ary;
	int size = 0;
	int MAX_SIZE = 0;
	
	public MaxHeap(int size) {
		ary = new int[size];
		MAX_SIZE = size;
		
		add(25);
		add(40);
		add(24);
		add(30);
		add(32);
		add(35);
		add(9);
	}
	
	private void print() {
		System.out.println(Arrays.toString(ary));
	}

	private void add(int i) {
		print();
		
		if(size == MAX_SIZE){
			System.out.println("Heap is full.");
			return;
		}
		
		if(size == 0){
			ary[size]=i;
			size++;
			return;
		}
			
		ary[size]=i;
		size++;
		
		siftUp(size-1);
		print();
	}

	private void siftUp(int i) {
		
		if(i==0)
			return;
		
		int parent = getParent(i);
		if(ary[parent] < ary[i]){
			int temp = ary[parent];
			ary[parent] = ary[i];
			ary[i] = temp;
			siftUp(parent);
		}		
	}
	
	private int getParent(int i){
		return (i%2==0)?(i/2)-1:(i/2);
	}
	
	private int getRightChild(int i){
		return 2*i;
	}
	
	private int getLeftChild(int i){
		return (2*i) + 1;
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(20);
	}

}
