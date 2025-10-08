package com.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//The area of an island is the number of cells with a value 1 in the island.
//Return the maximum area of an island in grid. If there is no island, return 0.
/*
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class MaxAreaOfIsland {
    static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
    static int count_of_ones = 0;
    static int max_count = 0;
    static int visited[][];
    static  int row, column;

    static int[] di ={-1, 0, 1, 0};
    static int[] dj ={0, 1, 0, -1};


    public static void main(String[] args) {
        input1();
    }

    static void input1(){
//        int grid[][]={
//                {0,'0','1','0','0','0','0','1','0','0','0','0','0'},
//                {'0','0','0','0','0','0','0','1','1','1','0','0','0'},
//                {'0','1','1','0','1','0','0','0','0','0','0','0','0'},
//                {'0','1','0','0','1','1','0','0','1','0','1','0','0'},
//                {'0','1','0','0','1','1','0','0','1','1','1','0','0'},
//                {'0','0','0','0','0','0','0','0','0','0','1','0','0'},
//                {'0','0','0','0','0','0','0','1','1','1','0','0','0'},
//                {'0','0','0','0','0','0','0','1','1','0','0','0','0'}
//                 };

        int grid[][]={
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println("maxAreaOfIsland " + maxAreaOfIsland(grid));
        System.out.println("maxAreaByIslandByUpgrad " + maxAreaByIslandByUpgrad(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                  //  System.out.println("Ans i: " + i + " j: " + j);
                    count_of_ones =0;
                    dfs(grid,vis,i,j,n,m);
                    ans = Math.max(ans, count_of_ones);
                }
            }
        }
        return ans;
    }

    public static void dfs(int[][] grid,boolean vis[][],int x,int y,int n,int m){
        if(!check(x,y,n,m) || grid[x][y]== 0 || vis[x][y]==true){
            return;
        }
            vis[x][y]=true;
            count_of_ones ++;

        for(int i=0;i<4;i++){
            int x1=x+dir[i][0];
            int y1=y+dir[i][1];
           // System.out.println("x1: "+ x1 + " y1: " + y1);
           dfs(grid,vis,x1,y1,n,m);
        }
    }

    public static boolean check(int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m;
    }


    public static int maxAreaByIslandByUpgrad(int[][] grid){
        int count = 0;
        row=grid.length;
        column=grid[0].length;
        visited = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count_of_ones =0;
                    //dfs(i, j, grid);
                    numIslandsByQueue(i, j , grid);
                    max_count = Math.max(max_count, count_of_ones);
                }
            }
        }

        return max_count;
    }

    static void dfs(int i, int j, int[][] grid ){
        visited[i][j] = 1;
        count_of_ones++;

        int i_new, j_new;
        for(int k =0; k< 4; k++){
            i_new = i + di[k];
            j_new = j+ dj[k];

            if(isValid(i_new, j_new, grid)) {
                dfs(i_new, j_new, grid);
            }
        }
    }

    static  boolean isValid(int i, int j, int[][] grid){
        return (i>=0 && i< row && j>=0 && j < column && grid[i][j] == 1 && visited[i][j]==0);
    }

    public static void numIslandsByQueue(int i, int j, int[][] grid) {
       // visited[i][j]=1;
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(i, j));
        while(!queue.isEmpty()){
            NodeInfo currNode = queue.poll();
            count_of_ones++;
            visited[currNode.i][currNode.j]=1;
            for(int k=0;k<4;k++){
                int x1= currNode.i+dir[k][0];
                int y1= currNode.j+dir[k][1];
                if(isValid(x1, y1, grid)){
                    queue.add(new NodeInfo(x1,y1));

                }
            }
        }
    }
}
