package com.facebook.set1;

public class CountStepsClimb {

	public static void main(String[] args) {

		int ans = countNumberOfWaysToClimbSteps(3,0);
		
		System.out.println(ans);
		
	}

	private static int countNumberOfWaysToClimbSteps(int no,int start) {
		
		if(no == start)
			return 1;
		
		if(no < start)
			return 0;
		
		return countNumberOfWaysToClimbSteps(no, start+1)
			+ countNumberOfWaysToClimbSteps(no, start+2)
			+ countNumberOfWaysToClimbSteps(no, start+3);
	}

}
