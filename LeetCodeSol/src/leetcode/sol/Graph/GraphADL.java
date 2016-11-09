package leetcode.sol.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GraphADL {

	private int numberOfVertex = 0;
	private List<Integer> adl[] = null;
	
	@SuppressWarnings("unchecked")
	public GraphADL(int v) {
		numberOfVertex = v;
		
		adl = new ArrayList[v];
		
		for (int i = 0; i < adl.length; i++) {
			adl[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int i,int j){
		adl[i].add(j);  // Add w to v's list.
	}
	
	private void DFS(int i,boolean isIrecursive) {
		// array for tracking visited vertex
		boolean[] visited = new boolean[numberOfVertex];
		if(isIrecursive)
			traverseDFS(i,visited);
		else
			traverseDFSIterative(i,visited);
	}
	
	private void traverseDFSIterative(int i, boolean[] visited) {
		visited[i] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(i);
		
		while(!stack.isEmpty()){
			int item = stack.pop();
			System.out.println(item+" vertex found.");
			stack = addAllUnvisitedItem(stack,visited,item);
		}
	}

	private Stack<Integer> addAllUnvisitedItem(Stack<Integer> stack, boolean[] visited, int item) {
		Iterator<Integer> it = adl[item].iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			if(!visited[value]){
				visited[value]=true;
				stack.add(value);
			}
		}
		return stack;
	}

	private void traverseDFS(int i, boolean[] visited) {
		visited[i]=true;
		
		Iterator<Integer> neighbours = adl[i].iterator();
		
		while (neighbours.hasNext()) {
			Integer vertex = (Integer) neighbours.next();
			if(!visited[vertex]){
				System.out.println(vertex+" vertex found.");
				traverseDFS(vertex, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphADL g = new GraphADL(10);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(7, 8);
        g.addEdge(7, 7);
        g.addEdge(8, 9);
        
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2,true);
        System.out.println("Iterative..");
        g.DFS(2,false);
		System.out.println("Done.");
	}

}
