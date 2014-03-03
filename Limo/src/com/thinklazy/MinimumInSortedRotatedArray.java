package com.thinklazy;

public class MinimumInSortedRotatedArray {
    int min(int x, int y) {
        return (x < y) ? x : y;
    }

    // The function that handles duplicates. It can be O(n) in worst case.
    int findMin(int arr[], int low, int high) {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low)
            return arr[0];

        // If there is only one element left
        if (high == low)
            return arr[low];

        // Find mid
        int mid = low + (high - low) / 2; /* (low + high)/2; */

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {1, 1, 0, 1}
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
        
        // This case causes O(n) time
        if (arr[low] == arr[mid] && arr[high] == arr[mid])
            return min(findMin(arr, low, mid - 1), findMin(arr, mid + 1, high));

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid - 1);
        return findMin(arr, mid + 1, high);
    }

    // Driver program to test above functions
    int main() {
        int arr1[] = {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr1, 0, n1 - 1)));

        int arr2[] = {1, 1, 0, 1};
        int n2 = arr2.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr2, 0, n2 - 1)));

        int arr3[] = {1, 1, 2, 2, 3};
        int n3 = arr3.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr3, 0, n3 - 1)));

        int arr4[] = {3, 3, 3, 4, 4, 4, 4, 5, 3, 3};
        int n4 = arr4.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr4, 0, n4 - 1)));

        int arr5[] = {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
        int n5 = arr5.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr5, 0, n5 - 1)));

        int arr6[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
        int n6 = arr6.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr6, 0, n6 - 1)));

        int arr7[] = {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        int n7 = arr7.length;
        System.out.println(String.format("The minimum element is %d\n", findMin(arr7, 0, n7 - 1)));

        return 0;
    }
}
