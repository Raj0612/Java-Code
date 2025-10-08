package com.practice;
//Design a  hit counter which counts the number of hits received in the past 5 minutes.
//Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order
// (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
//It is possible that several hits arrive roughly at the same time.
/*
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);
// hit at timestamp 2.
counter.hit(2);
// hit at timestamp 3.
counter.hit(3);
// get hits at timestamp 4, should return 3.
counter.getHits(4);
// hit at timestamp 300.
counter.hit(300);
// get hits at timestamp 300, should return 4.
counter.getHits(300);
// get hits at timestamp 301, should return 3.
counter.getHits(301);
 */
import java.util.ArrayList;

public class HitCounterByArrayList {
    public ArrayList<Integer> list;
    public HitCounterByArrayList(){
        list= new ArrayList<>();
    }
    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        System.out.println("getHits v " + list + " timestamp: " + timestamp);
        int i;
        for (i = 0; i <list.size(); ++i) {
            System.out.println("getHits i:" + i + " val " + list.get(i)  + " Diff " + (timestamp -list.get(i)));
            if (timestamp -list.get(i) <300) {
                break;
            }
          /*  if (list.get(i) > timestamp - 300) {
                break;
            }*/
        }
        int result = list.size() - i;
        System.out.println("getHits timestamp " + timestamp + " result " + result);
        return result;
    }

    public static void main(String[] args) {
        HitCounterByArrayList obj = new HitCounterByArrayList();
       /* obj.hit(1);
        obj.hit(2);
        obj.hit(3);
       // obj.getHits(305);
       // obj.getHits(4);
        obj.hit(300);
        obj.getHits(300);
        obj.hit(301);
        obj.getHits(301);*/
       // obj.getHits(301);



        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
       // obj.hit(303);
        obj.getHits(303);
    }
}
