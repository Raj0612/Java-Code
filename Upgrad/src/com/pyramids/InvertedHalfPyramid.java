package com.pyramids;

public class InvertedHalfPyramid {

    public static void main(String[] args) {
        int rows = 5;
        invertedHalfPyramidStars(rows);
        invertedHalfPyramidNumbers(rows);
    }

    static void invertedHalfPyramidStars(int rows){
        for (int i = rows; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void invertedHalfPyramidNumbers(int rows){
        for (int i = rows; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
