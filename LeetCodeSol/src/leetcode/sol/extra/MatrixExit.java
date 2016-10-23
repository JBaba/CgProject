package leetcode.sol.extra;

import java.util.AbstractMap;
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
	int[][] maze = {{0,0,0,1},
			        {0,0,1,0},
			        {0,1,1,0},
			        {0,0,0,0}};
	List<Integer> stepsList = new LinkedList<>();
	
	public MatrixExit() {
		//sol();
		//goRight(0, "", 0, 0);
		mazeUtil(maze, 0, 0,0);
		print(maze);
		System.out.println(stepsList);
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
				if(visitedNodes.size() == totalNode){
					return -1;
				}
				if(canRight(i,j)){
					visitedNodes.add(i+""+j);
					statusTraversal.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
				}
					
			}
		}
		
		return steps;
	}
	
	private void goRight(int steps,String d,int r,int c){
		
		if(d.equalsIgnoreCase("r") && (r >= rows || !canRight(r, c))){
			goDown(0, "", r, r);
			return;
		}
		else if(d.equalsIgnoreCase("r") && canRight(r, c) && isExit(r, c+1)){
			stepsList.add(++steps);
		}
		goRight(++steps, "r", r, c+1);
	}
	
	private void goDown(int steps,String d,int r,int c){			
		if(d.equalsIgnoreCase("d") && (c >= coulmns || !canDown(r, c) ))
			return;
		else if(d.equalsIgnoreCase("d") && canDown(r, c) && isExit(r+1, c)){
			stepsList.add(++steps);
		}
		goDown(++steps, "d", r+1, c);
	}
	
	private boolean isExit(int i,int j){
		return (i==exitRow)?(j==exitColumn)?true:false:false;
	}

	private boolean canLeft(int i, int j) {
		return ((j-1)<0)?false:(maze[i][j-1]==0)?true:false;
	}

	private boolean canUp(int i, int j) {
		return ((i-1)<0)?false:(maze[i-1][j]==0)?true:false;
	}

	private boolean canDown(int i, int j) {
		return ((i+1)>=rows)?false:(maze[i+1][j]==0)?true:false;
	}

	private boolean canRight(int i, int j) {
		return ((j+1)>=(coulmns))?false:(maze[i][j+1]==0)?true:false;
	}
	
	 private boolean mazeUtil(int[][] maze, int i, int j,int step) {
        if(!isSafe(maze, i, j)){     
        	return false;
        }
        if(isGoal(maze, i, j)){
        	++step;
        	System.out.println(i+":"+j+"-"+step);
        	return true;
        }
       
        else {
            maze[i][j] = 2;                             // traversing path
            ++step;
            if(mazeUtil(maze, i, j+1,step))  return true;    // right
            if(mazeUtil(maze, i+1, j,step))  return true;    // down
            if(mazeUtil(maze, i-1, j,step))  return true;    // up
            if(mazeUtil(maze, i, j-1,step))  return true;    // left
            
            maze[i][j] = 3;                             // traversed dead ends
        }
        return false;
	 }

	private boolean isGoal(int[][] maze2, int i, int j) {
		return isExit(i, j);
	}

	private boolean isSafe(int[][] maze, int i, int j) {
		try {
			if(maze[i][j] == 1 || maze[i][j] == 2)   return false;
	        else  return true;
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	public static void print(int[][]maze) {
        System.out.println("\n=============\n");
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] == '-' ? '.' : maze[i][j]);
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		MatrixExit me = new MatrixExit();
	}

}
