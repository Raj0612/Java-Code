package com.multithreading;

import java.util.Scanner;

class GeeksForGeeks extends Thread {
    private String mssg;

    GeeksForGeeks(String mssg) {
        this.mssg = mssg;
    }

    public void run() {
        while (TakeInputPrintConsole.start == true) {
            System.out.println(this.mssg);
            try {
                Thread.sleep(1500);
            }
            catch (Exception err) {
            }
        }
    }
}

class GeeksForGeeks1 {
    private String mssg;

    GeeksForGeeks1(String mssg) {
        this.mssg = mssg;
    }

    public void print() {
        while (TakeInputPrintConsole.start == true) {
            System.out.println(this.mssg);
            try {
                Thread.sleep(5000);
                System.out.println("TakeInputPrintConsole.start " + TakeInputPrintConsole.start);
            }
            catch (Exception err) {
            }
        }
    }
}

public class TakeInputPrintConsole {
    public static boolean start = true;
    public static void main(String args[]) {
        //Will do continuous print wont stop
        //GeeksForGeeks1 gfg = new GeeksForGeeks1("I Love GFG wthout Thread!");
        //gfg.print();

        GeeksForGeeks newThread = new GeeksForGeeks("I Love GFG!");
        newThread.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("TakeInputPrintConsole.start before" + TakeInputPrintConsole.start);
        TakeInputPrintConsole.start = false;
        System.out.println("TakeInputPrintConsole.start after " + TakeInputPrintConsole.start);

    }
}
