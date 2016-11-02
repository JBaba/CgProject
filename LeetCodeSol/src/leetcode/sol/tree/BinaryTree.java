package leetcode.sol.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	Node root = null;  
	int size = 0;
	
	public BinaryTree() {
	}
	
	public void add(int val){
		if(root == null){
			root = new Node<>(val);
			root.left = new Node<>(0);
			root.right = new Node<>(0);
			++size;
			return;
		}
		Node<Integer> dummayHead = root;
		addToLeaf(val,dummayHead);
	}
	
	public void preOrder(Node root,List<Integer> result){
		if(root.val != 0){
			result.add(root.val);
		}else{
			return;
		}
		preOrder(root.left, result);
		preOrder(root.right, result);
			
	}
	
	public void inOrder(Node root,List<Integer> result){
		if(root.val == 0){
			return;
		}
		preOrder(root.left, result);
		if(root.val != 0){
			result.add(root.val);
		}
		preOrder(root.right, result);
	}
	
	public void postOrder(Node root,List<Integer> result){
		if(root.val == 0){
			return;
		}
		preOrder(root.left, result);
		preOrder(root.right, result);
		if(root.val != 0){
			result.add(root.val);
		}
	}
	
	private void addToLeaf(int val, Node<Integer> head) {
		
		if(head.val == 0){
			head.val = val;
			head.left = new Node<>(0);
			head.right = new Node<>(0);
			++size;
			return;
		}
		
		if(val >= head.val){
			addToLeaf(val, head.right);
		}
		else{
			addToLeaf(val, head.left);
		}
	}
	
	void print(){
		//BTreePrinter.printNode(root);
		
		root = null;
		
		add(1);
		add(2);
		add(4);
		add(5);
		add(3);
		
		BTreePrinter.printNode(root);
		
		List<Integer> result = new ArrayList<Integer>();
		preOrder(root, result);
		System.out.println(result);
		
		result.clear();
		inOrder(root, result);
		System.out.println(result);
		
		result.clear();
		postOrder(root, result);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(50);
		bt.add(40);
		bt.add(30);
		bt.add(45);
		bt.add(42);
		bt.add(41);
		bt.add(44);
		bt.add(43);
		bt.add(48);
		bt.add(47);
		bt.add(46);
		bt.add(49);
		bt.add(35);
		bt.add(32);
		bt.add(31);
		bt.add(34);
		bt.add(33);
		bt.add(38);
		bt.add(37);
		bt.add(36);
		bt.add(39);

		// right
		bt.add(60);
		bt.add(70);
		bt.add(65);
		bt.add(62);
		bt.add(61);
		bt.add(64);
		bt.add(63);
		bt.add(68);
		bt.add(67);
		bt.add(66);
		bt.add(69);
		bt.add(75);
		bt.add(72);
		bt.add(71);
		bt.add(74);
		bt.add(73);
		bt.add(78);
		bt.add(77);
		bt.add(76);
		bt.add(79);

		bt.print();

	}

}
