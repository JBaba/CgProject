package leetcode.sol.matrix;
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
public class N_75 {
	
	public int[][] matrix = {
			  {1,   4,  7, 11, 15},
			  {2,   5,  8, 12, 19},
			  {3,   6,  9, 16, 22},
			  {10, 13, 14, 17, 24},
			  {18, 21, 23, 26, 30}
		};
	
	public int[] arry = {1,2,3,4,5,6,7,8,9,10};
	
	public N_75() {
		binarySearch(arry, 11);
		solv(16);
	}
	
	public void solv(int target){
		for(int i = 0;i<matrix.length;i++){
			boolean flag = false;
			if(matrix[i][0] <= target && matrix[i][matrix.length-1] >= target){
				System.out.print(i+" ");
				flag = binarySearch(matrix[i], target);
			}
			System.out.println();
			if(flag)
				break;
		}
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
		
		int start = 0;
		int end = arry.length-1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(target > arry[mid]){
				start = mid+1;
			}else if(target < arry[mid]){
				end = mid-1;
			}else{
				System.out.print(mid);
				return true;
			}
		}
		
		return false;
	}


	public static void main(String[] args){
		N_75 n=new N_75();
		System.out.println("Done...");
	}
	
}
