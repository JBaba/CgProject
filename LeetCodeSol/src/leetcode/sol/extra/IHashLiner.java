package leetcode.sol.extra;

import java.util.*;

public class IHashLiner<k,v> {

	private List<Element<k, v>> list;
	private int size;
	private int capacity = 31;
	
	public IHashLiner(int size) {
		list = new ArrayList<Element<k,v>>();
		this.size = 0;
		
		capacity = size;
		
		// create empty chains
		for (int i = 0; i < capacity; i++) {
			list.add(null);
		}
	}

	public boolean isEmpty(){ return (size==0)?true:false; }
	public int size(){ return size; };
	public int capacity(){ return capacity; }
	
	public int hash(k item){ 
		int hash = item.hashCode();
		return hash%capacity; 
	}
	
	public void put(k key,v val){
		// create node
		Element<k, v> e = new Element<k,v>(key, val);
		
		// get hash for key
		int hash = hash(key);
		
		// get Value at index
		Element<k, v> entry = list.get(hash);
		
		// if its empty entry
		if(entry==null){
			list.set(hash, e);
			++size;
			return;
		}
		
		while (entry != null) {
			// if key matches replace value
			if(entry.key.equals(key)){
				entry.val = val;
				return;
			}
			// get next item in struct
			entry = entry.next;
		}
		
		// no match found
		++size;
		Element<k, v> head = list.get(hash);
		//new head
		e.next = head;
		list.set(hash,e);
		
		resize();
		
		return;
	}
	
	private void resize() {
		
	}
	
	private v remove(k k) {
		
		Element<k, v> head = list.get(hash(k));
		
		// if head null
		if(head == null)
			return null;
				
		// if head matchs
		if(head.key.equals(k)){
			v val = head.val;
			list.set(hash(k), head.next);
			return val;
		}
		
		// temp prev var
		Element<k, v> prev = head;
		
		while (head != null) {
			if(head.key.equals(k)){
				prev.next = head.next;
				return head.val;
			}
			prev = head;
			head = head.next;
		}
		
		return null;
	}

	public static void main(String[] args) {
		IHashLiner<Integer,Integer> h = new IHashLiner(5);
		h.put(1, 12);
		h.print();
		h.put(20, 22);
		h.print();
		h.put(30, 32);
		h.print();
		h.put(40, 33);
		h.print();
		h.remove(30);
		h.print();
	}

	private void print() {
		System.out.println(list);
	}

	/**
	 * Hash Map structure element
	 * @author nviradia
	 *
	 * @param <k>
	 * @param <v>
	 */
	class Element<k,v> {
		public k key;
		public v val;
	
		public Element<k, v> next;
		
		public Element(k key,v val) {
			this.key = key;
			this.val = val;
		}
		
		@Override
		public String toString() {
			return "("+key+","+val+")->"+next;
		}
	}
	
}
