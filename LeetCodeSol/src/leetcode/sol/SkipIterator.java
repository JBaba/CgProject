package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SkipIterator<T> implements Iterator<T> {

	Map<T, Integer> map;
	Iterator<T> it;
	T value;
	boolean isHashNextCalled = false;
	int _nullCount = 0;

	public SkipIterator(Iterator<T> it, T[] skipvalues) {
		if (skipvalues == null)
			throw new RuntimeException();
		map = new HashMap<>();
		this.it = it;
		for (T item : skipvalues) {
			// improvments
			if (item == null) {
				_nullCount += 1;
				continue;
			}
			if (map.get(item) != null) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}

	}

	public boolean hasNext() {
		isHashNextCalled = true;
		if (it.hasNext()) {
			value = it.next();
			if (value == null && _nullCount > 0) {
				_nullCount -= 1;
				return this.hasNext();
			}
			if (map.get(value) != null && map.get(value) > 0) {
				map.put(value, map.get(value) - 1);
				return this.hasNext();
			}
			return true;
		} else {
			return false;
		}
//			return true;
	}

	public T next() {
		boolean temp = isHashNextCalled;
		isHashNextCalled = false;
		if (temp) {
			return value;
		} else {
			if(hasNext())
				return value;
			else
				throw new RuntimeException("no obj");
		}
	}
	
	public static void main(String[] a) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(null);
		list.add(null);
		list.add(4);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(1);
		list.add(7);
		list.add(1);
		Iterator<Integer> it = new SkipIterator<>(list.iterator(), new Integer[]{1, 1, 6, 4, 1, null});
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
			integer = (Integer) it.next();
			System.out.println(integer);
		}
	}
}
