package com.epi.design;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {

		int i = 0;
		
		Integer[] a = {5,6,7,8,9,1,2,3,4};
		
		System.out.println(i);
		
		List<Integer> list = Arrays.asList(a);
		
		System.out.println(list.size());
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		i = Arrays.binarySearch(a, 10);
		
		System.out.println(i);
		
		Arrays.fill(a, 10);
		
		System.out.println(Arrays.toString(a));
	
		
		// initializing Object array1
	   Object[] b1 = new Object[] { 'a', 'b' };

	   // let us print all the values available in array2
	   System.out.println("Elements of Array1 is:");
	   for (Object value : b1) {
	   System.out.println("Value = " + value);
	   }

	   // initializing Object array2
	   Object[] b2 = new Object[] { 'a', 'b' };

	   // let us print all the values available in array2
	   System.out.println("Elements of Array2 is:");
	   for (Object value : b2) {
	   System.out.println("Value = " + value);
	   }

	   // initializing Object array3
	   Object[] b3 = new Object[] { 'x', 'y' };

	   // let us print all the values available in array3
	   System.out.println("Elements of Array3 is:");
	   for (Object value : b3) {
	   System.out.println("Value = " + value);
	   }

	   // checking array1 and array2 for equality
	   System.out.println("Array1 and Array2 are equal:" + Arrays.deepEquals(b1,b2));
	    
	   // checking array1 and array3 for equality
	   System.out.println("Array1 and Array3 are equal:" + Arrays.deepEquals(b1,b3));  
		
	}

}
