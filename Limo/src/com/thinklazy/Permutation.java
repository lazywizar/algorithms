package com.thinklazy;

/**
 * abc -> bc -> c
 * back tracking ..:)
 * @author varunkumar
 */

public class Permutation {
    public static void main(String args[]) {
        perm("abc".toCharArray(), 0);
    }

    public static void perm(char[] a, int k) {
        if (k == a.length) {
            System.out.println(a);
            return;
        }
        //Note i=k not 0;
        for (int i = k; i < a.length; i++) {
            swap(a, i, k);
            perm(a, k + 1);
            swap(a, i, k);
        }
        System.out.print("");
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
