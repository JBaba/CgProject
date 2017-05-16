package com.facebook.set1;


/**
 * 
 * Calculate maximum value using ‘+’ or ‘*’ sign between two numbers in a string
	Given a string of numbers, the task is to find the maximum value from the string, you can add a ‘+’ or ‘*’ sign between any two numbers.
	
	Examples:
	
	Input : 01231
	Output : 
	((((0 + 1) + 2) * 3) + 1) = 10
	In above manner, we get the maximum value i.e. 10
	
	Input : 891
	Output :73
	As 8*9*1 = 72 and 8*9+1 = 73.So, 73 is maximum.
	Asked in : Facebook
 * 
 * 
 * @author nviradia
 *
 */
public class CalculateMaximum {

	public static void main(String[] args) {
		int ans = 0;
		
		ans = calculateMaximum("891",8,1,8);
		System.out.println(ans);
		
		ans = calculateMaximum_2("891");
		System.out.println(ans);
		
		ans = calculateMaximum("01231",0,1,0);
		System.out.println(ans);
		
		ans = calculateMaximum_2("01231");
		System.out.println(ans);
		
		ans = calculateMaximum("555",5,1,5);
		System.out.println(ans);
		
		ans = calculateMaximum_2("555");
		System.out.println(ans);
	}

	private static int calculateMaximum_2(String num) {
		int res = num.charAt(0) - '0';
		for(int i=1;i<num.length();i++){
			int cur = num.charAt(i) - '0';
			int pre = num.charAt(i-1) - '0';
			if(cur == 1 || cur == 0 || pre == 1 || pre == 0){
				res += cur;
			}else{
				res *= cur;
			}
		}
		return res;
	}

	private static int calculateMaximum(String num,int first,int start,int max) {
		if(start > num.length())
			return 0;
		
		for(int i=start;i<num.length();i++){
			int next = num.charAt(i) - '0';
			int sum = 0, mul = 0;
			
			if(max < (max+next))
				sum = max + next;
			
			if(max < max * next)
				mul = max * next;
			
			if(sum > mul)
				max = sum;
			else
				max = mul;
			
			int subMax = calculateMaximum(num, next, i+1, max);

		}
		return max;
	}
	
}
