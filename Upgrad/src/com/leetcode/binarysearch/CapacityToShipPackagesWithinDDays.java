package com.leetcode.binarysearch;

//A conveyor belt has packages that must be shipped from one port to another within D days.
///The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
//Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

/*Example 1:
        Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
        Output: 15
        Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        1st day: 1, 2, 3, 4, 5
        2nd day: 6, 7
        3rd day: 8
        4th day: 9
        5th day: 10
        Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts
        like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:
        Input: weights = [3,2,2,4,1,4], days = 3
        Output: 6
        Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
        1st day: 3, 2
        2nd day: 2, 4
        3rd day: 1, 4*/

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        //input1();
         input2();
    }

    public static int shipWithinDays(int[] weights, int days) {
        //int left = Arrays.stream(weights).max().getAsInt();
        int left = 1;
        int right = Arrays.stream(weights).sum();
        System.out.println("shipWithinDays left " + left + " right " + right + " mid " + (left + right) / 2 + " days " + days);
        while (left < right) {
            final int mid = (left + right) / 2;
            if (shipDays(weights, mid) <= days)
                right = mid;
            else
                left = mid + 1;
            System.out.println("shipWithinDays last left " + left + " right " + right + " mid " + (left + right) / 2);
        }

        return left;
    }

    private static int shipDays(int[] weights, int shipCapacity) {
        System.out.println("shipDays " + Arrays.toString(weights) + " shipCapacity " + shipCapacity);
        int days = 1;
        int capacity = 0;
        for (final int weight : weights) {
            capacity = capacity + weight;
            if (capacity > shipCapacity) {
                ++days;

               // System.out.println(" weight " + weight + " capacity " + capacity + " days " + days);
                capacity = weight;
            }
        }
        System.out.println("shipDays days " + days + " shipCapacity " +shipCapacity);
        return days;
    }

    public static int shipWithinDays1(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        System.out.println("shipWithinDays1 left " + left + " right " + right + " mid " + (left + right) / 2);
        while (left < right) {
            int mid = (left + right) / 2, requirement = 1, tillnow = 0;
            for (int w : weights) {
                if (tillnow + w > mid) {
                    requirement += 1;
                    tillnow = 0;
                }
                tillnow += w;
            }
            if (requirement > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("shipWithinDays1 last left " + left + " right " + right + " mid " + mid);
        }
        return left;
    }

    static int shipWithinDaysNonOptimized(int[] weights, int days) {
        int max_cap = find_sum(weights);
        System.out.println("shipWithinDaysNonOptimized max_cap " + max_cap);
        for (int cap = 1; cap <= max_cap; cap++) {
            if (is_possible(weights, days, cap)) {
                return cap;
            }
        }
        return max_cap;
    }

    static boolean is_possible(int[] weights, int days, int cap) {
        int days_needed = 1;
        int capacity = 0;

        for (int i = 0; i < weights.length; i++) {
            capacity = capacity + weights[i];
            if(capacity> cap){
                days_needed++;
                capacity = weights[i];
            }
        }

        if (days_needed > days)
            return false;
        return true;
    }

    static int find_sum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum = sum + weight;
        }
        return sum;
    }

    static void input1() {
        int weights[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        //  System.out.println("input1 " + Arrays.toString(weights));
        //  System.out.println("input1 " + shipWithinDays(weights, days));
        //System.out.println("input1 " + shipWithinDaysNonOptimized(weights, days));
    }

    static void input2() {
        int weights[] = {3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println();
        System.out.println("input2 " + Arrays.toString(weights));
        System.out.println("input2 " + shipWithinDays(weights, days));
      //  System.out.println("input2 " + shipWithinDaysNonOptimized(weights, days));
    }
}
