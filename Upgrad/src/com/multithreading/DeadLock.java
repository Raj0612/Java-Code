package com.multithreading;


class Util {
    static void sleep(long millis) {
        try  {
            System.out.println("sleep " + Thread.currentThread().getName());
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread1 extends Thread {
    private Shared s1;
    private Shared s2;

    public Thread1(Shared s1, Shared s2)  {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        s1.test1(s2);
    }
}


class Thread2 extends Thread {
    private Shared s1;
    private Shared s2;

    public Thread2(Shared s1, Shared s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        // taking object lock of s2  enters into test2 method
        s2.test1(s1);
    }
}

class Shared {
    // first synchronized method
    synchronized void test1(Shared s2) {
        System.out.println("test1-begin " + Thread.currentThread().getName());
        Util.sleep(1000);
        System.out.println("test1-after Sleep " + Thread.currentThread().getName());
        // taking object lock of s2 enters into test2 method
        s2.test2();
        System.out.println("test1-end");
    }

    synchronized void test2()  {
        System.out.println("test2-begin  " + Thread.currentThread().getName());
        Util.sleep(1000);
        // taking object lock of s1 enters into test1 method
        System.out.println("test2-end");
    }
}
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Shared s1 = new Shared();
        Shared s2 = new Shared();

        // creating first thread and starting it

        Thread1 t1 = new Thread1(s1, s2);
        Thread2 t2 = new Thread2(s1, s2);
        Thread thread1 = new Thread(t1,"Thread1");
        Thread thread2 = new Thread(t2,"Thread2");
        thread1.start();
       // t1.join();
        // creating second thread and starting it

        thread2.start();

        // sleeping main thread
       // Util.sleep(2000);
    }
}
