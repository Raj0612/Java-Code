package com.datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
/*
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class NumberOfIslands {
    static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
    static int di[]={-1, 0, 1, 0};
    static int dj[]={0, 1, 0, -1};

    static int n, m;
   static boolean vis[][]= null;
    public static void main(String[] args) {
       // input1();
       // input2();
        input3();
    }

    /*Time: The time complexity of the above code is O(n*m) because we are traversing each element of the grid always once.
    Here n and m are the numbers of rows and number of columns respectively.
    Space: The space complexity of the above code is O(n*m) because we are using a 2D array to store whether we have visited a land or not.*/
    public static int numIslands(char[][] grid) {
        int ans=0;
        n=grid.length;
        m=grid[0].length;
        vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                  //  System.out.println("Ans i: " + i + " j: " + j);
                    ans++;
                    dfs(grid,vis,i,j,n,m);
                    //numIslandsByBFS(i, j, grid);
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid,boolean vis[][],int x,int y,int n,int m ){
        if(!check(x,y,n,m) || grid[x][y]=='0' || vis[x][y]==true){
            return;
        }
        System.out.println("dfs:::: row " + x  +" col " + y);
        vis[x][y]=true;
        printVisitedArray(vis);
        for(int i=0;i<4;i++){
            int x1=x+dir[i][0];
            int y1=y+dir[i][1];
            if(i==0){
                System.out.println("Base: ("+x+","+y+")  Check: ("+x1+","+y1+")  *****UP");
            }else if(i==1){
                System.out.println("Base: ("+x+","+y+")  Check: ("+x1+","+y1+")  *****LEFT");
            }else if(i==2){
                System.out.println("Base: ("+x+","+y+")  Check: ("+x1+","+y1+")  *****DOWN");
            }else if(i==3){
                System.out.println("Base: ("+x+","+y+")  Check: ("+x1+","+y1+")  *****RIGHT");
            }
//            if(isValid(x1, y1, grid)){
//                dfs(grid,vis,x1,y1,n,m);
//            }
            dfs(grid,vis,x1,y1,n,m);
            System.out.println("After dfs:::: row " + x  +" col " + y);
        }
    }

    public static void numIslandsByBFS(int i, int j, char[][] grid) {
        vis[i][j]=true;
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(i, j));
        while(!queue.isEmpty()){
            NodeInfo currNode = queue.poll();

            for(int k=0;k<4;k++){
                int x1= currNode.i+dir[k][0];
                int y1= currNode.j+dir[k][1];
                if(k==0){
                    System.out.println("Base: ("+currNode.i+","+currNode.j+")  Check: ("+x1+","+y1+")  *****UP");
                }else if(k==1){
                    System.out.println("Base: ("+currNode.i+","+currNode.j+")  Check: ("+x1+","+y1+")  *****LEFT");
                }else if(k==2){
                    System.out.println("Base: ("+currNode.i+","+currNode.j+")  Check: ("+x1+","+y1+")  *****DOWN");
                }else if(k==3){
                    System.out.println("Base: ("+currNode.i+","+currNode.j+")  Check: ("+x1+","+y1+")  *****RIGHT");
                }
                if(isValid(x1, y1, grid)){
                    queue.add(new NodeInfo(x1,y1));
                    vis[x1][y1]=true;
                    printVisitedArray(vis);
                    System.out.println();
                }
            }

        }
    }

    public static boolean isValid(int i,int j,char[][] grid){
        return (i>=0 && j>=0 && i<n && j<m && grid[i][j] == '1' && vis[i][j]== false);
    }

    public static boolean check(int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m;
    }

    static void input1(){
        char grid[][]={
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("input1");
        System.out.println(Arrays.deepToString(grid));
        System.out.println("input 1: " + numIslands(grid));
        System.out.println();
    }

    static void input2(){
        char grid[][]={
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println("input2");
        System.out.println(Arrays.deepToString(grid));
        System.out.println("input 2 : " +numIslands(grid));
    }

    static void input3(){
        char grid[][]= {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };
        System.out.println("input3");
        System.out.println(Arrays.deepToString(grid));
        System.out.println("input3 : " + numIslands(grid));
        System.out.println();
    }


    public static void printVisitedArray(boolean mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class NodeInfo{
    int i, j;

    public NodeInfo(int i, int j){
        this.i = i;
        this.j = j;
    }
}
