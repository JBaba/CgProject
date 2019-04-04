public class SumOfSquareNums {

    public static void main(String[] args) {
        int n = 28;
        int len = getMinSum(n);
        System.out.println(n+":"+len);
        for(int i=1;i<10;i++){
            n=i;
            len = getMinSum(n);
            System.out.println(n+":"+len);
        }
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
