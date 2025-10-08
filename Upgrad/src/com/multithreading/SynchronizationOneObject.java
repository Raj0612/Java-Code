package com.multithreading;
class Book1 {
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
class myThread1 extends Thread {
    Book1 obj;
    int n;
    String name;
    myThread1(Book1 obj, String name, int n) {
        this.obj = obj;
        this.n = n;
        this.name = name;
    }
    public void run() {
        obj.book(n, name);
    }
}
public class SynchronizationOneObject {
    public static void main(String[] args){
        Book1 obj = new Book1();
        myThread1 t1 = new myThread1(obj, "Shubham", 1);
        myThread1 t2 = new myThread1(obj, "Sharmistha", 1);

        t1.start();
        t2.start();
    }
}
