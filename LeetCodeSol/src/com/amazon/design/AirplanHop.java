package com.amazon.design;

import leetcode.sol.Graph.GraphADL;

public class AirplanHop {

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
		
	}

}
