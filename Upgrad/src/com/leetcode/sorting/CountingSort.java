package com.leetcode.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        //input1();
        input2();
    }

    //Time - O(n) + O(max)
    static void count_sort(int[] arr){
        System.out.println("count_sort " + Arrays.toString(arr));
        int max = find_max(arr);

        int count[] = new int[max+1];

        //Arrays.fill(count, 0);
        //System.out.println("count_sort count: " + Arrays.toString(count));
        for(int i=0; i<arr.length; i++){
            count[arr[i]] ++;
        }
       // System.out.println("count_sort count1: " + Arrays.toString(count));
        int i=0;
        for(int j=0; j<count.length; j++){
            int freq = count[j];
            int c=0;
            while (c<freq){
                arr[i] =j;
                c++;
                i++;
            }
        }
    }

    static int find_max(int[] arr){
        int max =0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    static void input1(){
        int[] arr = {4, 2, 1, 1, 4, 0, 3, 2, 4, 3,2,0 ,0,1, 1};
        count_sort(arr);
        System.out.println("Araay " + Arrays.toString(arr));
    }

    static void input2(){
        int[] arr = {4, 2, 1, 1, 4, 0, 2, 4,2,0 ,0,1, 1};
        count_sort(arr);
        System.out.println("input2 " + Arrays.toString(arr));
    }

}
