package com.datastructures.graphs;

import java.util.*;
//There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
// The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
// Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

//You want to determine if there is a valid path that exists from vertex source to vertex destination.
//Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

/*
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 */
public class FindPathExists {

    static public  HashMap<Integer, ArrayList<Integer>> graph;
    static boolean ans = false;

    public static void main(String[] args) {
       //input1();
      input2();
    }

    static void input1(){
        int[][] edges = {{0,1} ,{1, 2},{2,0}};
        System.out.println("input1 validPathUsingStack " + validPathUsingStack(3, edges, 0, 1));
        System.out.println("input1 validPathUsingQueue " + validPathUsingQueue(3, edges, 0, 2));
        System.out.println("input1 validPathByUpgrad " + validPathByUpgrad(3, edges, 0, 2));
    }

    static void input2(){
        int[][] edges = {{0,1} ,{0,2},{3,5},{5,4},{4,3}};
        System.out.println("input2 validPathUsingStack " + validPathUsingStack(5, edges, 0, 5));
        System.out.println("input2 validPathUsingQueue " + validPathUsingQueue(6, edges, 0, 5));
        System.out.println("input2 validPathByUpgrad " + validPathByUpgrad(6, edges, 0, 5));
    }

    public static boolean validPathUsingStack(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al;

        for (int i = 0; i < edges.length; i++) {
            if (adjList.containsKey(edges[i][0]))
                al = adjList.get(edges[i][0]);
            else
                al = new ArrayList<Integer>();
            al.add(edges[i][1]);
            adjList.put(edges[i][0], al);

            if (adjList.containsKey(edges[i][1]))
                al = adjList.get(edges[i][1]);
            else
                al = new ArrayList<Integer>();
            al.add(edges[i][0]);
            adjList.put(edges[i][1], al);
        }

        System.out.println("validPathUsingStack adjList " + adjList);
        stack.push(source);

        // DFS
        while (!stack.empty()) {
            int node = stack.pop();
             System.out.println("Node " + node + " visited " + visited);
            if (visited.contains(node) || !adjList.containsKey(node))
                continue;
            if (node == destination)
                return true;
            visited.add(node);
            for (Integer each : adjList.get(node)) {
                stack.push(each);
            }
            System.out.println("stack " + stack);
        }
        return false;

    }

    public static boolean validPathUsingQueue(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            adjList.computeIfAbsent(edges[i][0], t -> new ArrayList<>()).add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], t -> new ArrayList<>()).add(edges[i][0]);
        }
        System.out.println("validPathUsingQueue adjList " + adjList);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (front == destination) {
                return true;
            }

            List<Integer> neighbors = adjList.get(front);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean validPathByUpgrad(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();

        for(int i=0; i< n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println("validPathByUpgrad graph " + graph);
        int visit[] = new int[n];
        dfs(source, destination, visit);
        return ans;
    }

    public static void dfs(int s, int d, int visit[]){
        visit[s] = 1;

        if(s==d){
            ans = true;
            return;
        }

        ArrayList<Integer> neighbours = graph.get(s);
        for(int i=0; i< neighbours.size(); i++){
            int y = neighbours.get(i);
            if(visit[y]==0){
                dfs(y, d, visit);
            }
        }
    }
}
