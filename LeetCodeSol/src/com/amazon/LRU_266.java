package com.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRU_266 {
	
	Map<Integer,LruNode> cacheMap = null; 
	LruNode front = null, end = null;
	int capacity;
	
	
	
	public LRU_266(int capacity) {
		this.capacity =  capacity;
		cacheMap = new HashMap<>(capacity);
	}

	public static void main(String[] args) {

		LRU_266 lru = new LRU_266(5);
		lru.put(1,"1");
		lru.print();
		lru.put(2,"2");
		lru.print();
		lru.put(3,"3");
		lru.print();
		lru.get(1);
		lru.print();
		lru.put(4,"4");
		lru.print();
		lru.remove(3);
		lru.print();
		lru.put(5,"5");
		lru.print();
		lru.put(6,"6");
		lru.print();
		lru.get(4);
		lru.print();
		lru.put(7,"7");
		lru.print();
	}

	private void print() {
		System.out.println(this);
	}

	private void remove(int key) {
		LruNode node = cacheMap.get(key);
		remove(node);
		cacheMap.remove(node.key);
	}

	private void remove(LruNode node) {
		if(node.next == null){
			end = node.prev;
			node.prev.next = null;
		}else if(node.prev == null){
			front = node.next;
			node.next.prev = null;
		}else{
			node.next.prev = node.prev;
			node.prev.next = node.next;
			node.next = null;
			node.prev = null;
		}
	}

	private int get(int key) {
		if(cacheMap.containsKey(key)){
			LruNode node = cacheMap.get(key);
			remove(node);
			setHead(node);
			return Integer.parseInt(node.value);
		}
		return -1;
	}

	private void put(int key, String value) {
		if(cacheMap.containsKey(key)){
			LruNode node = cacheMap.get(key);
			removeLRU();
			node.value = value;
			setHead(node);
		}else{
			LruNode node = new LruNode(key, value);
			
			if(front == null){
				front = node;
				front.next = end;
				end = node;
				end.prev = front;
			}else if(cacheMap.size() >= capacity){
				removeLRU();
				setHead(node);
			}else{
				setHead(node);
			}
			
			cacheMap.put(key, node);
		}
	}

	private void removeLRU() {
		end = end.prev;
		end.next = null;
	}

	private void setHead(LruNode node) {
		node.next = front;
		front.prev = node;
		front = node;
	}
	
	@Override
	public String toString() {
		return front.toString();
	}

}

class LruNode {
	
	int key;
	String value;
	LruNode prev,next;
	
	public LruNode(int key,String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ""+key+"->["+next;
	}
	
}
