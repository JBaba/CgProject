public class CanArrayBeDevidedIntoEqualSetOfTwoArray {
    public static void main(String[] args) {
        int[] nums = {5,7,19,7};
        System.out.println(hasEqualSubsets(nums));
    }

    static boolean hasEqualSubsets(int[] set){
        int sum = doSum(set);
        if(sum%2 != 0){
            return false;
        }
        return hasEqualSubsets(set,sum/2,0,set.length);
    }

    private static boolean hasEqualSubsets(int[] set, int target, int start, int len) {
        if(target==0){
            return true;
        }else{
            if(target > 0){
                for (int i=start;i<len;i++){
                    if(hasEqualSubsets(set,target-set[i],i+1,len)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static int doSum(int[] set){
        int sum = 0;
        for (int i=0;i<set.length;i++){
            sum+=set[i];
        }
        return sum;
    }
}
