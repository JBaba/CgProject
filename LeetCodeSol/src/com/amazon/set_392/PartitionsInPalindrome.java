package com.amazon.set_392;

import java.util.Vector;

public class PartitionsInPalindrome {

	int count = 0;
	
	public static void main(String[] args) {
		PartitionsInPalindrome pip = new PartitionsInPalindrome();
		pip.countPartition("nitin");
	}

	private void countPartition(String name) {
		fun(new char[2*name.length()-1],name,0,0,name.length());
	}
	
	void fun(char[] m,String s,int i,int j,int n){
	    if(i==n){
	        System.out.println((new String(m)).substring(0, j));
	        return;
	    }
	    for(int k=i;k<n;k++){
	        if(isPalindrome(s.toCharArray(),i,k)){
	             int p=j;
	             char[] r=s.substring(i,k-i+1).toCharArray();
	             int l=0;
	             while(r.length>l){
	                 m[p]=r[l];
	                 p++;l++;
	             }
	             m[p]=' ';
	             fun(m,s,k+1,p+1,n);
	        }
	    }
	}

	// A utility function to check if str is palindroem
	boolean isPalindrome(char[] str, int low, int high)
	{
	    while (low < high)
	    {
	        if (str[low] != str[high])
	            return false;
	        low++;
	        high--;
	    }
	    return true;
	}
	 
	

}
