package Test;

import java.util.LinkedList;
import java.util.List;

public class NoOfIlands {
    // 01, 10, 11, -1-1, 1-1
	public static void main(String[] args) {
		int[][] ary = {
				{0,1,0,0,0,0},
				{0,1,0,1,1,0},
				{1,0,0,1,1,0},
				{0,1,0,0,0,0},
				{0,1,0,0,1,1},
				{0,1,0,0,1,1}
		};

		int noOfIlands = ilands(ary);
		System.out.println(noOfIlands);
	}

	private static int ilands(int[][] ary) {
		int count = 0;
		int row = ary.length;
		int col = ary[0].length;
		boolean[][] isVisited = new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( ary[i][j] != 0 // skip zero 
						&& !isVisited[i][j] // mark visited in recursion
						&&	isIland(ary,i,j,isVisited) ) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isIland(int[][] ary, int i, int j,boolean[][] isVisited) {
		List<Cell> list = new LinkedList<>();
		list.add(new Cell(i,j));
		isVisited[i][j] = true;
		// 8 directions
		int[] dx = {0, 0,1,-1,1,-1, 1,-1};
		int[] dy = {1,-1,0, 0,1,-1,-1, 1};
		
		while (!list.isEmpty()) {
			Cell top = list.remove(0);
			for(int k=0;k<8;k++) {
				int _i = top.x+dx[k];
				int _j = top.y+dy[k];
				if(!isSafe(ary,top,_i,_j) || isVisited[_i][_j])
					continue;
				list.add(new Cell(_i, _j));
				isVisited[_i][_j] = true;
			}
		}
		return true;
	}

	private static boolean isSafe(int[][] ary, Cell top, int _i, int _j) {
		if(_i>-1 && _i<ary.length // row boundary
			&& _j>-1 && _j<ary[0].length // col boundary
			&& ary[_i][_j] == 1 // is adjusent neighbers has 1
			) {
			return true;
		}
		return false;
	}

}


class Cell {
	int x,y;
	Cell(int i,int j){
		x=i;
		y=j;
	}
}
