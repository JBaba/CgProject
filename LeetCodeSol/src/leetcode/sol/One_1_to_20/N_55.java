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
		return false;
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
		
	}

}
