package com.leetcode.zothers;

import java.util.Arrays;
import java.util.Comparator;
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
/*
Example1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example2:
Input: [[7,10],[2,4]]
Output: true
 */
public class MeetingRooms {

    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        Interval inter1 = new Interval(7, 10);
        Interval inter2 = new Interval(2, 4);

        Interval[] intervals = new Interval[2];
        intervals[0] = inter1;
        intervals[1] = inter2;
        int[][] arr = new int[][]{
                {7, 10},
                {2, 4},
        };

        System.out.println("input1 canAttendMeetings  " + canAttendMeetings(intervals));
        System.out.println("input1 canAttendMeetingsSortArray  " + canAttendMeetingsSortArray(arr));
    }

    static void input2(){
        Interval inter1 = new Interval(0, 30);
        Interval inter2 = new Interval(5, 10);
        Interval inter3 = new Interval(15, 20);

        Interval[] intervals = new Interval[3];
        intervals[0] = inter1;
        intervals[1] = inter2;
        intervals[2] = inter3;

        int[][] arr = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
                // {5, 10}
        };
        System.out.println("input2 canAttendMeetings  " + canAttendMeetings(intervals));
        System.out.println("input2 canAttendMeetingsSortArray  " + canAttendMeetingsSortArray(arr));
    }

    public static boolean canAttendMeetings(Interval[] intervals) {

        System.out.println("canAttendMeetings " + Arrays.toString(intervals));
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        System.out.println("canAttendMeetings after sort " + Arrays.toString(intervals));
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end>intervals[i+1].start){
                return false;
            }
        }
        return true;
    }

    public static boolean canAttendMeetingsSortArray(int[][] arr) {

        System.out.println("canAttendMeetingsSortArray: " + Arrays.deepToString(arr));
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        System.out.println("canAttendMeetingsSortArray After sort: " + Arrays.deepToString(arr));
        for(int i=0; i<arr.length-1; i++){
            if(arr[i][1]>arr[i+1][0]){
                return false;
            }
        }
        return true;
    }
}

 class Interval {
     int start;
      int end;
      Interval() {
          start = 0; end = 0;
      }
      Interval(int s, int e) {
          start = s; end = e;
      }

     @Override
     public String toString() {
         return "Interval{" +
                 "start=" + start +
                 ", end=" + end +
                 '}';
     }
 }
