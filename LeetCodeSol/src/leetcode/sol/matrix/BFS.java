package leetcode.sol.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	int rows = 4;
	int coulmns = 4 ;
	int totalNode = rows * coulmns;
	int exitRow = 1;
	int exitColumn = 3;
	Point front = null;
	int[][] maze = {{0,0,0,1},
			        {0,0,1,0},
			        {0,0,0,0},
			        {0,0,0,0}};
	int[][] mazeStatus = {{0,0,0,0},
				        {0,0,0,0},
				        {0,0,0,0},
				        {0,0,0,0}};
	Queue<Point> queue = new LinkedList<>();
	
	public BFS() {
		queue.add(new Point(0, 0));
		mazeStatus[0][0] = 1;
		print(maze);
		bfs();
		print(mazeStatus);
	}
	
	private void bfs() {
		while (!queue.isEmpty()) {
			Point front = queue.poll();
			this.front = front;
			if(isExit(front)){
				System.out.println(front);
				return;
			}
 			addNeighboursToQueue(this.front,"r");
		}
	}

	private void addNeighboursToQueue(Point front,String dir) {
		try{
			if(mazeStatus[front.x][front.y] == 0 && maze[front.x][front.y] == 0){
				queue.add(new Point(front.x, front.y));
				mazeStatus[front.x][front.y] = mazeStatus[this.front.x][this.front.y] + 1;
			}else if(mazeStatus[front.x][front.y] == 0 && maze[front.x][front.y] == 1){
				mazeStatus[front.x][front.y] = -1;
			}
		}catch (Exception e) {
			
		}
		
		if(dir.equalsIgnoreCase("r"))
			addNeighboursToQueue(new Point(this.front.x, this.front.y+1),"d");
		if(dir.equalsIgnoreCase("d"))
			addNeighboursToQueue(new Point(this.front.x+1, this.front.y),"l");
		if(dir.equalsIgnoreCase("l"))
			addNeighboursToQueue(new Point(this.front.x, this.front.y-1),"u");
		if(dir.equalsIgnoreCase("u"))
			addNeighboursToQueue(new Point(this.front.x-1, this.front.y),"");
		
		return;
	}

	private boolean isExit(Point point) {
		return (point.x == exitRow && point.y == exitColumn)?true:false;
	}

	public static void print(int[][]maze) {
        System.out.println("\n=============\n");
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                System.out.print(String.format("%2d", maze[i][j]));
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		BFS me = new BFS();
	}

}

class Point {
	int x, y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}
