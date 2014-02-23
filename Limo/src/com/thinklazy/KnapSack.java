package com.thinklazy;

/*
 * 1) Maximum value obtained by n-1 items and W weight (excluding nth item).
 * 2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).
 */

public class KnapSack {
	int knapSack(int W, int wt[], int val[]) {
	   int n = val.length;	
	   int i, w;
	   int K[][] = new int[n+1][W+1];
	 
	   // Build table K[][] in bottom up manner
	   for (i = 0; i <= n; i++)
	   {
	       for (w = 0; w <= W; w++)
	       {
	           if (i==0 || w==0)
	               K[i][w] = 0;
	           else if (wt[i-1] <= w)
	                 K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	           else
	                 K[i][w] = K[i-1][w];
	       }
	   }
	 
	   return K[n][W];
	}

	int max(int a, int b) {
		return Math.max(a, b);
	}
}
