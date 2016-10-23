package leetcode.sol.extra;
/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 * 
 * @author nviradia
 *
 */
public class N_74 {
	public N_74() {
		
		int[][] maze = new int[8][];
		
		for(int i = 0;i<maze.length;i++){
			if(i!=5){
				maze[i] = new int[10];
				for (int j = 0; j < 10; j++) {
					maze[i][j] = ((i*100000)+j);
				}
			}
			else {
				maze[i] = new int[100000];
				for (int j = 0; j < 100000; j++) {
					maze[i][j] = ((i*100000)+j);
				}
			}
		}
		
		int target = 599999;
		
		long start = System.currentTimeMillis();
		searchMatrix(maze,target );
		long end =  System.currentTimeMillis();
		System.out.println((end-start));
	
		start = System.currentTimeMillis();
		searchMatrixWithRec(maze, target, 0);
		end =  System.currentTimeMillis();
		System.out.println((end-start));
		
	}
	
	private boolean searchMatrixWithRec(int[][] matrix, int target, int row) {
		if(row == matrix.length)
			return false;
		
		if(matrix[row][0] <= target && matrix[row][matrix[row].length-1] >= target){
			for (int j = 0; j < matrix[row].length; j++) {
				if(matrix[row][j] == target){
					System.out.println(row+" "+j);
					return true;
				}
			}
		}else{
			searchMatrixWithRec(matrix, target, row+1);
		}
		
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
        
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target){
				for (int j = 0; j < matrix[i].length; j++) {
					if(matrix[i][j] == target){
						System.out.println(i+" "+j);
						return true;
					}
				}
			}
		}
		
		return false;
    }

	public static void main(String[] args){
		N_74 n=new N_74();
	}
	
}
