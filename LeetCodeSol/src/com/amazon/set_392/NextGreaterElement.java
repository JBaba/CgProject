package com.amazon.set_392;

import java.util.Stack;

public class NextGreaterElement {

	
	
	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		int[] input1 = {4,26,5,2,25};
		
		int[] out = nge.findNGE(input1);
		nge.print(out);
		nge.printNGE(input1, input1.length);
		nge.printStackNGE(input1, input1.length);
		
		int[] input2 = {13,5,7,6,12};
		
		out = nge.findNGE(input2);
		nge.print(out);
		nge.printNGE(input2, input2.length);
	}
	
	private void printStackNGE(int[] arr, int n) {
		int i = 0;
        Stack<Integer> s = new Stack<>();
        int element, next;
 
        /* push the first element to stack */
        s.push(arr[0]);
 
        // iterate for rest of the elements
        for (i = 1; i < n; i++) 
        {
            next = arr[i];
 
            if (s.isEmpty() == false) 
            {
                 
                // if stack is not empty, then 
                // pop an element from stack
                element = s.pop();
 
                /* If the popped element is smaller than 
                   next, then a) print the pair b) keep 
                   popping while elements are smaller and 
                   stack is not empty */
                while (element < next) 
                {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }
 
                /* If element is greater than next, then 
                   push the element back */
                if (element > next)
                    s.push(element);
            }
 
            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }
 
        /* After iterating over the loop, the remaining 
           elements in stack do not have the next greater 
           element, so print -1 for them */
        while (s.isEmpty() == false) 
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
	}

	void printNGE(int arr[], int n)
    {
        int next, i, j;
        for (i=0; i<n; i++)
        {
            next = -1;
            for (j = i+1; j<n; j++)
            {
                if (arr[i] < arr[j])
                {
                    next = arr[j];
                    break;
                }
            }
            System.out.print(next+",");
        }
        System.out.println();
    }

	private void print(int[] input1) {
		for(int i : input1){
			System.out.print(i+",");
		}
		System.out.println();
	}

	private int[] findNGE(int[] input) {
		int[] out = new int[input.length];
		out[out.length-1] = -1;
		
		for(int i = out.length-2;i>=0;i--){
			int ele = findNGEAtPosition(input,i+1);
			out[i] = ele;
		}
		
		return out;
	}

	private int findNGEAtPosition(int[] input, int i) {
		int ref = input[i-1];
		int nge = -1;
		
		for(int j=i; j<input.length ; j++){
			if(input[j] > ref && (nge > input[j] || nge == -1)){
				nge = input[j];
			}
		}
		return nge;
	}

	
	
}
