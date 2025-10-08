package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class TransposeGraph {
    private static int vertices = 5;
    private static ArrayList<Integer>[] adj = new ArrayList[vertices];
    private static ArrayList<Integer>[] tr = new ArrayList[vertices];

    public static void main(String[] args) {
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<Integer>();
            tr[i] = new ArrayList<Integer>();
        }
        System.out.println("adj " + Arrays.toString(adj));
        System.out.println("tr " + Arrays.toString(tr));
        addEdge(0, 1, false);
        addEdge(0, 4, false);
        addEdge(0, 3, false);
        addEdge(2, 0, false);
        addEdge(3, 2, false);
        addEdge(4, 1, false);
        addEdge(4, 3, false);
        printAdjacentGraph();
        System.out.println("Adjacent Graph " + Arrays.toString(adj));
        getTranspose();
        System.out.println();
        printTransposeGraph();
        System.out.println("Transpose Graph " + Arrays.toString(tr));
    }

    public static void addEdge(int u, int v, boolean choice) {
        if (!choice)
            adj[u].add(v);
        else
            tr[u].add(v);
    }

    //Time  - O(V + E)
    public static void printAdjacentGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "--> ");
            for (int j = 0; j < adj[i].size(); j++)
                System.out.print(adj[i].get(j) + " ");
            System.out.println();
        }
    }

    //Time - O(V + E) needs to traverse the adjacency list of each vertex and print out the adjacent vertices
    public static void printTransposeGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "--> ");
            for (int j = 0; j < tr[i].size(); j++)
                System.out.print(tr[i].get(j) + " ");
            System.out.println();
        }
    }


    //Time  - O(V + E)
    //Space  - O(V)
    public static void getTranspose() {
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < adj[i].size(); j++)
                addEdge(adj[i].get(j), i, true);
    }
}
