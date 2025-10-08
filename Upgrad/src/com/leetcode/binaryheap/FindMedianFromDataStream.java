package com.leetcode.binaryheap;

//The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
/*
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 */
/*Implement the MedianFinder class:
#) MedianFinder() initializes the MedianFinder object.
#) void addNum(int num) adds the integer num from the data stream to the data structure.
#) double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
/*
Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap to store the larger half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        input1();
//        FindMedianFromDataStream obj = new FindMedianFromDataStream();
//        obj.addNum(1);
//        obj.addNum(2);
//        System.out.println(obj.findMedian());
//        obj.addNum(3);
//        System.out.println(obj.findMedian());

    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll()); // Balance the heaps by moving the smallest number of min-heap to max-heap

        // Ensure max-heap has equal or one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move the maximum number of max-heap to min-heap
        }
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            // If max-heap has more elements, the median is the top of the max-heap
            return maxHeap.peek();
        }
        // Otherwise, the median is the average of the tops of both heaps
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    //Using Insertion SOrt
    static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();
        res.add((double) arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int num = arr[i];
            while (j >= 0 && arr[j] > num) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = num;

            int len = i + 1;
            double median;
            if (len % 2 != 0) {
                median = arr[len / 2];
            } else {
                median = (arr[(len / 2) - 1] + arr[len / 2]) / 2.0;
            }

            res.add(median);
        }
        return res;
    }

    static void input1(){
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);

        for (int i = 0; i < res.size(); i++) {
            System.out.printf("%.2f ", res.get(i));
        }
    }
}
