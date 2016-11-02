package leetcode.sol.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 * @author nviradia
 *
 */
public class Spiral {

	char direction;
	
	public Spiral() {
		
		int matrix[][] = {
				 { 1, 2, 3, 4, 5, 6, 7 },
				 { 7, 8, 9,10,11,12,13 },
				 {14,15,16,17,18,18,20 },
				 {20,21,22,23,24,25,26 },
				 /*{30,31,32,33,34,35,36 },
				 {40,41,42,43,44,45,46 }*/
		};
		
		List<Integer> listofInt = spiralOrder(matrix);
		System.out.println(listofInt);
		
		int matrix2[][] = {
				 { 1, 2, 3, 4, 5, 6, 7 },
				 { 7, 8, 9,10,11,12,13 },
				 {14,15,16,17,18,18,20 },
				 {20,21,22,23,24,25,26 },
				 /*{30,31,32,33,34,35,36 },
				 {40,41,42,43,44,45,46 }*/
		};
		
		listofInt.clear();
		listofInt = spiralOrderLeet(matrix2);
		System.out.println(listofInt);
	}
	
	 public List<Integer> spiralOrder(int[][] matrix) {
		 List<Integer> storeFoundIntList = new ArrayList<Integer>();
		 direction = 'r';
		 spiralSearch(matrix,storeFoundIntList,0,0);
		 return storeFoundIntList;
	 }
	 
	    public ArrayList<Integer> spiralOrderLeet(int[][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	 
	        if(matrix == null || matrix.length == 0) return result;
	 
	        int m = matrix.length;
	        int n = matrix[0].length;
	 
	        int x=0; 
	        int y=0;
	 
	        while(m>0 && n>0){
	 
	            //if one row/column left, no circle can be formed
	            if(m==1){
	                for(int i=0; i<n; i++){
	                    result.add(matrix[x][y++]);
	                }
	                break;
	            }else if(n==1){
	                for(int i=0; i<m; i++){
	                    result.add(matrix[x++][y]);
	                }
	                break;
	            }
	 
	            //below, process a circle
	 
	            //top - move right
	            for(int i=0;i<n-1;i++){
	                result.add(matrix[x][y++]);
	            }
	 
	            //right - move down
	            for(int i=0;i<m-1;i++){
	                result.add(matrix[x++][y]);
	            }
	 
	            //bottom - move left
	            for(int i=0;i<n-1;i++){
	                result.add(matrix[x][y--]);
	            }
	 
	            //left - move up
	            for(int i=0;i<m-1;i++){
	                result.add(matrix[x--][y]);
	            }
	 
	            x++;
	            y++;
	            m=m-2;
	            n=n-2;
	        }
	 
	        return result;
	    }
	
	private void spiralSearch(int[][] matrix, List<Integer> storeFoundIntList,int row,int column) {
		if(!isDeadEnd(matrix,row,column)){
			storeFoundIntList.add(matrix[row][column]);
			matrix[row][column] = Integer.MIN_VALUE;
		}
		else{
			setNextDirection();
			return;
		}
		
		if(direction == 'r')
			spiralSearch(matrix, storeFoundIntList, row, column+1);
		if(direction == 'd')
			spiralSearch(matrix, storeFoundIntList, row+1, column);
		if(direction == 'l')
			spiralSearch(matrix, storeFoundIntList, row, column-1);
		if(direction == 'u')
			spiralSearch(matrix, storeFoundIntList, row-1, column);
		
		if(!isDeadEnd(matrix, row, column+1))
			spiralSearch(matrix,storeFoundIntList,row,column+1);
		
		return;
	}

	private void setNextDirection() {
		if(direction == 'r'){
			direction = 'd';
			return;
		}
		if(direction == 'd'){
			direction = 'l';
			return;
		}
		if(direction == 'l'){
			direction = 'u';
			return;
		}
		if(direction == 'u'){
			direction = 'r';
			return;
		}
	}

	private boolean isDeadEnd(int[][] matrix, int row, int column) {
		boolean isDeadEnd = false;
		try{
			isDeadEnd = (matrix[row][column] != Integer.MIN_VALUE)?false:true;
		}catch(ArrayIndexOutOfBoundsException e){
			return true;
		}
		return isDeadEnd;
	}

	public static void main(String[] args) {
		Spiral run = new Spiral();
	}

}
