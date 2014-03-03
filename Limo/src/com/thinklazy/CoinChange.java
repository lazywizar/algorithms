package com.thinklazy;


// adding comment to test commit

public class CoinChange {

    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        System.out.println(count(arr, 4));
    }

    /**
     * 
     * Solution is sum of all solution excluding mth coin + sum of all solution with atleast 1 mth
     * coin)
     * 
     * count(S,m,n) = count( S, m - 1, n ) + count( S, m, n-S[m-1] );
     * 
     * @param C
     * @param sum
     * @return
     */
    public static int count(int C[], int sum) {
        int m = C.length;
        int count[][] = new int[sum + 1][m];

        for (int i = 0; i < m; i++) {
            count[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < m; j++) {
                int sumWithOneJthCoin = (i >= C[j]) ? count[i - C[j]][j] : 0;
                int sumWithOutJth = (j >= 1) ? count[i][j - 1] : 0;

                count[i][j] = sumWithOutJth + sumWithOneJthCoin;
            }
        }
        return count[sum][m - 1];
    }

    // Simplified and reduced space
    public static int countS(int C[], int sum) {
        int m = C.length;
        int count[] = new int[sum + 1];
        count[0] = 1;

        for (int i = 0; i < m; i++) { // Loop over coins
            for (int j = C[i]; j <= sum; j++) { // For all values up to the sum
                count[j] += count[j - C[i]];
            }
        }
        return count[sum];
    }

}
