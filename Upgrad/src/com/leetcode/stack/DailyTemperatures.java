package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;
//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days
// you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

/*
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        input1();
      //  input2();
       // input3();
        //input4();
    }
    static void input1(){
        int[] temperatures = {5,10,12,9,20,15};
        System.out.println("input1: " + Arrays.toString(temperatures));
        System.out.println("input1 dailyTemperatures " + Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println("input1 dailyTemperaturesUpgrad " + Arrays.toString(dailyTemperaturesUpgrad(temperatures)));
        System.out.println("input1 dailyTemperaturesNotOptimized " + Arrays.toString(dailyTemperaturesNotOptimized(temperatures)));
    }

    static void input2(){
        int[] temperatures = {73,74,75,69,71,72,76,73};
        System.out.println("input2: " + Arrays.toString(temperatures));
        System.out.println("input2 dailyTemperatures " + Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println("input2 dailyTemperaturesUpgrad " + Arrays.toString(dailyTemperaturesUpgrad(temperatures)));
        System.out.println("input2 dailyTemperaturesNotOptimized " + Arrays.toString(dailyTemperaturesNotOptimized(temperatures)));
    }
    static void input3(){
        int[] temperatures =  {55,38,53,81,61,93,97,32,43,78};
        System.out.println("input3: " + Arrays.toString(temperatures));
        System.out.println("input3 dailyTemperatures " + Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println("input3 dailyTemperaturesUpgrad " + Arrays.toString(dailyTemperaturesUpgrad(temperatures)));
        System.out.println("input3 dailyTemperaturesNotOptimized " + Arrays.toString(dailyTemperaturesNotOptimized(temperatures)));
    }
    static void input4(){
        int[] temperatures =  {97,32,43,78};
        System.out.println("input4: " + Arrays.toString(temperatures));
        System.out.println("input4 dailyTemperatures " + Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println("input4 dailyTemperaturesUpgrad " + Arrays.toString(dailyTemperaturesUpgrad(temperatures)));
        System.out.println("input4 dailyTemperaturesNotOptimized " + Arrays.toString(dailyTemperaturesNotOptimized(temperatures)));
    }


   //Time-O(2n)==>O(n) Space-O(1)
    public static int[] dailyTemperatures(int[] temperatures){
        System.out.println("dailyTemperatures  " + Arrays.toString(temperatures));
        Stack<Integer> stack= new Stack();
        int n=temperatures.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++) {
            System.out.println("i: " +  i + " temperatures[i] " + temperatures[i]);
            while(stack.size()>0 && temperatures[i]>temperatures[stack.peek()]){
               /* int prev_day = stack.pop();
                ans[prev_day]=i-prev_day;*/

                ans[stack.peek()]=i-stack.pop();
                System.out.println("dailyTemperatures ans " + Arrays.toString(ans));
            }
            stack.push(i);
            System.out.println("dailyTemperatures stack " + stack);
        }
        return ans;
    }

    //Time-O(2n)==>O(n) Space-O(1)
    public static int[] dailyTemperaturesUpgrad(int[] temperatures){
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n ; i++){
                while(!stack.isEmpty() &&  temperatures[i] > temperatures[stack.peek()] ){
                    int j = stack.pop();
                    result[j] = i-j;
                }
                stack.push(i);
        }
        return result;
    }

    //Time-O(N*N)  Space-O(1)
    public static int[] dailyTemperaturesNotOptimized(int[] temperatures){

        int n = temperatures.length;
        int result[] = new int[n];
        for(int i=0; i<n; i++){
            result [i] =0;
            for(int j=i+1; j<n; j++){
                if(temperatures[j]>temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

}
