package com.amazon.heaps;

import java.util.LinkedHashMap;

public class KthLargeElement {

	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,-1,2};
		
		KthLargeElement k = new KthLargeElement();
		int ix = k.findKthLargest(a, 1);
		System.out.println(ix);
		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(5, 1.0f, true){
			@Override
			protected boolean removeEldestEntry(
					java.util.Map.Entry<Integer, Integer> eldest) {
				return this.size() > 5;
			}
		};
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(1, 1);
		map.put(2, 2);
		map.put(5, 5);
		map.put(6, 6);
	}

}
