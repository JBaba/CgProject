package leetcode.sol.extra;

import java.util.*;

public class HashLinerProb {

	private List[] arry;
	
	public HashLinerProb(int size) {
		arry = new ArrayList[size];
	}

	private int getHashCode(int item){
		return item%arry.length;
	}
	
	public void put(int key,int val){
		int hash = getHashCode(key);
		if(arry[hash]==null){
			arry[hash] = new ArrayList<element>();
			arry[hash].add(new element(key, val));
		}else{
			element e = new element(key, val);
			Iterator<element> iterator = arry[hash].iterator(); 
			boolean isPresent = false;
			while (iterator.hasNext()) {
				element item = iterator.next();
				if(item.equals(e)){
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				arry[hash].add(e);
		}
	}
	
	public void remove(int key){
		int hash = getHashCode(key);
		if(arry[hash]!=null){
			Iterator<element> iterator = arry[hash].iterator(); 
			while (iterator.hasNext()) {
				element item = iterator.next();
				if(item.key == key)
					iterator.remove();
			}
		}
	}
	
	void print(){
		for (List<String> list : arry) {
		    System.out.print(list);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HashLinerProb h = new HashLinerProb(5);
		h.put(1, 12);
		h.print();
		h.put(20, 22);
		h.print();
		h.put(30, 32);
		h.print();
		h.remove(20);
		h.print();
	}

	class element{
		public int key;
		public int value;
		public element(int key,int value) {
			this.key=key;
			this.value=value;
		}
		
		public boolean equals(element obj) {
			return (key == obj.key)?(value==obj.value)?true:false:false;
		}
		
		@Override
		public String toString() {
			return "("+key+"->"+value+")";
		}
	}
	
}
