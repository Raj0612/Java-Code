package com.multithreading;

class ThreadClass21 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<20){
            System.out.println("Thread Class 1");
            i++;
        }
    }
}


class ThreadClass22 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<20){
            System.out.println("Thread Class 2");
            i++;
        }
    }
}
public class ThreadExampleYield {
    public static void main(String[] args) {
        ThreadClass21 tc1 = new ThreadClass21();
        ThreadClass22 tc2 = new ThreadClass22();
        Thread t1 = new Thread(tc1);
        Thread t2 = new Thread(tc2);
        t1.start();
        t2.start();
    }
}
