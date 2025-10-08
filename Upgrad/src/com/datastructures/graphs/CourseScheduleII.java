package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// *) For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
// If it is impossible to finish all courses, return an empty array.
/*
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 */
public class CourseScheduleII {

    public static List<Integer> list = null;
    public static int[] result = null;
    public static void main(String[] args) {
       // input1();
        System.out.println();
        input2();
        System.out.println();
      //  input3();
        System.out.println();
       // input4();
    }

    static void input1(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},
                {3,0},{2,1},{3,2}, {3,1}};
        System.out.println("input1 findOrder " + Arrays.toString(findOrder(numCourses, prerequisites)));
    }
    static void input2(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},
                {2,0},
                {3,1},
                {3,2}};
        System.out.println("input2 " + Arrays.deepToString(prerequisites));
        System.out.println("input2 findOrder " + Arrays.toString(findOrder(numCourses, prerequisites)));
    }
    static void input3(){
        int numCourses = 1;
        int[][] prerequisites = {};
        System.out.println("input3 findOrder " + Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    static void input4(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0}, {3,1}, {3,2},{2,3}};
        System.out.println("input4 " + Arrays.deepToString(prerequisites));
        System.out.println("input4 findOrder " + Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    static int[] findOrder(int numCourses, int[][] prerequisites){
        result = null;
        list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i= 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        System.out.println("canFinishByUpgrad adj " + adj);
        int[] visited = new int[numCourses];
        for(int i =0; i< numCourses; i++){
            if(visited[i] == 0){
                boolean cycle = dfs(i, adj, visited); // Will check for cycle
                if(cycle)
                    return  new int[0];
            }
        }
        System.out.println("findOrder list " + list);
        Collections.reverse(list);
        System.out.println("findOrder list after reverse " + list);
        result = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static boolean dfs(int node, List<List<Integer>> adj, int[] visited){
        visited[node] = 1;

        for(int neighbour: adj.get(node)){
            if(visited[neighbour] == 0){
                if(dfs(neighbour, adj, visited)){
                    return true;
                }
            }else {
                if (visited[neighbour] == 1) {
                    return true;
                }
            }
        }

        visited[node] = 2; //black
        list.add(node);
        return false;
    }
}
