package com.leetcode.systemdesign;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
public class SnakeGame {

    private int height;
    private int width;
    private int[][] food;
    private int score;
    private int foodIndex;
    private Deque<Integer> snakeBody = new ArrayDeque<>();
    private Set<Integer> visited = new HashSet<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        snakeBody.offer(0); // Snake starts at the top-left corner (0,0)
        visited.add(0); // Mark the start position as occupied
    }

    public int move(String direction) {
        int head = snakeBody.peekFirst();
        int row = head / width, col = head % width;
        int newRow = row, newCol = col;
        System.out.println("head: " + head + " newRow: " + newRow + " newCol: " + newCol + " direction: " + direction);
        // Change the head position based on the direction.
        switch (direction) {
            case "U":
                newRow--;
                break;
            case "D":
                newRow++;
                break;
            case "L":
                newCol--;
                break;
            case "R":
                newCol++;
                break;
        }
        //System.out.println("newRow: " + newRow + " newCol: " + newCol );
        // Check if the new head position is out of bounds.
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            return -1;
        }

        // Check if the snake eats food.
        if (foodIndex < food.length && newRow == food[foodIndex][0] && newCol == food[foodIndex][1]) {
            score++;
            foodIndex++;
        } else {
            // If not eating, move the tail.
            int tail = snakeBody.pollLast();
            visited.remove(tail);
        }

        int newHead = flattenPosition(newRow, newCol);

        // Check if the snake bites itself.
        if (visited.contains(newHead)) {
            return -1;
        }

        // Add the new head to the snake body and mark it as visited.
        snakeBody.offerFirst(newHead);
        visited.add(newHead);

        return score;
    }

    // Converts 2D grid coordinates to a single integer.
    private int flattenPosition(int i, int j) {
        return i * width + j;
    }

    public static void main(String[] args) {
        input1();
    }

    static void input1(){
        int width = 3;
        int height = 2;
        int[] [] food = {{1,2}, {0,1}};
        SnakeGame game = new SnakeGame(width, height, food);
        System.out.println("R " + game.move("R"));
        System.out.println("D " + game.move("D"));
        System.out.println("R " + game.move("R"));
        System.out.println("U " + game.move("U"));
        System.out.println("L " + game.move("L"));
        System.out.println("U " + game.move("U"));


    }
}
