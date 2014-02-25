package com.thinklazy;

import java.util.ArrayList;
import java.util.List;

public class FillZeroMatrix {
	public static void main(String args[]) {
		int M[][] = { {1 , 1, 1, 1, 1},
					  {1 , 0, 1, 1, 1},
					  {1 , 1, 1, 1, 1},
					  {1 , 1, 1, 1, 1}};
		
		int m = M.length;
		int n = M[0].length;
		fillZeros(M);
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n ;j ++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void fillZeros(int M[][]) {
		List<Integer> zeroRows = new ArrayList<Integer>();
		List<Integer> zeroCols = new ArrayList<Integer>();
		
		int m = M.length;
		int n = M[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n ;j ++) {
				if(M[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);	
				}
			}
		}
		
		for(int r : zeroRows) {
			for(int i = 0; i < n; i++) {
				M[r][i] = 0;
			}
		}
		for(int c : zeroCols) {
			for(int i = 0; i < m; i++) {
				M[i][c] = 0;
			}
		}
	}
}
