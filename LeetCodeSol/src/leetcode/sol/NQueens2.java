/*

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]


*/

class NQueens2 {
    int count=0;
    public int totalNQueens(int n) {
        int[] queue = new int[n];
        backtrack(0,queue,n);
        return count;
    }
    
    private void backtrack(int row,int[] queue,int n){
        if(row==n){
            count++;
        }else{
            for(int i=0;i<n;i++){
                if(isOk(row,i,queue)){
                    queue[row]=i;
                    backtrack(row+1,queue,n);
                }
            }
        }
    }
    
    private boolean isOk(int row,int col,int[] queue){
        int leftup=col-1,rightup=col+1;
        int n=queue.length;
        for(int i=row-1;i>=0;i--){
            if(queue[i]==col) return false;
            if(leftup>=0&&queue[i]==leftup) return false;
            if(rightup<n&&queue[i]==rightup) return false;
            leftup--;rightup++;
        }
        return true;
    }
}
