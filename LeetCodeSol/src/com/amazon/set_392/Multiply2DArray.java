package com.amazon.set_392;

import java.util.Arrays;

public class Multiply2DArray {

	public static void main(String[] args) {
		Multiply2DArray m2a = new Multiply2DArray();
		char[][] input1 = {{'a','b'},{'c','d'}};
		print(input1);
		char[][] output = m2a.multiplay(input1);
		print(output);
		char[][] input2 = {{'a','b'},{'c','d'},{'e','f'},{'g','h'},{'i','j'}};
		print(input2);
		char[][] output2 = m2a.multiplay(input2);
		print(output2);
	}

	
	
	private static void print(char[][] input) {
		for(int i=0;i<input.length;i++)
			System.out.print(Arrays.toString(input[i]));
		System.out.println();
	}



	private char[][] multiplay(char[][] input) {
		int factorial = fact(input.length);
		char[][] output = new char[factorial*2][2];
		int index = 0;
		for(int i=0;i<input.length;i++){
			for(int j=0;j<2;j++){
				char c = input[i][j];
				
				for(int k=i+1;k<input.length;k++){
					for(int l=0;l<2;l++){
						output[index][0] = c;
						output[index][1] = input[k][l];
						index++;
					}
				}
			}
		}
		
		return output;
	}



	private int fact(int length) {
		int out = 1;
		for(int i=1;i<=length;i++)
			out = out * i;
		return out;
	}

}
