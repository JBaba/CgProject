package com.facebook.set1;

import com.amazon.Node;

public class TreeToMrriorTree {

	public static void main(String[] args) {

		Node<Integer> _1 = new Node<Integer>(1);
		Node<Integer> _2 = new Node<Integer>(2);
		Node<Integer> _3 = new Node<Integer>(3);
		Node<Integer> _4 = new Node<Integer>(4);
		Node<Integer> _5 = new Node<Integer>(5);
		Node<Integer> _6 = new Node<Integer>(6);
		Node<Integer> _7 = new Node<Integer>(7);
		
		_1.left = _2;
		
		_2.left = _7;
		_2.right = _6;
		
		_1.right = _3;
		
		_3.left = _5;
		_3.right = _4;
		
		System.out.println(_1);
		
		convertToMirror(_1);
		
		System.out.println(_1);
		
	}

	private static void convertToMirror(Node<Integer> _1) {
		
		if(_1 == null)
			return;
		
		Node<Integer> l = _1.left;
		Node<Integer> r = _1.right;
		
		_1.right = l;
		_1.left = r;
		
		convertToMirror(l);
		convertToMirror(r);
		
	}


}
