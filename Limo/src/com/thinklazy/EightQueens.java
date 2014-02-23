package com.thinklazy;

public class EightQueens {

	public static void main(String args[]) {
		int[] a = new int[8];
		enumerate(a, 0);
	}
	
	/**
	 * Main recursive back tracking code
	 */
	public static void enumerate(int[] q, int k) {
		if (k == q.length) {
			printQueens(q);
			return;
		}
		
		for (int i = 0; i < q.length; i++) {
			q[k] = i;
			if (isConsistent(q, k)){
				enumerate(q, k + 1);
			}
		}
	}
	
	/***********************************************************************
	 * Return true if queen placement q[k] does not conflict with other queens
	 * q[0] through q[k-1]
	 ***********************************************************************/
	public static boolean isConsistent(int[] q, int k) {
		for (int i = 0; i < k; i++) {
			if (q[i] == q[k])
				return false; // same column
			if ((q[i] - q[k]) == (k - i))
				return false; // same major diagonal
			if ((q[k] - q[i]) == (k - i))
				return false; // same minor diagonal
		}
		return true;
	}

	/***********************************************************************
	 * Print out N-by-N placement of queens from permutation q in ASCII.
	 ***********************************************************************/
	public static void printQueens(int[] q) {
		int N = q.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (q[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
