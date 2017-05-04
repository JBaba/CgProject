package com.amazon.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFreqQuery {

	public static void main(String[] args) {
		KMostFreqQuery k = new KMostFreqQuery();
		String[] a = {"a","aa","aaa","c","a","aa","x","y","a","x","x","z","c"};
		List<String> list = k.findKMost(a,3);
		System.out.println(list);
		
		list = k.findKMostV2(a,3);
		System.out.println(list);
		
		int[] n = {1, 2, 4, 2, 2, 5, 1, 4, 2, 1, 4, 2};
		List<Integer> num = k.topKFrequent(n, 3);
		System.out.println(num);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println(map.put(1, 2));
		System.out.println(map.put(1, 3));
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
	    //count the frequency for each element
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int num: nums){
	        if(map.containsKey(num)){
	            map.put(num, map.get(num)+1);
	        }else{
	            map.put(num, 1);
	        }
	    }
	 
	    //get the max frequency
	    int max = 0;
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        max = Math.max(max, entry.getValue());
	    }
	 
	    //initialize an array of ArrayList. index is frequency, value is list of numbers
	    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
	    for(int i=1; i<=max; i++){
	        arr[i]=new ArrayList<Integer>();
	    }
	 
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        int count = entry.getValue();
	        int number = entry.getKey();
	        arr[count].add(number);
	    }
	 
	    List<Integer> result = new ArrayList<Integer>();
	 
	    //add most frequent numbers to result
	    for(int j=max; j>=1; j--){
	        if(arr[j].size()>0){
	            for(int a: arr[j]){
	                result.add(a);
	            }
	        }
	 
	        if(result.size()==k)
	            break;
	    }
	 
	    return result;
	}

	private List<String> findKMostV2(String[] a, int k) {
		List<String> list = new ArrayList<String>();
		Map<String,Freq> map = new HashMap<>();
		PriorityQueue<Freq> p = new PriorityQueue<Freq>(k,new Comparator<Freq>() {
			@Override
			public int compare(Freq o1, Freq o2) {
				return Integer.compare(o1.frq, o2.frq);
			}
		});
		
		for(String item:a){
			if(map.containsKey(item)){
				Freq f = map.get(item);
				f.frq++;
				map.put(item,f);
			}else{
				map.put(item, new Freq(item, 1));
			}
		}
		
		for(Map.Entry<String, Freq> entry : map.entrySet()){
			p.offer(entry.getValue());
			if(p.size()>k)
				p.poll();
		}
		
		for(int i=0;i<k;i++)
			list.add(p.poll().a);
		return list;
	}

	private List<String> findKMost(String[] a, int k) {
		List<String> list = new ArrayList<String>();
		Map<String,Freq> map = new HashMap<>();
		PriorityQueue<Freq> p = new PriorityQueue<Freq>(k,new Comparator<Freq>() {
			@Override
			public int compare(Freq o1, Freq o2) {
				return Integer.compare(o2.frq, o1.frq);
			}
		});
		
		for(String item:a){
			if(map.containsKey(item)){
				Freq f = map.get(item);
				p.remove(f);
				f.frq++;
				map.put(item,f);
				p.add(f);
			}else{
				map.put(item, new Freq(item, 1));
				p.add(map.get(item));
			}
		}
		
		for(int i=0;i<3;i++)
			list.add(p.poll().a);
		
		return list;
	}
	
}

class Freq{
	String a;
	int frq;
	public Freq(String a,int f) {
		this.a=a;
		frq=f;
	}
	@Override
	public String toString() {
		return "["+a+":"+frq+"]";
	}
}
