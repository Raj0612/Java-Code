package com.multithreading;
class Book2 {
    // tickets is static so all book objects have the same ticket count
    static int tickets = 1;
    static synchronized void book(int request, String name) {
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
class myThread2 extends Thread {
    Book2 obj;
    int n;
    String name;
    myThread2(Book2 obj, String name, int n) {
        this.obj = obj;
        this.n = n;
        this.name = name;
    }
    public void run() {
        obj.book(n, name);
    }
}
public class SynchronizationStatic {
    public static void main(String[] args){
        Book2 obj = new Book2();
        myThread2 t1 = new myThread2(obj, "Shubham", 1);
        myThread2 t2 = new myThread2(obj, "Sharmistha", 1);

        t1.start();
        t2.start();
    }
}
