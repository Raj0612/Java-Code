package com.knowledge;

abstract class Car {

    int x = 10;
    Car() {
        System.out.println("Car is created");
    }

    Car(String msg){
        System.out.println( msg) ;
    }
}

class Maruti extends Car {

    Maruti(){
        super("Super class Argument Constructor");
        System.out.println("Maruthi class Constructor");
    }

   /* Maruti(){
        System.out.println("Maruthi class Constructor");
    }*/
    void run() {
        System.out.println("Maruti is running");
    }
}
public class AbstractClassConstructor {
    public static void main(String[] args) {
        Maruti c = new Maruti();
        c.run();
        System.out.println("Super Class variable " + c.x);
    }
}
