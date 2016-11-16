package leetcode.sol.tree;

import java.util.*;

public class AddValueBBT {
	
	Node root = new Node(0);
	
	public AddValueBBT() {
		Node leaf = getTreeBBT();
		BTreePrinter.printNode(root);
		write(leaf, 1);
		BTreePrinter.printNode(root);
	}

	private Node getTreeBBT() {
		Node right = new Node(root, 0);
		Node left = new Node(root, 1);
		root.right=right;
		root.left=left;
		
		Node right_1 = new Node(right, 1);
		Node left_1 = new Node(right, 0);
		right.right=right_1;
		right.left=left_1;
		
		Node right_2 = new Node(left, 1);
		Node left_2 = new Node(left, 1);
		left.right=right_2;
		left.left=left_2;
		
		return left_1;
	}
	
	void write(Node leaf,int val){
		leaf.val = val; // write the node
		balanceTree(leaf.parent); // balance the tree
	}
	
	void balanceTree(Node parent){
		if(parent == null)
			return;
		
		if(isOrOpsLeafMatchTo(parent))
			return;
		else
			parent.val = (parent.right.val & parent.left.val);
		
		balanceTree(parent.parent);
	}
	
	private boolean isOrOpsLeafMatchTo(Node leaf) {
		return ((leaf.right.val & leaf.left.val) == leaf.val)?true:false;
	}

	public static void main(String[] args) {
		AddValueBBT av = new AddValueBBT();
	}

}

class Node<Integer> {
	public Node right,left,parent;
	int val;
	
	public Node(int val) {
		this.right=null;
		this.left=null;
		this.parent=null;
		this.val=val;
	}
	
	public Node(Node parent,int val) {
		this.right=null;
		this.left=null;
		this.parent=parent;
		this.val=val;
	}
	
	public Node(Node right,Node left,Node parent,int val) {
		this.right=right;
		this.left=left;
		this.parent=parent;
		this.val=val;
	}
	
	@Override
	public String toString() {
		return val+"->L["+left.val+"],R["+right.val+"]";
	}
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
