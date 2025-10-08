package com.leetcode.binarysearch;
//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
// Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
// You should minimize the number of calls to the API.

/*Example 1:
        Input: n = 5, bad = 4
        Output: 4
        Explanation:
        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true
        Then 4 is the first bad version.

Example 2:
        Input: n = 1, bad = 1
        Output: 1*/
public class FirstBadVersion {

    static int  bad = 2;

    //static int  bad = 4;
    public static void main(String[] args) {
        //int n = 10;
        int n = 5;
        int result = firstBadVersion(n);
        System.out.println("result " + result);
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // first bad version is at mid or before
            } else {
                left = mid + 1; // first bad version must be after mid
            }
        }
        return left; // or right (both point to the first bad version)
    }


    static boolean isBadVersion(int n){
        return (n>=bad);

    }
}

