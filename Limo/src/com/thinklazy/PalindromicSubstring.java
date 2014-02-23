package com.thinklazy;

import java.util.Arrays;

public class PalindromicSubstring {

	public static void main(String args[]) {
		System.out.println(lps("BBABCBCAB".toCharArray()));
	}

	/*
	 * O(N^2)  ..brute force O(n^3)
	 * 
	 * very similar to longest palindromic subsequence.. but much simpler in terms of determining the solution
	 */
	private static int lps(char[] a) {
		System.out.println(a);
		int n = a.length;
		int largestLen = 1;
		int startPos = 0;
		Boolean isPalin[][] = new Boolean[n][n]; 
		
		for(int i = 0; i< isPalin.length ;i++) {
			Arrays.fill(isPalin[i], false);
		}
		
		//1 length substring
		for(int i = 0 ; i < n ; i++) {
			isPalin[i][i] = true;
		}
		
		//Length 2
		for(int i = 0 ; i < n-1 ; i++) {
			if(a[i] == a[i+1]) {
				isPalin[i][i+1] = true;
				largestLen = 2;
				startPos = i;
			} else {
				isPalin[i][i+1] = false;
			}
		}
		
		//Length 3 and onwards
		for(int len = 3; len <=n ; len++) {
			for(int i = 0; i< n-len+1 ;i++) {
				int j = i+len-1;
				if( isPalin[i+1][j-1] && a[i] == a[j]) {
					isPalin[i][j] = true;
					largestLen = len;
					startPos = i;
				}
			}
		}
		
		//Print solution
		for(int i= startPos ; i < startPos+largestLen ; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
		return largestLen;
	}
	
	
	
}
