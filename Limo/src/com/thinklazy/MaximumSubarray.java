package com.thinklazy;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int a[] = {6, -35, 4, -10, -2, 1, 5, -3, 12};
        int max_sum = maxSubArraySum(a);
        System.out.println("Maximum contiguous sum is " + max_sum);

        SubArray sub = getMaxSubArraySum(a);
        System.out.println(sub.sum);
        for (int i = sub.left; i <= sub.right; i++) {
            System.out.print(a[i] + " ");
        }
        // System.out.println("Maximum contiguous sum is " + kadane(a));

        int M[][] = { {1, 2, -1, -4, -20}, 
                      {-8, -3, 4, 2, 1}, 
                      {3, 8, 10, 1, 3}, 
                      {-4, -1, 1, 7, -6}};

        findMaxSum(M);
    }

    /**
     * Perfect even for all negative
     * 
     * @param a
     * @return
     */
    public static int maxSubArraySum(int a[]) {
        int maxSoFar = a[0];
        int currentMax = a[0];

        for (int i = 1; i < a.length; i++) {
            currentMax = Math.max(a[i], currentMax + a[i]); // Note not max(
                                                            // currMax,
                                                            // currMax+a[i]
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static SubArray getMaxSubArraySum(int a[]) {
        int maxSoFar = a[0];
        int currentMax = a[0];
        int left = 0;
        int right = 0;
        int currentLeft = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > currentMax + a[i]) {
                currentMax = a[i];
                currentLeft = i;
            } else {
                currentMax = currentMax + a[i];
            }

            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
                right = i;
                left = currentLeft;
            }

        }

        return new SubArray(maxSoFar, left, right);
    }

    public static class SubArray {
        public SubArray(int sum, int left, int right) {
            super();
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        int sum;
        int left;
        int right;
    }

    /**
     * Does not take care of all negative
     * 
     * @param a
     * @return
     */
    public static int kadane(int[] a) {
        int maxSoFar = 0;
        int currMax = 0;
        for (int i = 0; i < a.length; i++) {
            currMax = currMax + a[i];
            if (currMax < 0) {
                currMax = 0;
            } else {
                maxSoFar = Math.max(maxSoFar, currMax);
            }
        }
        return maxSoFar;
    }

    public static void findMaxSum(int M[][]) {
        // Variables to store the final output
        int maxSum = Integer.MIN_VALUE, finalLeft = 0, finalRight = 0, finalTop = 0, finalBottom =
                0;
        int row = M.length;
        int col = M[0].length;
        int tempRowSum[] = new int[row];

        // Set the left column
        for (int left = 0; left < col; ++left) {
            // Initialize all elements of temp as 0
            Arrays.fill(tempRowSum, 0);

            // Set the right column for the left column set by outer loop
            for (int right = left; right < col; ++right) {
                // Calculate sum between current left and right for every row
                for (int i = 0; i < row; ++i)
                    tempRowSum[i] += M[i][right];

                // Find the maximum sum subarray in temp[]. The kadane() function
                // also sets values of start and finish. So 'sum' is sum of
                // rectangle between (start, left) and (finish, right) which is
                // the
                // maximum sum with boundary columns strictly as left and right.
                SubArray sub = getMaxSubArraySum(tempRowSum);

                // Compare sum with maximum sum so far. If sum is more, then
                // update
                // maxSum and other output values
                if (sub.sum > maxSum) {
                    maxSum = sub.sum;
                    finalLeft = left;
                    finalRight = right;
                    finalTop = sub.left;
                    finalBottom = sub.right;
                }
            }
        }

        // Print final values
        System.out.println(String.format("\n(Top, Left) (%d, %d)", finalTop, finalLeft));
        System.out.println(String.format("(Bottom, Right) + (%d, %d)", finalBottom, finalRight));
        System.out.println("Max sum is: " + maxSum);
    }

}

/**
 * currentMax = 8 maxSoFar = 8
 **/
