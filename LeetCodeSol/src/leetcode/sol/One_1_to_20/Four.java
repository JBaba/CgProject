package leetcode.sol.One_1_to_20;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	
	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	
	Example 1:
	nums1 = [1, 3]
	nums2 = [2]
	
	The median is 2.0
	Example 2:
	nums1 = [1, 2]
	nums2 = [3, 4]
	
	The median is (2 + 3)/2 = 2.5
 * @author jbaba
 *
 */

public class Four {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if(nums1 == null && nums2 == null)
			throw new IllegalArgumentException();
		
		int posNums1 = 0,posNums2 = 0,i=0;
		int total = (nums1.length+nums2.length);
		int mid = (nums1.length+nums2.length)/2;
		
		int[] mergeArry = new int[total];
		double median = 0;
		
		while (posNums1 != nums1.length || posNums2 != nums2.length) {
			Integer value1 = (nums1.length > posNums1) ? nums1[posNums1] : null;
			Integer value2 = (nums2.length > posNums2) ? nums2[posNums2] : null;
			
			if(value1 == null){
				mergeArry[i] = value2;
				posNums2++;
				i++;
			}else if(value2 == null){
				mergeArry[i] = value1;
				posNums1++;
				i++;
			}else if(value1 < value2){
				if(nums1.length >= posNums1){
					mergeArry[i] = value1;
					posNums1++;
					i++;
				}
			}else{
				if(nums2.length >= posNums2){
					mergeArry[i] = value2;
					posNums2++;
					i++;
				}
			}
				
			if((posNums1+posNums2) > mid){
				if(total % 2 != 0){
					median = mergeArry[mid];
				}
				else{
					median = (mergeArry[mid]+mergeArry[mid-1])/2d;
				}
				
				break;
			}
		}
		
		return median;
    }

	public static void main(String[] args) {
		
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};

		Four f = new Four();
		double median = f.findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
		
	}

}
