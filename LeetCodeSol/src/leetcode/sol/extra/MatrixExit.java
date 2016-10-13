package leetcode.sol.extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public class MatrixExit {

	int rows = 4;
	int coulmns = 4 ;
	int totalNode = rows * coulmns;
	int exitRow = 1;
	int exitColumn = 3;
	int[][] maze = {{0,0,0,0},
			        {1,0,1,0},
			        {0,0,1,0},
			        {0,0,0,0}};
	
	public MatrixExit() {
		sol();
	}
	
	private int sol() {
		// door is not opened at first place
		if(maze[0][0]==1)
			return -1;
		
		
		int steps = 0;
		int tempJ = 0;
		
		Stack<Entry<Integer, Integer>> statusTraversal = new Stack<Entry<Integer, Integer>>();
		List<String> visitedNodes = new LinkedList<>();
		
		for (int i = 0; i < rows; i++) {
			for (int j = tempJ; j < coulmns; j++) {
				if(!canRight(i,j) && !canDown(i,j) && !canUp(i,j) && !canLeft(i,j)){
					if(i==exitRow && j==exitColumn){
						return steps;
					}else{
						return -1;
					}
				}
			}
		}
		
		return steps;
	}

	private boolean canLeft(int i, int j) {
		return ((j-1)<0)?false:(maze[i][j-1]==0)?true:false;
	}

	private boolean canUp(int i, int j) {
		return ((i-1)<0)?false:(maze[i-1][j]==0)?true:false;
	}

	private boolean canDown(int i, int j) {
		return ((i+1)>rows)?false:(maze[i+1][j]==0)?true:false;
	}

	private boolean canRight(int i, int j) {
		return ((j+1)>(coulmns))?false:(maze[i][j+1]==0)?true:false;
	}

	public static void main(String[] args) {
		MatrixExit me = new MatrixExit();
	}

}