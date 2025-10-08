package com.leetcode.binaryheap;

//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
/*
        Input: points = [[1,3],[-2,2]], k = 1
        Output: [[-2,2]]
        Explanation:
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

        Example 2:
        Input: points = [[3,3],[5,-1],[-2,4]], k = 2
        Output: [[3,3],[-2,4]]
        Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        input1();
      //  input2();
    }
    static void input1(){
        int points[][] = { { 3, 3 },
                           { 5, -1 },
                           { -2, 4 } };
        int K = 2;
        System.out.println("input1 " + Arrays.deepToString(points) + " k " + K);
    //    kClosest(points, K);
        //System.out.println("kClosestByPriorityQueue input1 " + Arrays.deepToString(kClosestByPriorityQueue(points, K)));
       System.out.println("kClosestByPriorityQueue input1 " + Arrays.deepToString(kClosestByPriorityQueue1(points, K)));
    }

    static void input2(){
        System.out.println();
        int points[][] = { { 1,3},
                {-2,2 }};
        int K = 1;
        System.out.println("input2 " + Arrays.deepToString(points)+ " k " + K);
      //  kClosest(points, K);
        //System.out.println("kClosestByPriorityQueue input2 " + Arrays.deepToString(kClosestByPriorityQueue(points, K)));
        System.out.println("input2 kClosestByPriorityQueue " + Arrays.deepToString(kClosestByPriorityQueue1(points, K)));
    }

    public static void kClosest(int[][] points, int k) {

        int n = points.length;
        int[] distance = new int[n];
        for(int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            distance[i] = (x * x) + (y * y);
        }
        System.out.println("kClosest distance " + Arrays.toString(distance));
        Arrays.sort(distance);
        System.out.println("kClosest distance1 " + Arrays.toString(distance));
        int distk = distance[k - 1];
        System.out.println("kClosest distk " + distk);

        int ans[][] = new int[k][2];
        for(int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            int dist = (x * x) + (y * y);
            System.out.println("kClosest dist " + dist);
            if (dist <= distk){
                System.out.println("[" + x + ", " + y + "]");
            }

        }
    }

    //The time complexity of the above code is O(NlogK) since we traverse the entire input array once,
    // and each point will be pushed into the max heap (size k) once where N = size of the input array and K = size of the max heap.

    //The space complexity of the above code is O(K) since we’re maintaining a max heap of maximum size k.
    public static int[][] kClosestByPriorityQueue(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((point1, point2) -> point2[0] * point2[0] + point2[1] * point2[1] - point1[0] * point1[0] - point1[1] * point1[1]);
        System.out.println("kClosestByPriorityQueue pq " + pq );
        for (int[] point : points) {
          //  System.out.println("point " + Arrays.toString(point));
            pq.offer(point);
            if (pq.size() > k) {
              int[] poll  =   pq.poll();
                System.out.println("poll " + poll.toString());
            }
        }
        int[][] ans = new int[k][2];
        while (k > 0) {
            ans[--k] = pq.poll();
        }
        return ans;
    }

    public static int[][] kClosestByPriorityQueue1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((point1, point2) -> point1[0] * point1[0] + point1[1] * point1[1] - point2[0] * point2[0] - point2[1] * point2[1]);

        for (int[] point : points) {
            System.out.println("point " + Arrays.toString(point));
            pq.offer(point);
//            if (pq.size() > k) {
//                int[] poll  =   pq.poll();
//                System.out.println("poll " + poll.toString());
//            }
        }



        int[][] ans = new int[k][2];
        int i= 0;
        while (i< k) {
            ans[i++] = pq.poll();
            System.out.println("Ara " + Arrays.deepToString(ans));
        }

//        for(int i=0; i< k; i++){
//            ans[k++] = pq.poll();
//        }
        return ans;
    }


}
