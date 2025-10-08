package com.datastructures.graphs;

//You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color.
// Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
//To perform a flood fill:
/*
1. Begin with the starting pixel and change its color to color.
2. Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically)
   and shares the same color as the starting pixel.
3.Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
4. The process stops when there are no more adjacent pixels of the original color to update.
 */
//Return the modified image after performing the flood fill.
/*
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel
    (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.
 */
public class FloodFill {
    static int m = 3;
    static int n = 3;
    static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) {

        input1();
        input2();
       // inputUpgrade();

    }

    static void input1(){
        int a[][] = {{1, 1, 1},
                     {1, 1, 0},
                     {1, 0, 1},};
        print2D(a);
        int x = 1, y = 1, color = 2;
        floodFill(a, x, y, color);
        System.out.println();
   //     floodFillUpgrade(a, x, y, color);
        System.out.println("input1 Result:");
        print2D(a);
    }

    static void input2(){
        int a[][] = {{1, 1, 0},
                     {1, 1, 0},
                     {1, 0, 0},};
        System.out.println();
        print2D(a);

       /* System.out.println("len " + a[0].length);
        System.out.println("len " + a[1].length);
        System.out.println("len " + a[2].length);
*/
        int x = 1, y = 2, color = 5;
        floodFill(a, x, y, color);
        System.out.println("input2 Result:");
        print2D(a);
    }

    //Time Complexity: O(N) where N is the number of elements which is equal to Row*Column. i.e. number image pixels.
    //Auxiliary Space: O(1) because we don’t use any auxiliary space in implementation.
    static void floodFill(int a[][], int x, int y, int color) {
        int prevColor = a[x][y];
        System.out.println("floodFill prevColor " + prevColor);
        floodFill(a, x, y, prevColor, color);
    }

    static void floodFill(int a[][], int x, int y, int prevColor, int newColor) {
        System.out.println("x: " + x + " y: " + y );
        if(x<0 || x>=m || y<0 || y>=n || a[x][y] != prevColor)
            return;
//        if(a[x][y] != prevColor)
//            return;

        a[x][y] = newColor;
        System.out.println("");
        print2D(a);
        floodFill(a, x+1, y, prevColor, newColor); //Down
        floodFill(a, x-1, y, prevColor, newColor); //Up
        floodFill(a, x, y+1, prevColor, newColor); //Right
        floodFill(a, x, y-1, prevColor, newColor); //Left

    }
    static void inputUpgrade(){
        System.out.println("inputUpgrade");
        int a[][] = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},};
        print2D(a);
        int x = 1, y = 1, color = 2;
        floodFillUpgrade(a, x, y, color);
        System.out.println();
        print2D(a);
    }

    static int[][] floodFillUpgrade(int image[][], int sr, int sc, int color) {
        dfs(image, sr, sc, color,image[sr][sc]);
        return image;
    }
    static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){

        if(newColor == oldColor)
            return;
        image[sr][sc] = newColor;

        //left neighbour
        int i =sr, j = sc -1;
        if(isValid(i, j, image, oldColor)){
            dfs(image, i, j, newColor, oldColor);
        }
        //right neighbour
        i = sr;
        j = sc + 1;
        if(isValid(i, j, image, oldColor)){
            dfs(image, i, j, newColor, oldColor);
        }

        //upper neighbour
        i = sr-1;
        j = sc;
        if(isValid(i, j, image, oldColor)){
            dfs(image, i, j, newColor, oldColor);
        }

        //down neighbour
        i = sr+1;
        j = sc;
        if(isValid(i, j, image, oldColor)){
            dfs(image, i, j, newColor, oldColor);
        }
    }

    static boolean isValid(int i, int j, int[][] image,int oldColor){
        int rowLen = image.length;
        int columnLen = image[0].length;
        return (i>=0 &&  i<=rowLen-1 && j>=0 && j<=columnLen-1 && image[i][j] == oldColor);
    }

    public static void print2D(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

}
