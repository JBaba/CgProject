package com.facebook.set1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazon.Node;

public class VerticalOrder {

	public static void main(String[] args) {
		Node<Integer> _1 = new Node<Integer>(1);
		Node<Integer> _2 = new Node<Integer>(2);
		Node<Integer> _3 = new Node<Integer>(3);
		Node<Integer> _4 = new Node<Integer>(4);
		Node<Integer> _5 = new Node<Integer>(5);
		Node<Integer> _6 = new Node<Integer>(6);
		Node<Integer> _7 = new Node<Integer>(7);
		Node<Integer> _8 = new Node<Integer>(8);
		Node<Integer> _9 = new Node<Integer>(9);
		Node<Integer> _10 = new Node<Integer>(10);
		Node<Integer> _11 = new Node<Integer>(11);
		Node<Integer> _12 = new Node<Integer>(12);
		
		_1.left = _2;
		
		_2.left = _4;
		_2.right = _5;
		
		_1.right = _3;
		
		_3.left = _6;
		_3.right = _7;
		
		_6.right = _8;
		_6.left = _10;
		_10.left = _11;
		_11.left = _12;
		_7.right = _9;
		
		System.out.println(_1);

		Map<Integer, List<Node<Integer>>> map = new HashMap<Integer, List<Node<Integer>>>();
		
		int min = verticalOrder(_1,map,0);
		
		System.out.println(min+1);
		
		printVerticalOrder(min+1,map);
	}

	private static void printVerticalOrder(int min,
			Map<Integer, List<Node<Integer>>> map) {
		while(map.get(min)!=null){
			List<Node<Integer>> list = map.get(min);
			for(Node<Integer> val : list){
				System.out.print(val.val+" : ");
			}
			System.out.println();
			min++;
		}
	}

	private static int verticalOrder(Node<Integer> _1, Map<Integer, List<Node<Integer>>> map, int stage) {
		if(_1 == null)
			return stage;
		
		if(map.get(stage) != null){
			map.get(stage).add(_1);
		}else{
			 List<Node<Integer>> list = new ArrayList<Node<Integer>>();
			 list.add(_1);
			 map.put(stage, list);
		}
		
		return Math.min(verticalOrder(_1.left, map, stage-1), verticalOrder(_1.right, map, stage+1));
	}

}
