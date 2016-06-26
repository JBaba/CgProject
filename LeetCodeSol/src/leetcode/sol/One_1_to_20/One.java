package leetcode.sol.One_1_to_20;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

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
	
	public int[] twoSum2(int[] nums, int target){
		if(nums==null)
			throw new IllegalArgumentException();
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if((nums[i]+nums[j])==target){
					return new int[]{i,j};
				}
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	public int[] twoSum(int[] nums, int target){
		if(nums==null)
			throw new IllegalArgumentException();
		
		Map<Integer, Integer> hashNums = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashNums.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if(hashNums.containsKey(temp) && hashNums.get(temp)!=i){
				return new int[]{i,hashNums.get(temp)};
			}
		}
		
		throw new IllegalArgumentException();
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

	public static void main(String[] args) throws Exception {
		One o = new One();
		int[] nums1 = {2, 7, 11, 15};
		o.print(o.twoSum(nums1, 9));
		int[] nums2 = {3,80,3,4};
		o.print(o.twoSum(nums2, 6));
		//o.print(o.twoSum(null, 6));
		o.print(o.twoSum(new int[]{}, 6));
	}

}
