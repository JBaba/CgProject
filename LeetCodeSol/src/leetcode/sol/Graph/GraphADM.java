package leetcode.sol.Graph;

import java.util.Stack;

public class GraphADM {

	private int numberOfVertex = 0;
	private int[][] adm = null;
	
	@SuppressWarnings("unchecked")
	public GraphADM(int v) {
		numberOfVertex = v;
		
		adm = new int[v][v];
	}
	
	public void addEdge(int i,int j){
		adm[i][j]=1;
		adm[j][i]=1; // Add w to v's list.
	}
	
	private void DFS(int i,boolean isIrecursive) {
		// array for tracking visited vertex
		boolean[] visited = new boolean[numberOfVertex];
		if(isIrecursive)
			traverseDFS(i,0,visited);
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
		for (int i=0;i<adm[item].length;i++) {
			if(adm[item][i] == 1 && !visited[i] ){
				visited[i]=true;
				//System.out.println(i+" vertex found");
				stack.add(i);
			}
		}
		return stack;
	}

	private void traverseDFS(int i, int j, boolean[] visited) {
		try{
			if(adm[i][j]==1 && !visited[j]){
				visited[j]=true;
				System.out.println(j+" vertex found");
				traverseDFS(j, j, visited);
			}
		}catch(Exception e){
			return;
		}
		
		traverseDFS(i, j+1, visited);
	}

	public static void main(String[] args) {
		GraphADM g = new GraphADM(10);
		
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
        
        g.print();
        
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2,true);
        System.out.println("Iterative..");
        //g.DFS(2,false);
		System.out.println("Done.");
	}

	private void print() {
		for(int i=0;i<adm.length;i++){
			for(int j=0;j<adm[i].length;j++){
				System.out.print(adm[i][j]+" ");
			}
			System.out.println();
		}
	}

}
