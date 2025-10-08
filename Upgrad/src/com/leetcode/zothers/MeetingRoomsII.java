package com.leetcode.zothers;

import java.util.Arrays;
////Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 },  {15, 20 },{ 5, 10 } };
        System.out.println(solve(intervals));
    }

    public static int solve(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        System.out.println("solve before sorting " + Arrays.toString(start));
        System.out.println("solve before sorting " + Arrays.toString(end));
        Arrays.sort(start);
        Arrays.sort(end);
        System.out.println("solve after sorting " + Arrays.toString(start));
        System.out.println("solve after sorting " + Arrays.toString(end));
        int i = 1, j = 0, curr = 1;
        int answer = 1;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            answer = Integer.max(answer, curr);
        }
        return answer;
    }
}
