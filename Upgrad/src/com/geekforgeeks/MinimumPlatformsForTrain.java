package com.geekforgeeks;
//We are given two arrays that represent the arrival and departure times of trains, the task is to find the minimum number of platforms required so that no train waits.

/*
Examples:
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */
public class MinimumPlatformsForTrain {
    public static void main(String[] args) {
        int arr[] = { 100, 300, 500 };
        int dep[] = { 900, 400, 600 };
        int n = 3;
        System.out.println(findPlatform(arr, dep, n));

        input2();
    }

    static void input2(){
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        System.out.println("input2: " + findPlatform(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[], int n) {

        // plat_needed indicates number of platforms needed at a time
        int result = 1;

        // run a nested  loop to find overlap
        for (int i = 0; i < n; i++) {
            // minimum platform
            int plat_needed = 1;

            for (int j = 0; j < n; j++) {
                System.out.println("i " + i + " j " + j);
                if (i != j)
                    // check for overlap
                    if (arr[i] >= arr[j] && dep[j] >= arr[i])
                        plat_needed++;
            }
            // update result
            System.out.println("result " + result + " plat_needed " +plat_needed);
            result = Math.max(result, plat_needed);
        }
        return result;
    }

    static int countPlatforms(int n,int arr[],int dep[]){
        int ans=1; //final value
        for(int i=0;i<=n-1;i++) {
            int count=1; // count of overlapping interval of only this   iteration
            for(int j=i+1;j<=n-1;j++)  {
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
                        (arr[j]>=arr[i] && arr[j]<=dep[i]))  {
                    count++;
                }
            }
            ans=Math.max(ans,count); //updating the value
        }
        return ans;
    }

}
