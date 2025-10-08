package com.test;

class A{
   static int N;
    public static void increment()  {
        // this throws a compile - time error.
        N++;
    }
}
public class StaticMethodNonStaticVariable {

    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = new A();
        obj1.N = 3;
        obj2.N = 4;
        obj3.N = 5;
        A.increment();
        System.out.println(obj1.N);
        System.out.println(obj2.N);
        System.out.println(obj3.N);
    }
}
