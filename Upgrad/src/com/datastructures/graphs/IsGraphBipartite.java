package com.datastructures.graphs;

import java.util.Arrays;
//There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph,
// where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v.
// The graph has the following properties:
/*
* There are no self-edges (graph[u] does not contain u).
* There are no parallel edges (graph[u] does not contain duplicate values).
* If v is in graph[u], then u is in graph[v] (the graph is undirected).
* The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 */
//A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
//Return true if and only if it is bipartite.
/*
Example1:
        0------1
        | \    |
        |   \  |
        3------2
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Example2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

Constraints:
graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
 */
public class IsGraphBipartite {
    public static void main(String[] args) {
      //  input1();
        System.out.println();
       input2();
    }

    static void input1(){
        int[][] graph = {{1,2,3},
                {0,2},
                {0,1,3},
                {0,2}};
        System.out.println("input1 isBipartiteByUpgrad " + isBipartiteByUpgrad(graph) );
    }

    static void input2(){
        int[][] graph = {{1,3},
                {0,2},
                {1,3},
                {0,2}};
        System.out.println("input2 isBipartiteByUpgrad " + isBipartiteByUpgrad(graph) );
    }

    public static boolean isBipartiteByUpgrad(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i=0; i<n; i++){
            if(colors[i] ==-1 && !validColor(graph, colors, 0, i)){
                return false;
            }
        }
        return true;
    }

    public static boolean validColor(int[][] graph, int[] colors, int color, int node){
        colors[node] = color;

        for(int next: graph[node]){
            if(colors[next] != -1){
                if(colors[next] == color ){
                    return false;
                }
            }else{
                if(!validColor(graph, colors, 1-color, next )){
                    return false;
                }
            }
        }
        return true;
    }
}
