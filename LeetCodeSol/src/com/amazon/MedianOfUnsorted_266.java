package com.amazon;

public class MedianOfUnsorted_266 {

	public static void main(String[] args) {
		MedianOfUnsorted_266 md = new MedianOfUnsorted_266();
		
		int[] input = {90, 80, 70, 60, 50, 40, 30 ,10};
		
		System.out.println(md.selection_algorithm(input, 0, input.length-1, input.length/2));
	}
	
	int partitions(int[] A,int low,int high)
	{
	    int p=low,r=high,x=A[r],i=p-1;
	    for(int j=p;j<=r-1;j++)
	    {
	        if (A[j]<=x)
	        {

	            i=i+1;
	            switchEle(A,i,j);
	        }
	    }
	    switchEle(A,i+1,r);
	    return i+1;
	}
	
	int selection_algorithm(int[] A,int left,int right,int kth)
	{
	    for(;;)
	    {
	        int pivotIndex=partitions(A,left,right);          //Select the Pivot Between Left and Right
	        int len=pivotIndex-left+1;

	        if(kth==len)
	            return A[pivotIndex];

	        else if(kth<len)
	            right=pivotIndex-1;

	        else
	        {
	            kth=kth-len;
	            left=pivotIndex+1;
	        }
	    }
	}
	
	private void switchEle(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j]=temp;
	}

}
