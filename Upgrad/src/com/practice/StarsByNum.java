package com.practice;

public class StarsByNum {

    public static void main(String[] args) {

        int num = 5;

        printStars(num);
        printStarsByWhile(num);
        printStarsBackwards(num);

        printStarsPyramid(num);

    }

    static void printStars(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printStarsByWhile(int num) {

        int i =0;

        while(i<num){
            int j= 0;
            while(j<=i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

    }


    static void printStarsBackwards(int num) {
        for (int i = 0; i < num; i++) {

//            for(int j=(2*(num-i)); j>=0; j--){
            for (int j = i; j <= num; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    static void printStarsPyramid(int num){
        for (int i = 0; i < num; i++) {
            for (int j = i; j <= num; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}
