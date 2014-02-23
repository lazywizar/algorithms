package com.thinklazy;

public class MaxBooleanSubMatric {
	public static void main(String args[]) {
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0}};
             
		printMaxSubSquare(M);
	}
	
	/**
	 * Remember ****** S[i][j]  represent the size of largest solution with M[i][j] a part of it,... 
	 * not the largest sum in the submatrix ending at M[i,j] 
	 * 
	 * Formula is :
	 * a)	Copy first row and first columns as it is from M[][] to S[][]
       b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1],  S[i-1][j],  S[i-1][j-1]) + 1
         Else 
            S[i][j] = 0
	 * 
	 */
	public static void printMaxSubSquare(int[][] M) {
		int m = M.length; 
		int n = M[0].length;
		
		System.out.println("m = " + m);
		System.out.println("n = " + n);
		
		//sub[i][j] => max size of square sub matrix with element ending in M[i][j] .. 
		//note including.. not just in that submatrix starting from M[0,0]
		int sub[][] = new int[m][n];
		
		for(int i = 0; i < m ; i++) {
			sub[i][0] = M[i][0];
		}
		for(int i = 0; i < n ; i++) {
			sub[0][i] = M[0][i];
		}
		
		for(int i = 1; i < m ; i++) {
			for(int j = 1 ; j < n ;j++) {
				if(M[i][j] == 0) {
					sub[i][j] = 0;
				} else {
					sub[i][j] = 1 + Math.min(M[i-1][j-1] ,Math.min(M[i-1][j], M[i][j-1]));
				}
			}
		}
		
		/* Find the maximum entry, and indexes of maximum entry in S[][] */
		int max = -1;
		int max_i = 0;
		int max_j = 0;
		for(int i = 0; i < m ; i ++) {
			for(int j = 0 ; j < n ; j++) {
				if(max < sub[i][j]) {
					max = sub[i][j];
					max_i = i; 
			        max_j = j;
				}
			}
		}
		System.out.println("Starting from max_i:" + max_i + ", max_j:" + max_j);
		for(int i = max_i; i > max_i - max ; i--) {
			for(int j = max_j; j> max_j - max ; j--) {
				System.out.print(M[i][j] );
			}
			System.out.println();
		}
		
		
	}
}
