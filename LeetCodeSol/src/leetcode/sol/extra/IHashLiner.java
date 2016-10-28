package leetcode.sol.extra;

import java.util.*;

public class IHashLiner<k,v> {

	private List<Element<k, v>> list;
	private int size;
	private int capacity;
	
	public IHashLiner(int size) {
		list = new ArrayList<Element<k,v>>();
		size = 0;
		capacity = size;
	}

	public boolean isEmpty(){ return (size==0)?true:false; }
	public int size(){ return size; };
	public int capacity(){ return capacity; }
	
	public int hash(v item){ return item.hashCode()%capacity; }
	
	
	
	public static void main(String[] args) {
		IHashLiner h = new IHashLiner(5);
		h.put(1, 12);
		h.print();
		h.put(20, 22);
		h.print();
		h.put(30, 32);
		h.print();
		h.remove(20);
		h.print();
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
	}
	
}
