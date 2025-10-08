package com.leetcode.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        input1();
        //input2();
        //input3();
    }

    static void quickSortFromLeft(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int pivot = partitionFromLeft(arr, low, high);
        System.out.println("pivot " + pivot);
        System.out.println();
        quickSortFromLeft(arr, low, pivot);
        System.out.println("pivot1 " + pivot);
        quickSortFromLeft(arr, pivot + 1, high);
    }

    static int partitionFromLeft(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("partition pivot: " + pivot + " low: " + low + " high: " + high + " Array " + Arrays.toString(arr));
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            System.out.println("partition i: " + i + " j: " + j);
            if (i >= j) {
                System.out.println("partition i :" + i + " j : " + j + " Array " + Arrays.toString(arr));
                return j;
            }else{
                swap(arr, i, j);
            }
          //  System.out.println("partition after Swap " + Arrays.toString(arr));
        }
    }


    static void quickSortFromRight(int arr[], int start, int end){
        if (start < end) {
            int pivot = partitionFromRight(arr, start, end);
            quickSortFromRight(arr, start, pivot - 1);
            quickSortFromRight(arr, pivot + 1, end);
        }
    }

    static int partitionFromRight(int arr[], int start, int end) {
        int pivot = arr[end];
       // int i = (start - 1);
        int i = start;

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
              //  i++; // increment index of smaller element
                swap(arr, i, j);
                i++; // increment index of smaller element
            }
        }
       // swap(arr, i+1, end);
     //   return (i + 1);
        swap(arr, i, end);
        return (i );
    }

    static void quickSortFromMiddle(int[] num, int i, int j){

        if(i>=j)
            return;
        int pivot_index = partitionFromMiddle(num, i, j);
        //if(i < pivot_index-1) {
            quickSortFromMiddle(num, i, pivot_index-1);
        //}
        //if(pivot_index < j) {
            quickSortFromMiddle(num, pivot_index, j);
        //}
    }

    static int partitionFromMiddle(int[] num, int i, int j){
        int pivot = num[(i+j)/2];
        System.out.println("partitionFromMiddle Array " + Arrays.toString(num) + " pivot " + pivot + " i: " + i + " j: " +j);
        while(i <= j){
            while(num[i] < pivot) {
                i++;
            }
            while(pivot < num[j])  {
                j--;
            }
            System.out.println("partitionFromMiddle i: " + i + " j: " + j );
            if(i <= j)  {
                swap(num, i, j);
                i++;
                j--;
            }
        }
        System.out.println("partitionFromMiddle Array " + Arrays.toString(num) + " pivot " + num[i] + " i: " + i);
        System.out.println();
        return i;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void input1() {
        int arr[] = {9, -3, 5, 2, 6, 8, -6, 1, 3};
        //int arr[] = { 13, 18, 27, 2, 19, 25 };
        System.out.println("input1 " +Arrays.toString(arr));
        //quickSortFromLeft(arr, 0, arr.length - 1);
        quickSortFromRight(arr, 0, arr.length - 1);
        System.out.println("input1 Result " +Arrays.toString(arr));
    }

    static void input2() {
        //int arr[] = {9, -3, 5, 2, 6, 8, -6, 1, 3};
        int arr[] = { 13, 18, 27, 2, 19, 25 };
        System.out.println("input2 " +Arrays.toString(arr));
        quickSortFromRight(arr, 0, arr.length - 1);
        System.out.println("input2 Result " +Arrays.toString(arr));
    }

    static void input3() {
        //int arr[] = {9, -3, 5, 2, 6, 8, -6, 1, 3};
      // int arr[] = { 13, 18, 27, 2, 19, 25 };
        int arr[] = { 4, 2, 6, 5, 3, 9 };
       // int[] arr = {27, 23, 11, 7, 9, 17, 6};
        System.out.println("input3 " +Arrays.toString(arr));
        quickSortFromMiddle(arr, 0, arr.length - 1);
        System.out.println("input3 Result " +Arrays.toString(arr));
    }
}
