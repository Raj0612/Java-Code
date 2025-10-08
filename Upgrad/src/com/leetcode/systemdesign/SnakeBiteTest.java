package com.leetcode.systemdesign;

import java.util.LinkedList;

public class SnakeBiteTest {

    public static void main(String[] args) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        int x = 0, y= 2;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        queue.offer(new int[]{0, 2});
        queue.offer(new int[]{0, 3});
        queue.offer(new int[]{1, 3});
        queue.offer(new int[]{1, 2});
      //  queue.offer(new int[]{0, 2});

        for(int[] p: queue){
            System.out.println("p[0] " + p[0] + " p[1] " + p[1]);
            if(p[0]==x&&p[1]==y)
                System.out.println("Bite itself");
        }
    }
}
