package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
public class MeetingRoomsII {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        System.out.println("input1 " + minMeetingRooms(intervals));
        System.out.println("input1 minMeetingRoomsUpgrad " + minMeetingRoomsUpgrad(intervals));
    }

    static void input2(){
        int[][] intervals = {
                {7, 10},
                {2, 4}
        };
        System.out.println("input2 " + minMeetingRooms(intervals));
        System.out.println("input2 minMeetingRoomsUpgrad " + minMeetingRoomsUpgrad(intervals));
    }

    static int minMeetingRooms(int[][] intervals){
        int n = intervals.length;
        System.out.println("minMeetingRooms " + Arrays.deepToString(intervals) + " Length " + n);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]< o2[0])
                    return -1;
                else return 1;
            }
        });

        System.out.println("minMeetingRooms after sort: " + Arrays.deepToString(intervals));

        int room = 1;
        for(int i=0; i<n-1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                room++;
            }
        }
        return room;
    }

    //Time : O(n * 1000000)
    //Space : O(1000000)
    static int minMeetingRoomsUpgrad(int[][] intervals){

        int n = intervals.length;
        int arr[] = new int[1000001];

        for(int i=0; i< n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            for(int j =start; j< end;j++){
                arr[j]++;
            }
        }

        int ans = 0;
        for(int i=0; i< 1000001; i++){
            ans = Math.max(ans, arr[i]);
        }

        return ans;
    }
}
