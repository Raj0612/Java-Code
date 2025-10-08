package com.datastructures.trees.binarytrees;
import java.util.*;
//You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
// The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels
// (i.e. The node with the number i has the label labels[i]).

//The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
//Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
//A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
/*
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).

Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
Output: [4,2,1,1]
Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
The sub-tree of node 3 contains only node 3, so the answer is 1.
The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.
 */
//
public class NoOfNodesInSubTreeWithSameLabel {
    private static List<Integer>[] graph;
    private static String labels;
    private static int[] answer;
    private static int[] count;
    public static void main(String[] args) {
        input1();
       // input2();
    }

    static void input1(){
        int n  =7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";
        System.out.println("input1: countSubTrees " + Arrays.toString(countSubTrees(n, edges, labels)));
        System.out.println("input1: countSubTrees1 " + Arrays.toString(countSubTrees1(n, edges, labels)));
    }

    static void input2(){
        int n  =4;
        int[][] edges = {{0,1},{1,2},{0,3}};
        String labels = "bbbb";
        System.out.println("input2: countSubTrees " + Arrays.toString(countSubTrees(n, edges, labels)));
        System.out.println("input2: countSubTrees1 " + Arrays.toString(countSubTrees1(n, edges, labels)));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels1) {
        System.out.println("countSubTrees edges " + Arrays.deepToString(edges) + " labels1 " + labels1);
        graph = new List[n];
        Arrays.setAll(graph, x -> new ArrayList<>());
        System.out.println("countSubTrees graph " + Arrays.deepToString(graph));
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        System.out.println("countSubTrees graph1 " + Arrays.deepToString(graph));
        labels = labels1;
        answer = new int[n];
        count = new int[26];

        dfs(0, -1);
        return answer;
    }

    private static void dfs(int node, int parent) {
        int labelIndex = labels.charAt(node) - 'a';

        // Decrement count of the current label at this node before DFS, as this count will include
        // all occurrences in the subtree rooted at this node.
        answer[node] -= count[labelIndex];
        count[labelIndex]++;

        // Visit all the connected nodes that are not the parent.
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node);
            }
        }
        // After visiting all children, increment the answer for this node.
        // Now the count includes all occurrences in subtree plus the current node.
        answer[node] += count[labelIndex];
    }

    public static int[] countSubTrees1(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> nodeToChildren = new HashMap<>();
        for (int[] edge : edges) {
            nodeToChildren.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            nodeToChildren.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
           // nodeToChildren.get(edge[0]).add(edge[1]);
            //nodeToChildren.get(edge[1]).add(edge[0]);

        }
        System.out.println("countSubTrees1 nodeToChildren " + nodeToChildren);

        return null;
    }
}
