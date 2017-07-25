package leetcode.sol.set3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 554. Brick Wall My SubmissionsBack To Contest
		User Accepted: 685
		User Tried: 861
		Total Accepted: 702
		Total Submissions: 2201
		Difficulty: Medium
		There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
		
		The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
		
		If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
		
		You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
		
		Example:
		Input: 
		[[1,2,2,1],
		 [3,1,2],
		 [1,3,2],
		 [2,4],
		 [3,1,2],
		 [1,3,1,1]]
		Output: 2
		Explanation: 
		
		Note:
		The width sum of bricks in different rows are the same and won't exceed INT_MAX.
		The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 * @author nviradia
 *
 */

public class N_554 {

	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer,Integer> map = new HashMap<>();
		for(List<Integer> row : wall){
			int sum = 0;
			for(int i=0;i<row.size()-1;i++){
				sum += row.get(i);
				if(map.containsKey(sum)){
					map.put(sum, map.get(sum)+1);
				}else{
					map.put(sum,0);
				}
			}
		}
		
		int max = 0;
		for(Integer item:map.keySet()){
			if(max<map.get(item)){
				max=map.get(item);
			}
		}
		
		return (map.size()-max);
	}
	
	public static void main(String[] args) throws Exception{
		InetAddress msgAddress = InetAddress.getByName("hco431brgdde001");
		String hostName = msgAddress.getCanonicalHostName();
		System.out.println(hostName);
	}
	
}
