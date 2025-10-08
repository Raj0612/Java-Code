package com.leetcode.stack;

import java.util.ArrayList;

class MinStack1 {

    ArrayList<Integer> list;
    public MinStack1(){
        list = new ArrayList<>();

    }
    public void push(int val){
        list.add(val);
    }
    public void pop(){
        list.remove(list.size()-1);
    }
    public  int top(){
        return list.get(list.size()-1);
    }
    public int getMin(){
        int min = list.get(0);
        for(int i=1; i<list.size();i++){
            min = Math.min(min, list.get(i));
        }
        return min;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}

public class MinStackMain{
    public static void main(String[] args) {
        MinStack1 stack = new MinStack1();
        stack.push(8);
        stack.push(6);
        stack.push(9);
        stack.push(5);
        System.out.println("min " + stack.getMin());
    }

}