package com.amazon;

import java.util.HashSet;
import java.util.Set;

public class PosibbleCombinations_266 {

	public static void main(String[] args) {

		PosibbleCombinations_266 ps = new PosibbleCombinations_266();
		Set<String> set = ps.permutationFinder("Naimish");
		System.out.println(set);
		perm2("abc".toCharArray(), 3);
	}
	
	 // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }

	
	private static void perm2(char[] a, int n) {
        if (n == 1) {
        	System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    } 
	
	// swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
	
	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

	private void generatePossibleCombinations(String string) {
		for(int i=string.length()-1 ; i > 0 ; i--){
			string = swith(i,string.length()-1,string);
			generatePossibleCombinations(string.substring(0, string.length()));
			System.out.println(string);
			string = swith(i,string.length()-1,string);
		}
	}

	private String swith(int i, int length, String string) {

		char c1 = string.charAt(i);
		char c2 = string.charAt(length);
		
		char[] ary = string.toCharArray();
		ary[length] = c1;
		ary[i] = c2;
		
		return new String(ary);
	}

}
