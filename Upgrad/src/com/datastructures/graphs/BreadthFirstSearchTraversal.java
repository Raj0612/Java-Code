package com.datastructures.graphs;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearchTraversal {
    private int vertices;
    private static LinkedList<Integer> adj[];

    BreadthFirstSearchTraversal(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[vertices];
        System.out.println("visited " + Arrays.toString(visited));

        // Create a queue for BFS
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        System.out.println("visited1 " + Arrays.toString(visited));
        System.out.println();
        queue.add(s);

        while (queue.size() != 0) {
            System.out.println("Queue " + queue);
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s.
            // If an adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            System.out.println("From list " + adj[s]);
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            System.out.println("Visited2 " + Arrays.toString(visited));
            System.out.println();
        }
    }

    public static void main(String args[])  {
        BreadthFirstSearchTraversal g = new BreadthFirstSearchTraversal(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("adj " + Arrays.toString(adj));
        System.out.println( "Following is Breadth First Traversal  (starting from vertex 2)");

        g.BFS(2);
    }
}
