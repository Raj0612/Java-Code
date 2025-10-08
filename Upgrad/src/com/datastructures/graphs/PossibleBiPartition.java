package com.datastructures.graphs;

import java.util.*;
import java.util.stream.IntStream;

//We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
//Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi,
// return true if it is possible to split everyone into two groups in this way.
/*
Example 1:
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: The first group has [1,4], and the second group has [2,3].

Example 2:
Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.

Constraints:
1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= ai < bi <= n
All the pairs of dislikes are unique.
 */
enum Color {kWhite, kRed, kGreen}
public class PossibleBiPartition {

    public static void main(String[] args) {
        input1();
        System.out.println();
        input2();
    }

    static void input1() {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println("input1 possibleBipartition" + possibleBipartition(n, dislikes));
        System.out.println("input1 possibleBipartition1 " + possibleBipartition1(n, dislikes));
        System.out.println("input1 possibleBipartitionUsingQueue " + possibleBipartitionUsingQueue(n, dislikes));
    }

    static void input2() {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println("input2 possibleBipartition " + possibleBipartition(n, dislikes));
        System.out.println("input2 possibleBipartition1 " + possibleBipartition1(n, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; ++i) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] d : dislikes) {
            final int u = d[0];
            final int v = d[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        System.out.println("possibleBipartition graph " + graph);
        for (int i = 1; i <= n; ++i)
            if (colors[i] == -1 && !validColor(graph, colors, 0, i))
                return false;

        return true;
    }


    public static boolean validColor(Map<Integer, List<Integer>> graph, int[] colors, int color, int node) {
        colors[node] = color;
        for (int next : graph.get(node)) {
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
    private static boolean validColor3(Map<Integer, List<Integer>> graph, int[] colors, int color, int node) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int neighbor : graph.get(node)) {
            if (!validColor(graph, colors, 1 - color, neighbor)) {
                return false;
            }
        }
        return true;
    }

    public static boolean possibleBipartition1(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        Color[] colors = new Color[n + 1];
        Arrays.fill(colors, Color.kWhite);

        for (int i = 1; i <= n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] d : dislikes) {
            final int u = d[0];
            final int v = d[1];
            graph[u].add(v);
            graph[v].add(u);
        }
       // printGraph(graph, n);

        // Reduce to 785. Is Graph Bipartite?
        for (int i = 1; i <= n; ++i)
            if (colors[i] == Color.kWhite && !isValidColor(graph, i, colors, Color.kRed))
                return false;

        return true;
    }

    private static boolean isValidColor(List<Integer>[] graph, int u, Color[] colors, Color color) {
        // The painted color should be same as the `color`
        if (colors[u] != Color.kWhite)
            return colors[u] == color;

        colors[u] = color; // Always paint w/ `color`

        // All children should have valid colors
        for (final int v : graph[u])
            if (!isValidColor(graph, v, colors, color == Color.kRed ? Color.kGreen : Color.kRed))
                return false;

        return true;
    }

    private static boolean possibleBipartitionUsingQueue(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;  // already visited

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            color[i] = 1; // start with group A

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int nei : graph.get(curr)) {
                    if (color[nei] == 0) {
                        // Assign opposite color
                        color[nei] = -color[curr];
                        queue.offer(nei);
                    } else if (color[nei] == color[curr]) {
                        // Conflict → not bipartite
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void printGraph(List<Integer>[] graph, int n) {
        IntStream.rangeClosed(1, n).forEach(i -> {
            System.out.print("Node " + i + ": ");
            graph[i].stream()
                    .forEach(neighbor -> System.out.print(neighbor + " "));
            System.out.println();
        });
    }

}
