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
		
		int[][] maze = {{1,   3,  5,  7},
				  		{10, 11, 16, 20},
				  		{23, 30, 34, 50}};
		
		searchMatrix(maze, 30);
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
