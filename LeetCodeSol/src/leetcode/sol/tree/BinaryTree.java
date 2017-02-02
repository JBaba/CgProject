package leetcode.sol.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.amazon.Node;

public class BinaryTree {

	@SuppressWarnings("rawtypes")
	public Node<Integer> root = null;  
	int size = 0;
	
	public BinaryTree() {
	}
	
	@SuppressWarnings("unchecked")
	public void add(int val){
		if(root == null){
			root = new Node<>(val);
			root.left = new Node<>(null);
			root.right = new Node<>(null);
			++size;
			return;
		}
		Node<Integer> dummayHead = root;
		addToLeaf(val,dummayHead,dummayHead);
	}
	
	@SuppressWarnings("rawtypes")
	public void preOrder(Node<Integer> root,List<Integer> result){
		if(root.val != 0){
			result.add(root.val);
		}else{
			return;
		}
		preOrder(root.left, result);
		preOrder(root.right, result);
			
	}
	
	@SuppressWarnings("rawtypes")
	public void inOrder(Node<Integer> root,List<Integer> result){
		if(root.val == 0){
			return;
		}
		inOrder(root.left, result);
		if(root.val != 0){
			result.add(root.val);
		}
		inOrder(root.right, result);
	}
	
	@SuppressWarnings("rawtypes")
	public void postOrder(Node<Integer> root,List<Integer> result){
		if(root.val == 0){
			return;
		}
		postOrder(root.left, result);
		postOrder(root.right, result);
		if(root.val != 0){
			result.add(root.val);
		}
	}
	
	public void levelOrder(List<Integer> result,Queue<Node<Integer>> q){
		if(q.isEmpty())
			return;
		
		Node<Integer> current = q.poll();
		result.add(current.val);
		
		if(current.left.val != 0)
			q.add(current.left);
		if(current.right.val != 0)
			q.add(current.right);
		
		levelOrder(result, q);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delete(int val){
		
		if(root == null)
			return;
		
		Node<Integer> deleteNode = findNode(val,root);
		
		if(deleteNode == null)
			return;
		
		if(deleteNode.right.val != 0){
			deleteAndReplaceOnLeft(deleteNode);
		}else if(deleteNode.left.val != 0){
			deleteAndReplaceOnRight(deleteNode);
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private void deleteAndReplaceOnRight(Node deleteNode) {
		Node replacement = findReplacemnet(deleteNode.left,"R");
		deleteNode(replacement,deleteNode);
		deleteReplacementNode(replacement,"R");
	}

	@SuppressWarnings("rawtypes")
	private void deleteAndReplaceOnLeft(Node deleteNode) {
		Node replacement = findReplacemnet(deleteNode.right,"L");
		deleteNode(replacement,deleteNode);
		deleteReplacementNode(replacement,"L");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void deleteReplacementNode(Node<Integer> replacement, String string) {
		if(string.equalsIgnoreCase("L")){
			if(replacement.parent.left.val == 0){
				replacement.parent.right.val = 0;
				replacement.left = null;
				replacement.right = null;
				return;
			}
			
			replacement.parent.left.val = 0;
			replacement.left = null;
			replacement.right = null;
		}else{
			if(replacement.parent.right.val == 0){
				replacement.parent.left.val = 0;
				replacement.left = null;
				replacement.right = null;
				return;
			}
			
			replacement.parent.right.val = 0;
			replacement.left = null;
			replacement.right = null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void deleteNode(Node replacement, Node deleteNode) {
		deleteNode.val = replacement.val;
	}

	@SuppressWarnings("rawtypes")
	private Node findReplacemnet(Node<Integer> deleteNode,String dir) {
		if(deleteNode.val != 0 && 
				deleteNode.right.val == 0 && deleteNode.left.val == 0)
			return deleteNode;
		
		if(dir.equalsIgnoreCase("R"))
			return findReplacementInRight(deleteNode,dir);
		else
			return findReplacementInLeft(deleteNode,dir);
	}

	@SuppressWarnings("rawtypes")
	private Node findReplacementInRight(Node<Integer> deleteNode, String dir) {
		if(deleteNode.right.val != 0){
			return findReplacemnet(deleteNode.right,dir);
		}
		else{
			return findReplacemnet(deleteNode.left,dir);
		}
	}

	@SuppressWarnings("rawtypes")
	private Node findReplacementInLeft(Node<Integer> deleteNode, String dir) {
		if(deleteNode.left.val != 0){
			return findReplacemnet(deleteNode.left,dir);
		}
		else{
			return findReplacemnet(deleteNode.right,dir);
		}
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	private void deleteNodeAtLeaf(Node<Integer> replacement) {
		if(replacement.right.val != 0)
			replacement.val = replacement.right.val;
	}

	@SuppressWarnings("rawtypes")
	private Node findNode(int val, Node<Integer> root) {
		if(root.val == val)
			return root;
		
		if(root.val >= val)
			return findNode(val, root.left);
		else
			return findNode(val, root.right);
	}

	@SuppressWarnings("unchecked")
	private void addToLeaf(int val, Node<Integer> head, Node<Integer> parent) {
		
		if(head.val == null){
			head.val = val;
			head.left = new Node<>(null);
			head.right = new Node<>(null);
			head.parent = parent;
			++size;
			return;
		}
		
		if(val >= head.val){
			addToLeaf(val, head.right, head);
		}
		else{
			addToLeaf(val, head.left, head);
		}
	}
	
	@SuppressWarnings("unchecked")
	void print(){
		
		BTreePrinter.printNode(root);
		
		delete(37);
		
		BTreePrinter.printNode(root);
		
		root = null;
		
		add(1);
		add(2);
		add(4);
		add(5);
		add(3);
		
		BTreePrinter.printNode(root);
		traversal();
		
		Map<Integer,Integer> map = new LinkedHashMap<>();
		getHeight(root,map);
		
		getMin(root);
		getMax(root);
		
		delete(2);

		//BTreePrinter.printNode(root);
		
	}
	
	private void getMin(Node<Integer> root) {
		if(root.left.val == 0){
			System.out.println("Min Val:"+root.val);
			return;
		}
		getMin(root.left);
	}
	
	private void getMax(Node<Integer> root) {
		if(root.right.val == 0){
			System.out.println("Max Val:"+root.val);
			return;
		}
		getMin(root.right);
	}

	private void getHeight(Node<Integer> root,Map<Integer,Integer> result){
		if(root.val != 0){
			if(root.parent != null)
				result.put(root.val,result.get(root.parent.val)+1);
			else
				result.put(root.val,1);
		}else{
			return;
		}
		getHeight(root.left, result);
		getHeight(root.right, result);
	}

	public void traversal(){
		List<Integer> result = new ArrayList<Integer>();
		preOrder(root, result);
		System.out.println(result);
		
		result.clear();
		inOrder(root, result);
		System.out.println(result);
		
		result.clear();
		postOrder(root, result);
		System.out.println(result);
		
		result.clear();
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		q.add(root);
		levelOrder(result,q);
		System.out.println(result);
	}
	
	public static void start(){
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
	
	public static void main(String[] args) {
		start();
	}

}
