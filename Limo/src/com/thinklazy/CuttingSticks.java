package com.thinklazy;

public class CuttingSticks {
	public static void main(String args[]) {
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Maximum Obtainable Value is " + cutRod(arr));
	
	    System.out.println("Maximum Obtainable Value is " + cutRodRec(arr, arr.length));
	}
	
	/**
	 * DP
	 * @param value
	 * @return
	 */
	public static int cutRod(int value[]) {
		int n = value.length;
		int cut[] = new int[n+1];
		cut[0] = 0;
		for(int i = 1 ; i <= n ; i++) {
			cut[i] = -1;
			for(int j = 0 ; j < i;j++) {
				cut[i] = Math.max(cut[i-j-1] + value[j], cut[i]);
			}
		}
		return cut[n];
	}
	
	/**
	 * Recursion.. pure.. very bad
	 * @param value
	 * @param n
	 * @return
	 */
	public static int cutRodRec(int value[], int n) {
		if(n <= 0) {
			return 0;
		}
		int max = -1;
		for(int i = 0 ;i< n; i++) {
			max = Math.max(max, cutRodRec(value, n-i-1) + value[i]);
		}
		return max;
	}
}
 