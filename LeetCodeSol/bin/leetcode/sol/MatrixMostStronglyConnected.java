package Test;

/**
 * Created by viradn on 4/5/2019.
 */
public class MatrixMostStronglyConnected {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        int[][] matrix1 = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 0}
        };
        int ans = maxConnections(matrix1);
        System.out.println("3:"+ans);
    }

    private static void test1() {
        int[][] matrix1 = {
              {1, 1, 0, 0, 0},
              {0, 1, 1, 0, 0},
              {0, 1, 0, 1, 0},
              {1, 0, 0, 0, 0}
        };
        int ans = maxConnections(matrix1);
        System.out.println("3:"+ans);
    }

    private static int maxConnections(int[][] matrix){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                max = Math.max(max,maxConnections(matrix,getMem(matrix),i,j));
            }
        }
        return max;
    }

    private static boolean[][] getMem(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        return new boolean[row][col];
    }

    private static int maxConnections(int[][] matrix,boolean[][] mem,int i,int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(
            i >= row || i < 0 ||
            j >= col || j < 0 ||
            matrix[i][j] == 0 ||
            mem[i][j] == true
        ){
            return 0;
        }
        mem[i][j] = true;
        return 1 + maxConnections(matrix,mem,i+1,j) + maxConnections(matrix,mem,i,j+1)
                + maxConnections(matrix,mem,i-1,j) + maxConnections(matrix,mem,i,j-1);
    }
}
