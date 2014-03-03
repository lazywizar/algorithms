package com.thinklazy;

public class KMPAlgo {

    public static void main(String args[]) {
        String txt = "abaxgabcab";
        String pat = "ab";
        KMPSearch(pat, txt);
    }

    public static void KMPSearch(String pat, String txt) {
        int[] lps = computeLPSArray(pat);
        int j = 0; // index for pat[]
        int i = 0; // index for txt[]

        while (i < txt.length()) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
                if (j == pat.length()) {
                    System.out.println(i - j);// Khatarnak!! lots of thinking .. i-j
                    j = lps[j - 1]; // Need to decrement j now... because we shift 1 character
                }
            } else {
                if (j == 0) {
                    // note when we do j = lps[j-1] we dont increment i..
                    // because i needs to remain to the same matched position.
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
    }

    public static int[] computeLPSArray(String pat) {
        int len = 0; // length of the previous longest prefix suffix
        int i;
        int[] lps = new int[pat.length()];
        lps[0] = 0; // lps[0] is always 0
        i = 1;

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1]; // Also, note that we do not increment i here
                }
            }
        }
        return lps;
    }
}
