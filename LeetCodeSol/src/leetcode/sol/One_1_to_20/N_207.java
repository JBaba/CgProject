package leetcode.sol.One_1_to_20;

import java.util.HashSet;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
	For example:
	
	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	
	2, [[1,0],[0,1]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	
	Note:
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

 * @author jbaba
 *
 */

public class N_207 {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
			if(prerequisites.length==0){
				return true;
			}
		Set<Integer> list = new HashSet<>();
		list.add(prerequisites[0][0]);
		for(int i=0;i<prerequisites.length;i++){
			list.add(prerequisites[i][0]);
			if(list.contains(prerequisites[i][1])){
				return false;
			}else{
				list.add(prerequisites[i][1]);
			}
		}
		return true;
    }

	public static void main(String[] args) {
		System.out.println("N 207");
		N_207 n = new N_207();
		int[][] prerequisites = {{1,0},{0,1}};
		System.out.println(n.canFinish(2, prerequisites));
	}

}
