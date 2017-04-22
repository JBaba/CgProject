package com.epi.design;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class StackQueueTest {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.addFirst(1);
		stack.addFirst(2);
		stack.addFirst(3);
		stack.addFirst(4);
		stack.addFirst(5);
		
		stack.addLast(6);
		stack.addLast(7);
		stack.addLast(8);
		stack.addLast(9);
		
		stack.push(10);
		stack.push(11);
		stack.push(12);
		
		Integer[] ary = {4,5,6,1,2,3};
		
		Collections.rotate(Arrays.asList(ary), -3);
		
		ary = Arrays.copyOf(ary, 12);
		
		Iterator<Integer> it = stack.descendingIterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		System.out.println(stack.peekFirst());
		System.out.println(stack.peekFirst());
		
		System.out.println(stack.peekLast());
		System.out.println(stack.peekLast());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.poll());
		System.out.println(stack.poll());
		
		System.out.println(stack.pollFirst());
		System.out.println(stack.pollFirst());
		
		System.out.println(stack.pollLast());
		System.out.println(stack.pollLast());
		
		System.out.println(stack.remove());
		System.out.println(stack.remove());
		
		System.out.println(stack.removeFirst());
		System.out.println(stack.removeFirst());
		
		System.out.println(stack.removeLast());
		System.out.println(stack.removeLast());
		
		
	}
	
}
