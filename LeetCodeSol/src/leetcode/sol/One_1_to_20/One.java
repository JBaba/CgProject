package leetcode.sol.One_1_to_20;

/**
 * @author jbaba
 *
 *	Given nums = [2, 7, 11, 15], target = 9,
 *
 *	Because nums[0] + nums[1] = 2 + 7 = 9,
 *	return [0, 1].
 *
 */

public class One {
	
	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2]; 
		
		if(nums==null || nums.length < 2)
			return indices;
		
		int sum = nums[0]+nums[1];
		
		if(sum==target){
			indices[0]=0;
			indices[1]=1;
			return indices;
		}
		
		for (int i = 2; i < indices.length; i++) {
			sum = sum - indices[i-2];
			sum = sum + indices[i];
			
			if(sum == target){
				indices[0]=i-1;
				indices[1]=i;
			}
		}
		
		return indices;
	}
	
	public void print(int[] nums){
		if(nums!=null){
			System.out.print("Ans: ");
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]+",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		One o = new One();
		int[] nums1 = {2, 7, 11, 15};
		o.print(o.twoSum(nums1, 9));
	}

}
