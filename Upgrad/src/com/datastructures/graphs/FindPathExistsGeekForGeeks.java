package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathExistsGeekForGeeks {
    static int V;
    static ArrayList<ArrayList<Integer>> adj;

    FindPathExistsGeekForGeeks(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    static boolean isReachable(int s, int d) {
        if (s == d)
            return true;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.remove();
            for (int i = 0; i < adj.get(s).size(); i++) {
                if (adj.get(s).get(i) == d)
                    return true;

                if (!visited[adj.get(s).get(i)]) {
                    visited[adj.get(s).get(i)] = true;
                    queue.add(adj.get(s).get(i));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        FindPathExistsGeekForGeeks graph = new FindPathExistsGeekForGeeks(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int u = 1, v = 3;
        if (graph.isReachable(u, v))
            System.out.println("\n There is a path from " + u + " to " + v);
        else
            System.out.println("\n There is no path from " + u + " to " + v);
    }

}
