package com.practice;

public class PermuteAllListNumbers {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3};
        permute(numbers, 0);
    }

    static void permute(int[] a, int k) {
        if (k == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
}
