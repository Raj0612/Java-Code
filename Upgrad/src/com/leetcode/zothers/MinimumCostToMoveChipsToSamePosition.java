package com.leetcode.zothers;
//We have n chips, where the position of the ith chip is position[i].
/*We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
        position[i] + 2 or position[i] - 2 with cost = 0.
        position[i] + 1 or position[i] - 1 with cost = 1.
 */
//Return the minimum cost needed to move all the chips to the same position.

/*
Example1:
Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.

Example2:
Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position 3 to position 2. Each move has cost = 1. The total cost = 2.

Example 3:
Input: position = [1,1000000000]
Output: 1
 */
public class MinimumCostToMoveChipsToSamePosition {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
        input4();
        input5();
    }

    public static int minCostToMoveChips(int[] positions){
        int oddCount = 0;
        int evenCount = 0;
        for (int position : positions) {
            if (position % 2 != 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        return Math.min(oddCount, evenCount);
    }

    static  void input1(){
        int arr[] ={1,2,3};
        System.out.println("input1 " + minCostToMoveChips(arr));
    }

    static  void input2(){
        int arr[] ={2,2,2,3,3};
        System.out.println("input2 " + minCostToMoveChips(arr));
    }

    static  void input3(){
        int arr[] ={1,2,3,4,5, 6};
        System.out.println("input3 " + minCostToMoveChips(arr));
    }

    static  void input4(){
        int arr[] ={2,4,6};
        System.out.println("input4 " + minCostToMoveChips(arr));
    }

    static  void input5(){
        int arr[] ={2 , 1000000000};
        System.out.println("input5 " + minCostToMoveChips(arr));
    }

}
