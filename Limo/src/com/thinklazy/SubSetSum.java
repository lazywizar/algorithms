package com.thinklazy;

public class SubSetSum {
	
	public static void main(String args[]) {
	  int set[] = {3, 34, 4, 12, 5, 2};
	  int sum = 9;
	  int n = set.length;
	  if (isSubsetSum(set, sum) == true)
	     System.out.println("Found a subset with given sum");
	  else
	     System.out.println("No subset with given sum");
	}

	private static boolean isSubsetSum(int[] set, int sum) {
		 int n =  set.length;
		 boolean[][] hasSubSet = new boolean[sum+1][n+1]; //A[i][j] => true if A[0...j] has subset of sum i;
		
		 for(int i = 0; i <= n; i++) {
			 hasSubSet[0][i] = true;
		 }
		 
		 for(int i = 1; i <= sum; i++) {
			 hasSubSet[i][0] = false;
		 }
		  
		 for(int i = 1; i <= sum ; i++) {
			 for(int j = 1; j <= n ; j++) {
				 if(i >= set[j-1]) {
					 hasSubSet[i][j] = hasSubSet[i][j-1] || hasSubSet[i-set[j-1]][j-1];
				 } else {
					 hasSubSet[i][j] = hasSubSet[i][j-1];
				 }
			 }
		 }
		 return hasSubSet[sum][n];
	}
	
	
}
