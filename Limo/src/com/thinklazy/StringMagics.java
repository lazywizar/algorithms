package com.thinklazy;

import java.util.ArrayList;
import java.util.List;

public class StringMagics {
    public static void main(String args[]) {
        char X[] = "AGGTAB".toCharArray();
        char Y[] = "GXTXAYB".toCharArray();
        System.out.println("AGGTAB");
        System.out.println("GXTXAYB");

        System.out.println(LCSTabulated(X, Y));

        /*
         * int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 }; System.out.println("\nresult : " +
         * getLISLength(arr)); for(int c : failure("abcabcd".toCharArray())){ System.out.print (c +
         * " "); } System.out.println(); KMP("abbcdabcdsgbab".toCharArray(), "ab".toCharArray());
         * 
         * for(String s : generateSubs("abcd")) { System.out.println(s); }
         */
    }



    public static int LCSTabulated(char[] a, char[] b) {
        int m = a.length;
        int n = b.length;
        int lcs[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else {
                    if (a[i - 1] == b[j - 1]) {
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    } else {
                        lcs[i][j] = max(lcs[i][j - 1], lcs[i - 1][j]);
                    }
                }
            }
        }

        System.out.println(printLCS(a, b, lcs, m - 1, n - 1));

        return lcs[m][n];
    }

    public static String printLCS(char[] a, char[] b, int[][] lcs, int m, int n) {
        if (m < 0 || n < 0) {
            return "";
        }
        if (a[m] == b[n]) {
            return printLCS(a, b, lcs, m - 1, n - 1) + a[m];
        }

        if (lcs[m - 1][n] > lcs[m][n - 1]) {
            return printLCS(a, b, lcs, m - 1, n);
        } else {
            return printLCS(a, b, lcs, m, n - 1);
        }
    }

    /**
     * LIS : O(n^2) DP based solution
     * 
     * @param s
     * @return
     */
    public static int getLISLength(int[] arr) {
        int[] lis = new int[arr.length];
        int i;
        int j;
        int max = 0;
        int n = arr.length;

        for (i = 0; i < n; i++)
            lis[i] = 1;

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (max < lis[i])
                max = lis[i];
        }
        printLis(lis, lis.length - 1, arr, max);
        return max;

    }

    public static void printLis(int[] lis, int lisIndex, int[] arr, int max) {
        if (max == 0) {
            return;
        }
        if (lis[lisIndex] == max) {
            printLis(lis, lisIndex - 1, arr, max - 1);
            System.out.print(arr[lisIndex] + " ");
        } else {
            printLis(lis, lisIndex - 1, arr, max);
        }

    }

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static List<String> generateSubs(String s) {
        List<String> subs = new ArrayList<String>();
        for (int len = 0; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String sub = s.substring(i, len + i);
                if (!sub.isEmpty())
                    subs.add(sub);
            }
        }
        return subs;
    }

    public static int[] failure(char[] pat) {
        int[] lps = new int[pat.length];
        int len = 0;
        int i;

        lps[0] = 0;
        i = 1;

        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                i++;
                len++;
                lps[i] = len;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

    public static void KMP(char[] str, char[] pat) {
        int[] lps = failure(pat);
        int j = 0;
        int i = 0;

        while (i < str.length) {
            if (pat[j] == str[i]) {
                i++;
                j++;
                if (j == pat.length) {
                    System.out.println(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (pat[j] != str[i]) {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lps[j - 1];
                    }
                }
            }
        }
    }

}
