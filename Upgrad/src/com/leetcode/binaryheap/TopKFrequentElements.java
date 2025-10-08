package com.leetcode.binaryheap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        input1();
       // input2();
    }

    //Time - O(n) + O(xlogx)
    static int[] topKFrequentByMap(int[] nums, int k){

        int result[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        System.out.println("topKFrequent map " + map);
        ArrayList<Info> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int key = en.getKey();
            int value = en.getValue();

            Info info = new Info(key, value);
            list.add(info);
        }

        Collections.sort(list, new SortMapByValue()); //O(xlogx)
        System.out.println("list " + list);

        for(int j =0 ; j<k; j++){ //O(k)
             result[j] = list.get(j).key;
        }
        System.out.println("result " + Arrays.toString(result));
        return result;
    }


    static int[] topKFrequentByPriorityQueue(int[] nums, int k){
        int result[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        System.out.println("topKFrequentByPriorityQueue map " + map);
        PriorityQueue<Info> pq = new
                PriorityQueue<Info>(new SortMapByValue());
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int key = en.getKey();
            int value = en.getValue();

            Info info = new Info(key, value);
            pq.add(info);
        }
        System.out.println("topKFrequentByPriorityQueue pq " + pq);
        for(int j =0 ; j<k; j++){ //O(k)
            Info info = pq.poll();
            result[j] = info.key;
        }

        return result;
    }

    static int[] topKFrequentByMap1(int[] nums, int k){
        int result[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        System.out.println("topKFrequentByMap1 map " + map);

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        while (k >0){
            result[--k] = entryList.get(k).getKey();
        }

        return result;
    }

    static void input1(){
        int nums[] = {1,2,2,3,3,3};
        int k = 2;
        System.out.println("input1 " + Arrays.toString(nums) + " k " + k);
        //System.out.println("input1 : topKFrequentByMap result " + Arrays.toString(topKFrequentByMap(nums, k)));
       // System.out.println("input1 : topKFrequentByMap1 result " + Arrays.toString(topKFrequentByMap1(nums, k)));
        System.out.println("input1 : topKFrequentByPriorityQueue result " + Arrays.toString(topKFrequentByPriorityQueue(nums, k)));
    }

    static void input2(){
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        System.out.println("input2 " + Arrays.toString(nums) + " k " + k);
        System.out.println("input2 : topKFrequentByMap result " + Arrays.toString(topKFrequentByMap(nums, k)));
        System.out.println("input2 : topKFrequentByPriorityQueue result " + Arrays.toString(topKFrequentByPriorityQueue(nums, k)));
    }

}
class Info{
    int key;
    int value;

    @Override
    public String toString() {
        return "Info{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public Info(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class SortMapByValue implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return  o2.value - o1.value;
    }
}
