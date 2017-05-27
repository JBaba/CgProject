package com.facebook.set1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NoFixedFacet;

/**
 * 
 * 	Input: arr[]   = {2, 0, 2}
	Output: 2
	Structure is like below
	| |
	|_|
	We can trap 2 units of water in the middle gap.
	
	Input: arr[]   = {3, 0, 0, 2, 0, 4}
	Output: 10
	Structure is like below
	     |
	|    |
	|  | |
	|__|_| 
	We can trap "3*2 units" of water between 3 an 2,
	"1 unit" on top of bar 2 and "3 units" between 2 
	and 4.  See below diagram also.
	
	Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
	Output: 6
	       | 
	   |   || |
	_|_||_||||||
	Trap "1 unit" between first 1 and 2, "4 units" between
	first 2 and 3 and "1 unit" between second last 1 and last 2 
 * 
 * 
 * @author nviradia
 *
 */

public class TrapRainWater {

	public static void main(String[] args) {
		int[] ary1 = {2, 0, 2};
		int ans = maxWater(ary1);
		System.out.println(ans);
		
		int[] ary2 = {3, 0, 0, 2, 0, 4}; 
		ans = maxWater(ary2);
		System.out.println(ans);
		
		int[] ary3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		ans = maxWater(ary3);
		System.out.println(ans);
		
		findWater(arr.length);
		
	}

	private static int maxWater(int[] ary1) {
		int max = 0;
		int start = 0;
		int end = ary1.length;
		
		while(start<end){
			int subWater = getWater(ary1,start,end,max);
			max = Math.max(max, subWater);
			if(ary1[start]>ary1[end-1]){
				end--;
			}else{
				start++;
			}
				
		}
		
		return max;
	}

	private static int getWater(int[] ary1, int start, int end,int canMax) {
		int levelAtBeg = ary1[start];
		int levelAtEnd = ary1[end-1];
		
		// find mins
		int min = Math.min(levelAtBeg, levelAtEnd);
		
		// total water can be
		int totalWaterCanBe = min * (end-start-2);
		
		if(totalWaterCanBe < canMax || levelAtBeg == 0 || levelAtEnd == 0)
			return 0;
		
		int inBetweenLevel = 0;
		for(int i=start+1;i<end-2;i++){
			if(ary1[i] < min){
				inBetweenLevel += ary1[i];
			}else{
				inBetweenLevel += min * (end-i-2);
				break;
			}
		}
		
		return totalWaterCanBe-inBetweenLevel;
	}
	
	static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    
    // Method for maximum amount of water
    static int findWater(int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];
      
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
      
        // Initialize result
        int water = 0;
      
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
           left[i] = Math.max(left[i-1], arr[i]);
      
        // Fill right array
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
           right[i] = Math.max(right[i+1], arr[i]);
      
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
           water += Math.min(left[i],right[i]) - arr[i];
      
        return water;
    }
}
