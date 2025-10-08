package com.greedy;

//We are given two arrays that represent the arrival and departure times of trains, the task is to find the minimum number of platforms required so that no train waits.

import java.util.Arrays;
import java.util.Comparator;

/*
Examples:
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */
public class MinimumPlatformsForTrain {
    public static void main(String[] args) {
        int arr[] = { 100, 300, 500 };
        int dep[] = { 900, 400, 600 };
        int n = 3;
        System.out.println("findPlatform " + findPlatform(arr, dep, n));
        System.out.println("findPlatform1 " + findPlatform1(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[], int n) {

        // plat_needed indicates number of platforms needed at a time
        int result = 1;

        // run a nested  loop to find overlap
        for (int i = 0; i < n; i++) {
            // minimum platform
            int plat_needed = 1;

            for (int j = 0; j < n; j++) {
                if (i != j)
                    // check for overlap
                    if (arr[i] >= arr[j] && dep[j] >= arr[i])
                        plat_needed++;
            }

            // update result
            System.out.println("result " + result + " plat_needed " +plat_needed);
            result = Math.max(result, plat_needed);
        }
        return result;
    }

    public static int findPlatform1(int arr[], int dep[], int n) {

        int array[][] = convertTo2DArray(arr, dep);
        System.out.println("findPlatform1 " + Arrays.deepToString(array));
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]< o2[0])
                    return -1;
                else return 1;
            }
        });
        System.out.println("findPlatform1 " + Arrays.deepToString(array));
        int platform = 1;
        for(int i=0; i<n-1; i++){
            if(array[i][1] > array[i+1][0]){
                platform++;
            }
        }
        return platform;
    }

    public static int[][] convertTo2DArray(int[] arr, int[] dep) {
        if (arr.length != dep.length) {
            throw new IllegalArgumentException("Both arrays must have the same length");
        }

        int n = arr.length;
        int[][] result = new int[n][2];

        for (int i = 0; i < n; i++) {
            result[i][0] = arr[i];
            result[i][1] = dep[i];
        }
        return result;
    }
}
