package com.main.java.bsu.algorithms.search;

public class BinarySearch {
    public static int binarySearch(int arr[], int l, int r, int x, int depth) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if(arr[mid] == x) {
                return depth;
            }
            if (arr[mid] > x) {
                depth++;
                return binarySearch(arr, l, mid-1, x, depth);
            }
            depth++;
            return binarySearch(arr, mid+1, r, x, depth);
        }
        return depth;
    }
}
