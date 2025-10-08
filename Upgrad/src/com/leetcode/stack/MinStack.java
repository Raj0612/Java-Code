package com.leetcode.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack2, stack1;

    public MinStack(){
        stack2 = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int val){
        stack1.push(val);
        if(stack2.empty())
            stack2.push(val);
        else{
            if(stack2.peek() <=val){
                stack2.push(stack2.peek());
            }else{
                stack2.push(val);
            }
        }
    }

    public void pop(){
       stack1.pop();
       stack2.pop();
    }
    public  int top(){
        return stack1.peek();
    }

    public int getMin(){
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(8);
        stack.push(6);
        stack.push(9);
        stack.push(5);
        System.out.println("min " + stack.getMin());
    }
}
