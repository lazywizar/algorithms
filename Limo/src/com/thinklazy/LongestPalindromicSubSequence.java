package com.thinklazy;

public class LongestPalindromicSubSequence {

    public static void main(String args[]) {
        System.out.println(lps("BBABCBCAB".toCharArray()));
    }

    /**
     * O(N^2)
     * 
     */
    public static int lps(char[] a) {
        int n = a.length;

        // count[i][j] => LCS for substring A[i]...A[j]
        int count[][] = new int[n + 1][n + 1];

        // Len 1
        for (int i = 0; i < n; i++) {
            count[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (a[i] == a[j]) {
                    if (j == i + 1) { // 2 character long sub sequence
                        count[i][j] = 2;
                    } else {
                        count[i][j] = count[i + 1][j - 1] + 2;
                    }
                } else {
                    count[i][j] = Math.max(count[i + 1][j], count[i][j - 1]);
                }
            }
        }
        return count[0][n - 1];
    }

}
