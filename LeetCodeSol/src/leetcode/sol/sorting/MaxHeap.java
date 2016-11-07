package leetcode.sol.sorting;

import java.util.Arrays;

public class MaxHeap {

	int[] ary;
	int size = 0;
	int MAX_SIZE = 0;
	boolean isPrint = false;
	
	public MaxHeap(int size) {
		ary = new int[size];
		MAX_SIZE = size;
		
		add(25); add(40); add(24); add(30); add(32); add(35); add(9);
		add(15); add(4); add(14); add(33); add(19); add(28); add(29);
		add(7); add(6); add(5); add(3); add(2); add(31); 
		
		isPrint = true;
		add(39);
		
		extractMax();
		
		remove(8);
	}
	
	private void remove(int i) {
		System.out.println("Removing "+i+" position :"+ary[i]);
		ary[i] = Integer.MAX_VALUE;
		
		print();
		siftUp(i);
		extractMax();
		print();
	}

	private void extractMax() {
		if(size == 0){
			System.out.println("Heap is empty.");
			return;
		}
		System.out.println("Max value:"+ary[0]);
		
		ary[0] = ary[size-1];
		ary[size-1] = 0;
		--size;
		
		print();
		siftDown(0);
		print();
	}

	private void siftDown(int i) {
		int right = getRightChild(i+1)-1;
		int left = getLeftChild(i+1)-1;
		
		if(ary[right] > ary[left]){
			if(ary[right]>ary[i]){
				swap(right, i);
				siftDown(right);
			}else{
				return;
			}
		}
		else{
			if(ary[left]>ary[i]){
				swap(left, i);
				siftDown(left);
			}else{
				return;
			}
		}
	}

	private void print() {
		if(isPrint)
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
			swap(parent,i);
			siftUp(parent);
		}		
	}
	
	
	
	private void swap(int parent, int i) {
		int temp = ary[parent];
		ary[parent] = ary[i];
		ary[i] = temp;
	}

	private int getParent(int i){
		return (i%2==0)?(i/2)-1:(i/2);
	}
	
	private int getRightChild(int i){
		return 2*i + 1;
	}
	
	private int getLeftChild(int i){
		return (2*i);
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(30);
	}

}
