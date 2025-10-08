package com.multithreading;

class ThreadClass1 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println("Thread Class 1");
            i++;
        }
    }
}


class ThreadClass2 extends  Thread{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println("Thread Class 2");
            i++;
        }
    }
}


public class ThreadExample{

    public static void main(String[] args) {
        ThreadClass1 tc1 = new ThreadClass1();
        ThreadClass2 tc2 = new ThreadClass2();
        Thread t1 = new Thread(tc1, "Thread1");
        Thread t2 = new Thread(tc2);
        System.out.println("Thread Name " + t1.getName());
        t1.start();
        t2.start();
    }
}


