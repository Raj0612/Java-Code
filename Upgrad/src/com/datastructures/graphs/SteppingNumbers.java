package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1. For example, 321 is a Stepping Number while 421 is not.
//Given two integers low and high, return a sorted list of all the stepping numbers in the inclusive range[low, high]
/*
Input: low = 0, high = 21
Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]

Input: low = 10, high = 15
Output: [10, 12]

Constraints:
0 <= low <= high <= 2 * 10^9
 */
/*
                           1
                        /     \
                       /       \
                     10         12
                   /           /   \
                  /           /     \
               101          121      123
              /   \       /  \      /   \
             /     \   1210 1212   /     \
          1010    1012           1234    1232

                           2
                        /     \
                       /       \
                     21         23
                   /  \         /   \
                  /    \       /     \
               210     212   232    234
 */
public class SteppingNumbers {

    public static void main(String[] args) {
        input1();
        System.out.println();
        input2();
    }
    static void input1(){
        int low = 0;
        int high = 21;
        System.out.println("input1 countSteppingNumbersByUpgrad " + countSteppingNumbersByUpgrad(low, high));
    }

    static void input2(){
        int low = 10;
        int high = 15;
        System.out.println("input2 countSteppingNumbersByUpgrad " + countSteppingNumbersByUpgrad(low, high));
    }

    public static List<Integer> countSteppingNumbersByUpgrad(int low, int high) {
        List<Integer> steppingNumbers = new ArrayList<>();

        if(low > high)
            return steppingNumbers;
        if (low == 0) {
            steppingNumbers.add(0);
        }
        Deque<Long> queue = new ArrayDeque<>();
        for (long i = 1; i < 10; ++i) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            long currentNumber = queue.poll();
            if(currentNumber < high){
                long lastDigit = currentNumber % 10;
                if(lastDigit > 0 || lastDigit < 9) {
                    queue.add(currentNumber * 10 + lastDigit - 1);
                    queue.add(currentNumber * 10 + lastDigit + 1);
                }
            }
            if(currentNumber >= low && currentNumber <= high)
                steppingNumbers.add((int)currentNumber);
        }

        return steppingNumbers;
    }
    public static List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> steppingNumbers = new ArrayList<>();
        if (low == 0) {
            steppingNumbers.add(0);
        }
        Deque<Long> queue = new ArrayDeque<>();
        //Seed the queue with numbers 1 to 9 as they are the single-digit stepping numbers
        for (long i = 1; i < 10; ++i) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            long currentNumber = queue.pollFirst();
            if (currentNumber > high) {
                break;
            }
            // Add the current number to the result list if it's within the range
            if (currentNumber >= low) {
                steppingNumbers.add((int) currentNumber);
            }
            // Get the last digit of the current number
            int lastDigit = (int) currentNumber % 10;

            // If the last digit is not 0, append (lastDigit - 1)
            if (lastDigit > 0) {
                queue.offer(currentNumber * 10 + lastDigit - 1);
            }

            // If the last digit is not 9, append (lastDigit + 1)
            if (lastDigit < 9) {
                queue.offer(currentNumber * 10 + lastDigit + 1);
            }
        }
        return steppingNumbers;
    }

}
