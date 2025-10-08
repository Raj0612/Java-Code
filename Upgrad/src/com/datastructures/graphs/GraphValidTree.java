package com.datastructures.graphs;
//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output:
true

Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output:
false
*/
public class GraphValidTree {
    private static int[] parent;

    public static int vis[] = null;
    static public  HashMap<Integer, ArrayList<Integer>> graph;
    public static void main(String[] args) {
       // input1();
        input2();
    }

    static void input1(){

        int n = 5;
        int edges[][] = {{0, 1},
                         {0, 2},
                         {0, 3},
                         {1, 4}};
        /*
                        0
                     /  |  \
                    1   2   3
                   /
                  4
         */

        //System.out.println("input1: validTree " + validTree(n , edges));
        System.out.println("input2: validTreeByUpgrad " + validTreeByUpgrad(n , edges));
    }

    static void input2(){

        int n = 5;
        int edges[][] = {{0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}};
        /*
                       0
                     /
                    1 -- 4
                   /  \
                  2 -- 3

         */
        //System.out.println("input2: validTree " + validTree(n , edges));
        System.out.println("input2: validTreeByUpgrad " + validTreeByUpgrad(n , edges));
    }

    public static boolean validTreeByUpgrad(int n, int[][] edges) {
       graph = new HashMap<>();
        vis = new int[n];
        for(int i=0; i< n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println("validTreeByUpgrad graph "   + graph);
        dfs(0); // To check any graph is not connected
        System.out.println("validTreeByUpgrad after dfs vis " + Arrays.toString(vis));
        for(int i =0; i< n; i++){
            if(vis[i]==0){
                return false;
            }
        }
        Arrays.fill(vis , 0);
        System.out.println("validTreeByUpgrad vis " + Arrays.toString(vis));
        boolean has_cycle = dfs_cycle(0, -1);

        return !has_cycle;
    }

    static boolean dfs_cycle(int source, int parent){
        vis[source] = 1;

        ArrayList<Integer> neighbours = graph.get(source);
        for(int i=0; i< neighbours.size(); i++){
            int y = neighbours.get(i);

            if(vis[y]==0){
               boolean has_cycle =  dfs_cycle(y, source);
               if(has_cycle)
                   return true;
            }else{
                if(y !=parent){
                    return true;
                }
            }
        }

        return false;
    }

    public static void dfs(int source){

        vis[source] = 1;

        ArrayList<Integer> neighbours = graph.get(source);
        for(int i=0; i< neighbours.size(); i++){
            int y = neighbours.get(i);

            if(vis[y]==0){
                dfs(y);
            }
        }
    }
    public static boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        System.out.println("validTree parent " + Arrays.toString(parent));
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            if (find(nodeA) == find(nodeB)) {
                return false;
            }

            parent[find(nodeA)] = find(nodeB);
            --n;
        }
        return n == 1;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
