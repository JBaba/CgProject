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
		int number = 10000000;
		
		for(int i = 0;i<maze.length;i++){
			if(i!=5){
				maze[i] = new int[10];
				for (int j = 0; j < 10; j++) {
					maze[i][j] = ((i*number)+j);
				}
			}
			else {
				maze[i] = new int[number];
				for (int j = 0; j < number; j++) {
					maze[i][j] = ((i*number)+j);
				}
			}
		}
		
		int target = (number*6) -1;
		
		long start = System.currentTimeMillis();
		
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		start = System.currentTimeMillis();
		
		
		searchMatrix(maze,target );
		long end =  System.currentTimeMillis();
		System.out.println((end-start));
	
		System.out.println("------------------");
		
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
				//simple loop
				//return searchUsingLoop(matrix,target,i);
				
				//binary search
				System.out.println(i+" ");
				return binarySearch(matrix[i],target);
			}
		}
		return false;
    }

	/**
	 * 
	 *  1 2 3 4 5 6 7
	 * 
	 * @param arry
	 * @param target
	 * @return
	 */
	private boolean binarySearch(int[] arry, int target) {
		
		//int mid = arry.length/2;
		int start = 0;
		int end = arry.length-1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(target > arry[mid]){
				start = mid+1;
				//mid = (end-start)/2;
				//mid = start + mid + 1;
			}else if(target < arry[mid]){
				end = mid-1;
				//mid = (end-start)/2;
				//mid = start + mid + 1;
			}else if(target == arry[mid]){
				System.out.println(mid);
				return true;
			}
		}
		
		return false;
	}

	private boolean searchUsingLoop(int[][] matrix, int target, int i) {
		// use binary search here
		for (int j = 0; j < matrix[i].length; j++) {
			if(matrix[i][j] == target){
				System.out.println(i+" "+j);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		N_74 n=new N_74();
	}
	
}
