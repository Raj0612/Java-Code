package com.datastructures.graphs;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int n  = 6;
        System.out.println(Arrays.toString(get(7, n)));
    }

    public static int[] get(int x, int n) {
        int i = (x - 1) / n, j = (x - 1) % n;
        if (i % 2 == 1) {
            j = n - 1 - j;
        }
        return new int[] {n - 1 - i, j};
    }
}
