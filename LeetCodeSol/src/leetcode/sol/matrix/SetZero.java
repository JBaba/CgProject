package leetcode.sol.matrix;

public class SetZero {

	int[][] matrix = {{0,0,1,0},
			        {1,1,1,1},
			        {1,0,1,1},
			        {1,1,1,1}};
	
	int[][] copy = null;
	
	public SetZero() {
		
		setZeroes(matrix);
	}
	
	public void setZeroes(int[][] matrix) {
        setZeroes(0,0);
    }
	
	private void setZeroes(int i, int j) {
			
	}

	public static void main(String[] args) {
		char c='\0';
		System.out.println("-"+(int)c);
	}

}
