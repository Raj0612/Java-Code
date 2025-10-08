package com.leetcode.systemdesign;

import java.util.LinkedList;

public class DesignSnakeGameUpgrad {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int[][] food;
    int width;
    int height;
    int foodIndex; // score
    LinkedList<int[]> body;
    public DesignSnakeGameUpgrad(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.foodIndex = 0;
        this.food = food;
        body = new LinkedList<int[]>();
        int[] initial_index = {0,0};
        body.add(initial_index);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) { // O(1)
        int x = body.get(0)[0];
        int y = body.get(0)[1];
        int[] newpoint = new int[2];
        if(direction.equals("U")) {
            x = x-1;
        }
        else if(direction.equals("L")) {
            y = y-1;
        }
        else if(direction.equals("R")) {
            y = y+1;
        }
        else {
            x = x+1;
        }
        if(x< 0 || x>=height || y <0 || y >=width) return -1;
        newpoint[0] = x;
        newpoint[1] = y;
        int[] toDelete = body.get(body.size()-1);
        body.remove(body.size()-1);
        if(isDead(x,y)) return -1;
        body.add(0,newpoint);
        if(food.length > foodIndex && x == food[foodIndex][0] && y == food[foodIndex][1]) {
            body.add(toDelete);
            foodIndex++;
            return foodIndex;
        }
        return foodIndex;
    }

    //to test whether it will reach the tails
    public boolean isDead(int x, int y) { // self bite // O(len of snake body) == O(50) == O(1)
        for(int i = body.size() -1; i>=0; i--) {
            int[] t = body.get(i);
            if(t[0] == x && t[1] ==y) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        input1();
    }

    static void input1(){
        int width = 3;
        int height = 2;
        int[] [] food = {{1,2}, {0,1}};
        DesignSnakeGame game = new DesignSnakeGame(width, height, food);
        System.out.println("R " + game.move("R"));
        System.out.println("D " + game.move("D"));
        System.out.println("R " + game.move("R"));
        System.out.println("U " + game.move("U"));
        System.out.println("L " + game.move("L"));
        System.out.println("U " + game.move("U"));
    }
}
