package com.datastructures.graphs;

public class NoOfIslandsIncludingDiagonals {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};


    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };

    public static void main(String[] args) {
        input1();
    }

    static void input1(){
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands: " + countIslands(grid));
    }

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Found an unvisited land cell
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++; // one island found
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        // Explore all 8 neighbors
        for (int d = 0; d < 8; d++) {
            int newRow = row + rowDir[d];
            int newCol = col + colDir[d];

            if (isValid(grid, visited, newRow, newCol)) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }

    private static boolean isValid(int[][] grid, boolean[][] visited, int row, int col) {
        return row >= 0 && row < grid.length &&
                col >= 0 && col < grid[0].length &&
                grid[row][col] == 1 &&
                !visited[row][col];
    }

}
