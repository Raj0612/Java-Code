package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

//In an infinite  chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
//A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
//Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
/*
Example1:
Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]

Example2:
Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 */

//|x| + |y| <= 300
public class MinimumKnightMoves {

    public static void main(String[] args) {
        // input1();
        System.out.println();
        input2();
    }

    static void input1() {
        int x = 2;
        int y = 1;
        System.out.println("input1 minKnightMoves " + minKnightMoves(x, y));
    }

    static void input2() {
        int x = 5;
        int y = 5;
        System.out.println("input1 minKnightMoves " + minKnightMoves(x, y));
    }

    public static int minKnightMoves(int x, int y) {
        // Offset coordinates by 310 to deal with negative indices since a knight can move backward.
        //  x += 310;
        // y += 310;
        int ans = 0;
        // Directions a knight can move: 8 possibilities
        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        // queue.offer(new int[] {310, 310});
        boolean[][] visited = new boolean[700][700];
        // boolean[][] visited = new boolean[621][621];
        visited[0][0] = true;
        // visited[310][310] = true;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; --k) {
         //   while(queue.size() > 0) { continuously polling and adding back into the same queue without fixing the level size first.
                int[] point = queue.poll();
                if (point[0] == x && point[1] == y) {
                    return ans;
                }
                for (int[] direction : directions) {
                    int nextX = point[0] + direction[0];
                    int nextY = point[1] + direction[1];
                    // Make sure the new position is within bounds and hasn't been visited
                    if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[nextX].length && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }

            }
            ++ans;
        }
        return -1;
    }
}
