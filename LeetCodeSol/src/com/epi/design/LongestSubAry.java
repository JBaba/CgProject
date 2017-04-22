package com.epi.design;

import java.util.ArrayList;
import java.util.List;

public class LongestSubAry {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = CanReachEnd.getList("10,22,9,33,23,24,25,26,27,50,41,60,80",list);

		int[] ary = {10,22,9,33,23,24,25,26,27,50,41,60,80};
		
		System.out.println(list);
		int profit = LongestIncreasingSubsequenceLength(ary,ary.length);
		System.out.println(profit);

	}

	 // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
        	System.out.println("a[i]:"+A[i]+" tail[0]:"+tailTable[0]+" ");
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }
 

}
