package com.datastructures.graphs;

import java.util.*;
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where
// prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1. Return true if you can finish all courses. Otherwise, return false.
/*
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

enum State { kInit, kVisiting, kVisited }

public class CourseSchedule {
    public static void main(String[] args) {
      //  input1();
       // System.out.println();
        input2();
       // System.out.println();
       //input3();
    }
    static void input1(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},
                {3,0},{2,1},{3,2}, {3,1}};
        System.out.println("input1 canFinishByUpgrad " + canFinishByUpgrad(numCourses, prerequisites));
      //  System.out.println("input1 canFinish " + canFinish(numCourses, prerequisites));
       // System.out.println("input1 canFinishByBFS " + canFinishByBFS(numCourses, prerequisites));
      //  System.out.println("input1 canFinishByDFS " + canFinishByDFS(numCourses, prerequisites));
    }

    static void input2(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},
                {3,0},{2,1},{3,2}};
        System.out.println("input2 " + Arrays.deepToString(prerequisites));
        System.out.println("input2 canFinishByUpgrad " + canFinishByUpgrad(numCourses, prerequisites));
      //  System.out.println("input2 canFinish " + canFinish(numCourses, prerequisites));
      //  System.out.println("input2 canFinishByBFS " + canFinishByBFS(numCourses, prerequisites));
       // System.out.println("input2 canFinishByDFS " + canFinishByDFS(numCourses, prerequisites));
    }

    static void input3(){
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0}, {3,1}, {3,2},{2,3}};
        System.out.println("input3 " + Arrays.deepToString(prerequisites));
        System.out.println("input3 canFinishByUpgrad " + canFinishByUpgrad(numCourses, prerequisites));
        //System.out.println("input3 canFinish " + canFinish(numCourses, prerequisites));
       // System.out.println("input3 canFinishByBFS " + canFinishByBFS(numCourses, prerequisites));
       // System.out.println("input3 canFinishByDFS " + canFinishByDFS(numCourses, prerequisites));
    }

    public static boolean canFinishByUpgrad(int numCourses, int[][] prerequisites) {

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
                        return false;
                }
            }
        return true;
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
            return false;
    }
    //Method1
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        State[] states = new State[numCourses];

        for (int i = 0; i < numCourses; ++i)
            graph[i] = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            final int u = prerequisite[1];
            final int v = prerequisite[0];
            graph[u].add(v);
        }

        for (int i = 0; i < numCourses; ++i)
            if (hasCycle(graph, i, states))
                return false;

        return true;
    }

    private static boolean hasCycle(List<Integer>[] graph, int u, State[] states) {
        if (states[u] == State.kVisiting)
            return true;
        if (states[u] == State.kVisited)
            return false;

        states[u] = State.kVisiting;
        for (final int v : graph[u]){
            if (hasCycle(graph, v, states))
                return true;
        }
        states[u] = State.kVisited;
        return false;
    }

    //Method2
    public static boolean canFinishByBFS(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }
       // System.out.println("canFinishByBFS pCounter " + Arrays.toString(pCounter));
        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }

    //Method3
    public static boolean canFinishByDFS(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }
        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, visit, i))
                return false;
        }

        return true;
    }
    private static boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
        if(visit[i]==-1)
            return false;
        if(visit[i]==1)
            return true;

        visit[i]=-1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(!canFinishDFS(map, visit, j))
                    return false;
            }
        }

        visit[i]=1;

        return true;
    }
}
