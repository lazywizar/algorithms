package com.thinklazy;

public class MinCost {
	public static void main(String args[]){
	   int cost[][] = { {1, 2, 3},
	                      {4, 8, 2},
	                      {1, 5, 3} };
	   System.out.println(minCost(cost, 2, 2));
	}
	
	public static int minCost(int cost[][], int m, int n)
	{
	     int i, j;
	     int tc[][] = new int[cost[0].length + 1] [cost.length + 1];  
	 
	     tc[0][0] = cost[0][0];
	 
	     /* Initialize first column of total cost(tc) array */
	     for (i = 1; i <= m; i++)
	        tc[i][0] = tc[i-1][0] + cost[i][0];
	 
	     for (j = 1; j <= n; j++)
	        tc[0][j] = tc[0][j-1] + cost[0][j];
	 
	     /* Construct rest of the tc array */
	     for (i = 1; i <= m; i++)
	        for (j = 1; j <= n; j++)
	            tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];
	 
	     return tc[m][n];
	}
	
	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}
