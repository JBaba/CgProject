package com.facebook.set1;

//Java implementation using Hashing
import java.io.*;

class PairSum
{
 private static final int MAX = 45; // Max size of Hashmap

 static void printpairs(int arr[],int sum)
 {
     // Declares and initializes the whole array as false
     boolean[] binmap = new boolean[MAX];

     for (int i=0; i<arr.length; ++i)
     {
         int temp = sum-arr[i];

         // checking for condition
         if (temp>=0 && binmap[temp])
         {
             System.out.println("Pair with given sum " +
                                 sum + " is (" + arr[i] +
                                 ", "+temp+")");
         }
         binmap[arr[i]] = true;
     }
 }

 // Main to test the above function
 public static void main (String[] args)
 {
     int A[] = {1, 4, 20, 6, 10, 8};
     int n = 16;
     printpairs(A,  n);
 }
}

//This article is contributed by Aakash Hasija