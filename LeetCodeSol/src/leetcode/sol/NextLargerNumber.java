import java.util.Arrays;
import java.util.Stack;

/**
 * Created by viradn on 5/20/2019.
 */
public class NextLargerNumber {

    public static void main(String[] args) {
        int[] ary = {3,1,3,4};
        int[] out = nextLargerNumber(ary);
        Arrays.stream(out).forEach(value -> System.out.print(value+","));
    }

    private static int[] nextLargerNumber(int[] ary) {
        int[] result = new int[ary.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<ary.length;i++){
            result[i] = -1;
        }
        for(int i=0;i<ary.length*2;i++){
            int num = ary[i % ary.length];
            while (!stack.isEmpty() && ary[stack.peek()]<num){
                result[stack.pop()] = num;
            }
            if(i<ary.length){
                stack.push(i);
            }
        }
        return result;
    }

}
