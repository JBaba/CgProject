package leetcode.sol.extra;

import java.util.PriorityQueue;

public class FindShortPath {

	private static int[][] matrix;
	    
    private static int startingVertex = 0, m = 0;
    
    public FindShortPath(int[][] matrix, int startingVertex, int m) {
		this.matrix = matrix;
		this.startingVertex = startingVertex;
		this.m= m;
	}
    
    public void dijkstra(int matrix[][], int startingVertex)
    {
		
		int[] vertex = new int[m] ;
		int u, v;
        int dist[] = new int[m]; //Distance Array
        int prev[] = new int[m];
	        
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
   
        for (int i = 0; i < m; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
            Q.offer(i);
        }
 
        dist[startingVertex] = 0;
        
        while(!Q.isEmpty()){
        	
        }
    }
	
}
