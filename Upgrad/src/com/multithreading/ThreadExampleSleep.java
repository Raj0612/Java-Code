package com.multithreading;

class ThreadClass11 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<100){
            System.out.println("Thread Class 1");
            i++;
        }
    }
}


class ThreadClass12 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<100){
            System.out.println("Thread Class 2");
            i++;
        }
    }
}
public class ThreadExampleSleep {

    public static void main(String[] args) {
        ThreadClass11 tc1 = new ThreadClass11();
        ThreadClass12 tc2 = new ThreadClass12();
        Thread t1 = new Thread(tc1);
        Thread t2 = new Thread(tc2);
        t1.start();
        t2.start();
    }
}
