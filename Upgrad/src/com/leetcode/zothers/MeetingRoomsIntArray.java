package com.leetcode.zothers;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsIntArray {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 30},
               // {5, 10},
                {15, 20},
               {5, 10}
        };

        System.out.println("canAttendMeetings " + canAttendMeetings(arr));

    }
    public static boolean canAttendMeetings(int[][] intervals){
        System.out.println("canAttendMeetings " + Arrays.deepToString(intervals));
        int n = intervals.length;
        columnWiseSorting(intervals, 1);

        System.out.println("canAttendMeetings After sort " + Arrays.deepToString(intervals));
        for(int i =0; i<n-1; i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;
    }

    static void columnWiseSorting(int arr[][], int colmn) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] frst, int[] scnd) {
                if(frst[colmn-1] > scnd[colmn-1]) {
                    return 1;
                }
                else return -1;
            }
        });
    }
}
