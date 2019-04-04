package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by viradn on 3/27/2019.
 */
public class SumOfSquareNumsuUsingMemory {

    public static void main(String[] args) {
        int n = 28;
        int len = getMinSum(n);
        System.out.println(n+":"+len);
        for(int i=1;i<10;i++){
            n=i;
            System.out.println(n+" : "+getMinSum(n)+":"+howManySquares(n));
        }
    }

    private static int howManySquares(int n) {
        int perfectSqNumsLength = 1;
        while (perfectSqNumsLength * perfectSqNumsLength < n) {
            perfectSqNumsLength++;
        }

        if (perfectSqNumsLength * perfectSqNumsLength > n) {
            perfectSqNumsLength--;
        }

        int[] perfectSqNums = new int[perfectSqNumsLength];

        // Fill the array backwards so we get the numbers to work with
        for (int i = perfectSqNumsLength - 1; i >= 0; i--) {
            perfectSqNums[perfectSqNumsLength - i - 1] = (i+1) * (i+1);
        }

        // instantiate a hashmap of possible paths
        Map<Integer,Integer> paths = new HashMap<Integer, Integer>();
        paths.put(1,1);
        paths.put(0,0);

        return numSquares(paths, perfectSqNums, n);
    }

    private static int numSquares(Map<Integer,Integer> paths,int[] perfectSqNums,int n) {
        if (paths.containsKey(n)) {
            // we already knew the paths to add up to n.
            return paths.get(n);
        };

        int min = Integer.MAX_VALUE;
        int thisPath = 0;

        for(int i = 0; i < perfectSqNums.length; i++) {
            if (n - perfectSqNums[i] >= 0) {
                int difference = n - perfectSqNums[i];
                // this is key - recursively solve for the next perfect square
                // that could sum to n by traversing a graph of possible perfect square sums
                thisPath = numSquares(paths, perfectSqNums, difference);

                // compare the number of nodes required in this path
                // to the current minimum
                min = Math.min(min, thisPath);
            }
        }

        min++;  // increment the number of nodes seen
        paths.put(n,min); // set the difference for this number to be the min so far

        return min;
    }

    private static int getMinSum(int n) {
        int maxSqIndex = 0;
        while ((maxSqIndex*maxSqIndex)<n){
            maxSqIndex++;
        }
        if((maxSqIndex*maxSqIndex)>n){
            maxSqIndex--;
        }
        int minval = 0;
        return findMin(n,maxSqIndex,minval);
    }

    private static int findMin(int n, int maxSqIndex,int minVal) {
        if(n==0){
            return minVal;
        }else {
            if(n>0){
                int minOfAllval = Integer.MAX_VALUE;
                for(int i=maxSqIndex;i>0;i--){
                    if((i*i)>n)
                        return minOfAllval;
                    ++minVal;
                    minOfAllval = Math.min(minOfAllval,findMin(n-(i*i),maxSqIndex,minVal));
                    if(minOfAllval == Integer.MAX_VALUE)
                        minOfAllval = Math.min(minOfAllval,findMin(n-(i*i),maxSqIndex-1,minVal));
                    --minVal;
                }
                return minOfAllval;
            }
        }
        return Integer.MAX_VALUE;
    }

}
