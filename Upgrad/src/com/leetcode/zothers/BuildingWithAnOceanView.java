package com.leetcode.zothers;

import java.util.*;

public class BuildingWithAnOceanView {

    public static void main(String[] args) {

       // int heights[] = {4,3,2,1};
        //int heights[] = {1,3,2,4};
       int heights[] = {2,2,2,2};
        System.out.println("findBuildingsByDeque " + Arrays.toString(findBuildingsByDeque(heights)));
        System.out.println("findBuildingsNotOptimized " + Arrays.toString(findBuildingsNotOptimized(heights)));
    }

    //Time-O(n) Space-O(n)
    public static int[] findBuildingsByDeque(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i])
                stack.pop();
            stack.push(i);
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; ++i)
            ans[ans.length - 1 - i] = stack.pop();
        return ans;
    }

    //Time-O(n) Space-O(n)
    public static int[] findBuildingsByDeque1(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
        }

        int n = stack.size();
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[--n] = stack.pollLast();
        }
        return ans;
    }

    //Time-O(n*n)
    public static int[] findBuildingsNotOptimized(int[] heights) {
        int n = heights.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n; i++){
            boolean is_visible = true;
            for(int j=i+1; j<n; j++){
                if(heights[j]>=heights[i]) {
                    is_visible = false;
                    break;
                }
            }
            if(is_visible)
                list.add(i);
        }

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    public static int[] findBuildings(int[] heights) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                list.add(i);
                max = heights[i];
            }
        }
        int[] res = new int[list.size()];
        Collections.reverse(list);
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] findBuildings1(int[] heights) {
        int length = heights.length;
        boolean[] oceanView = new boolean[length];
        int count = 0;
        int maxHeight = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                oceanView[i] = true;
                count++;
            }
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        int[] buildings = new int[count];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (oceanView[i])
                buildings[index++] = i;
        }
        return buildings;
    }


}
