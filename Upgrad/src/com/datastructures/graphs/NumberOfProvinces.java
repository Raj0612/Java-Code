package com.datastructures.graphs;
//There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c.
//A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//Return the total number of provinces.

/*
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */
public class NumberOfProvinces {
    static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) {
        input1();
        input2();
        input3();
        input4();

    }

    /*Time: The time complexity of the above code is O(n*m) because we are traversing each element of the grid always once.
    Here n and m are the numbers of rows and number of columns respectively.
    Space: The space complexity of the above code is O(n*m) because we are using a 2D array to store whether we have visited a land or not.*/
    public static int numIslands(char[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
       // System.out.println("numIslands n: " + n + " m: " + m);
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    ans++;
                    dfs(grid,vis,i,j,n,m);
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid,boolean vis[][],int x,int y,int n,int m ){
        if(!check(x,y,n,m) || grid[x][y]=='0' || vis[x][y]==true){
            return;
        }
        vis[x][y]=true;
        for(int i=0;i<4;i++){
            int x1=x+dir[i][0];
            int y1=y+dir[i][1];
            dfs(grid,vis,x1,y1,n,m);
        }
    }

    public static boolean check(int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m;
    }

    public static int findCircleNumByUpgrad(char[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        int count =0;

        for(int i=0; i< n; i++){
            if(vis[i]== 0){
                dfs(i, n, vis, isConnected);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int i, int n, int[] vis, char[][] isConnected){
        vis[i] =1;

        for(int j=0; j< n; j++){
            if(isConnected[i][j] == '1' && i!=j && vis[j]==0){
                dfs(j, n, vis, isConnected);
            }
        }
    }

    static void input1(){
        char grid[][]={
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("input1: " +numIslands(grid));
        System.out.println("input1: " + findCircleNumByUpgrad(grid));
    }

    static void input2(){
        char grid[][]={
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println();
        System.out.println("input2: " +numIslands(grid));
        System.out.println("input2: " + findCircleNumByUpgrad(grid));
    }

    static void input3(){
        char grid[][]={
                {'1', '1', '0'},
                {'1', '1', '0'},
                {'0', '0', '1'}};
        System.out.println();
        System.out.println("input3: " + numIslands(grid));
        System.out.println("input3: " + findCircleNumByUpgrad(grid));
    }


    static void input4(){
        char grid[][]={
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}};
        System.out.println();
        System.out.println("input4 :" + numIslands(grid));
        System.out.println("input4: " + findCircleNumByUpgrad(grid));
    }
}
