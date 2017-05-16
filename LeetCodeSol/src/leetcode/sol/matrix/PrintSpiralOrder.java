package leetcode.sol.matrix;

public class PrintSpiralOrder {

	public static void main(String[] args) {
		int[][] m = {{1,2,3},
				     {4,5,6},
				     {7,8,9}};
		int[][] m1 = {{1,2,3,4},
				      {5,6,7,8},
				      {9,10,11,12},
				      {13,14,15,16}};
		int[][] m2 = {{1,2,3,4,5},
			          {11,12,13,14,15},
			          {21,22,23,24,25}};
		
		printSpiralOrder_2(m);
		System.out.println();
		printSpiralOrder_2(m2);
		System.out.println();
		printSpiralOrder(m1);
	}

	private static void printSpiralOrder_2(int[][] m) {
		int r = m.length, c=m[0].length;
		int i=0,j=0;
		while(r>i && c>j){
			for(int k=j;k<c;k++){
				System.out.print(m[i][k]+",");
			}
			i++;
			for(int k=i;k<r;k++){
				System.out.print(m[k][c-1]+",");
			}
			c--;
			if(i<r){
				for(int k=c-1;k>=j;k--){
					System.out.print(m[r-1][k]+",");
				}
				r--;
			}
			if(j<c){
				for(int k=r-1;k>=i;k--){
					System.out.print(m[k][j]+",");
				}
				j++;
			}
		}
	}

	private static void printSpiralOrder(int[][] m) {
		int r = m.length, c=m[0].length;
		int i=0,j=0;
		while(i<(r/2)){
			for(int k=i;k<c-i-1;k++){
				System.out.print(m[i][k]+",");
			}
			for(int k=j;k<c-j-1;k++){
				System.out.print(m[k][c-j-1]+",");
			}
			for(int k=c-i-1;k>i;k--){
				System.out.print(m[c-i-1][k]+",");
			}
			for(int k=c-i-1;k>i;k--){
				System.out.print(m[k][j]+",");
			}
			i++;
			j++;
		}
	}

}
