package leetcode.sol.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	private void DFS(int i) {
		// array for tracking visited vertex
		boolean[] visited = new boolean[numberOfVertex];
		traverseDFS(i,visited);
	}
	
	private void traverseDFS(int i, boolean[] visited) {
		if(!visited[i])
			visited[i]=true;
		else
			return;
		
		Iterator<Integer> neighbours = adl[i].iterator();
		
		while (neighbours.hasNext()) {
			Integer vertex = (Integer) neighbours.next();
			traverseDFS(vertex, visited);
		}
	}

	public static void main(String[] args) {
		GraphADL g = new GraphADL(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
		System.out.println("Done.");
	}

}
