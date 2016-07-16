package leetcode.sol.One_1_to_20;

/**
 * 55 Gump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 * @author jbaba
 *
 */

public class N_55 {

	public boolean canJump(int[] nums) {
			if(nums == null){
				throw new IllegalArgumentException();
			}
			if(nums.length == 0){
				return false;
			}
			if(nums.length == 1){
				return true;
			}
			int size = nums.length;
			
			for(int i=0;i<size;i++){
				
				if(i == (size))
					return true;
				
				if(nums[i] == 0)
					return false;
	
				int value = nums[i];
				i = i + value - 1;
			}
			
			return true;
    }
	
	public static void main(String[] args) {
		N_55 n = new N_55();
		boolean ans = false;
		
		int[] A = {2,3,1,1,4};
		ans = n.canJump(A);
		System.out.println(ans);
		
		int[] B = {3,2,1,0,4};
		ans = n.canJump(B);
		System.out.println(ans);
		
		int[] C = {1,0,2};
		ans = n.canJump(C);
		System.out.println(ans);
		
		int[] D = {1,2};
		ans = n.canJump(D);
		System.out.println(ans);
		
		int[] E = {2,0,0};
		ans = n.canJump(E);
		System.out.println(ans);
		
	}

}
