package com.datastructures.graphs;

import java.util.ArrayList;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    static Graph constructGraph(){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        return g;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V +
                ", adj=" + adj +
                '}';
    }

    public static void main(String[] args) {
       Graph graph =  constructGraph();
        System.out.println("graph " + graph);
    }
}
