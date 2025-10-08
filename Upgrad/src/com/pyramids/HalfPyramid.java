package com.pyramids;

public class HalfPyramid {

    public static void main(String[] args) {
        int rows = 5;
        char last = 'E', alphabet = 'A';
        halfPyramidsStars(rows);
        halfPyramidsNumbers(rows);
        halfPyramidsAlphabets(alphabet, last);
        halfPyramidsAlphabetsByOrder(alphabet, last);

    }
    static void halfPyramidsStars(int rows){
        for(int i=1;i<=rows; i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void halfPyramidsNumbers(int rows){
        for(int i=1;i<=rows; i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    static void halfPyramidsAlphabets(char start, char last){
        System.out.println(" (last - start) " + (last - start));
        int num = (last - 'A' + 1);
        System.out.println("num " + num);
        for(int i=1;i<=num; i++){
            for(int j=1;j<=i;j++){
                System.out.print(start);
            }
            ++ start;
            System.out.println();
        }
    }

    static void halfPyramidsAlphabetsByOrder(char start, char last){
        System.out.println(" (last - start) " + (last - start));
        int num = (last - 'A' + 1);
        char startchar = start;
        System.out.println("num " + num);
        for(int i=1;i<=num; i++){
            for(int j=1;j<=i;j++){
                System.out.print(start);
                start++;
            }
           start =startchar;
            System.out.println();
        }
    }
}
