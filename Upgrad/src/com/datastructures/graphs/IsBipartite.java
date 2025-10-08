package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

enum ColorIsBipartite { kWhite, kRed, kGreen }
public class IsBipartite {
    public static void main(String[] args) {
         input1();
        System.out.println();
        //input2();
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i = 0; i < n; ++i)
            color[i] = -1;
        for(int i = 0; i < n; ++i) {
            if(checkBipartite(i, graph, color) == false)
                return false;
        }
        return true;
    }
    private static boolean checkBipartite(int current, int[][] graph, int[] color) {
        if(color[current] == -1)
            color[current] = 1;
        for(int adj : graph[current]) {
            if(color[adj] == -1) {
                color[adj] = 1 - color[current];
                if(checkBipartite(adj, graph, color) == false)
                    return false;
            } else if(color[adj] == color[current])
                return false;
        }
        return true;
    }

    public static boolean isBipartiteBFS(int[][] graph) {
        ColorIsBipartite[] colors = new ColorIsBipartite[graph.length];
        Arrays.fill(colors, ColorIsBipartite.kWhite);

        for (int i = 0; i < graph.length; ++i) {
            // Already colored, so do nothing.
            if (colors[i] != ColorIsBipartite.kWhite)
                continue;
            // Always paint w/ Color.kRed for Color.kWhite.
            colors[i] = ColorIsBipartite.kRed;
            // BFS
            Queue<Integer> q = new ArrayDeque<>(Arrays.asList(i));
            while (!q.isEmpty()) {
                for (int sz = q.size(); sz > 0; --sz) {
                    final int u = q.poll();
                    for (final int v : graph[u]) {
                        if (colors[v] == colors[u])
                            return false;
                        if (colors[v] == ColorIsBipartite.kWhite) {
                            colors[v] = colors[u] == ColorIsBipartite.kRed ? ColorIsBipartite.kGreen : ColorIsBipartite.kRed;
                            q.offer(v);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUpgrad(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // visited arr

        Arrays.fill(colors, -1); // if colors[i] == -1, i node is not yet visited

        for (int i = 0; i < n; i++) {
            //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == -1 && !validColor(graph, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validColor(int[][] graph, int[] colors, int color, int node) {
        colors[node] = color;
        for (int next : graph[node]) {
            if (colors[next] != -1){ // already visited
                if (colors[next] == color) {
                    return false;
                }
            } else {
                if (!validColor(graph, colors, 1 - color, next)) {
                    return false;
                }

            }
        }
        return true;
    }

    static void input1(){
        int[][] graph =  {{1,2,3}, {0, 2}, {0, 1, 3}, {0,2}};
        System.out.println("input1 : " + Arrays.deepToString(graph));
        System.out.println("input1 isBipartite " + isBipartite(graph));
        System.out.println("input1 isBipartite1 " + isBipartiteBFS(graph));
        System.out.println("input1 isBipartiteUpgrad " + isBipartiteUpgrad(graph));
    }

    static void input2(){
        System.out.println();
        int[][] graph =  {{1, 3}, {0, 2}, {1, 3}, {0,2}};
        System.out.println("input2 : " + Arrays.deepToString(graph));
        System.out.println("input2 isBipartite " + isBipartite(graph));
        System.out.println("input2 isBipartite1 " + isBipartiteBFS(graph));
        System.out.println("input2 isBipartiteUpgrad " + isBipartiteUpgrad(graph));
    }
}
