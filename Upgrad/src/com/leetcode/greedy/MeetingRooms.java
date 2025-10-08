package com.leetcode.greedy;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
/*
Example1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example2:
Input: [[7,10],[2,4]]
Output: true
 */
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

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
        System.out.println("input1 " + canAttendMeetings(intervals));
    }

    static void input2(){
        int[][] intervals = {
                {7, 10},
                {2, 4}
        };
        System.out.println("input2 " + canAttendMeetings(intervals));
    }

    //Time:  O(nlogn)
    //Space: O(1)
    public static boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        System.out.println("canAttendMeetings " + Arrays.deepToString(intervals));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]< o2[0])
                    return -1;
                else return 1;
            }
        });
        System.out.println("canAttendMeetings after sort: " + Arrays.deepToString(intervals));

        for(int i=0; i<n-1; i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }

        return true;
    }
}
