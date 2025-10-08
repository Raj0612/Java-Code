package com.multithreading;

class Book {
    // tickets is static so all book objects have the same ticket count
    static int tickets = 1;
    synchronized void book(int request, String name) {
        if (tickets >= request) {
            System.out.println(name + " booked " + request
                    + " ticket.");
            tickets = tickets - 1;
            System.out.println("Tickets left: " + tickets);
        }
        else {
            System.out.println("No tickets are available.");
        }
    }
}
class myThread extends Thread {
    Book obj;
    int n;
    String name;
    myThread(Book obj, String name, int n) {
        this.obj = obj;
        this.n = n;
        this.name = name;
    }
    public void run() {
        obj.book(n, name);
    }
}
public class SynchronizationCons {
    public static void main(String[] args){
        Book obj = new Book();
        Book obj2 = new Book();
        myThread t1 = new myThread(obj, "Shubham", 1);
        myThread t2 = new myThread(obj2, "Sharmistha", 1);

        t1.start();
        t2.start();
    }
}
