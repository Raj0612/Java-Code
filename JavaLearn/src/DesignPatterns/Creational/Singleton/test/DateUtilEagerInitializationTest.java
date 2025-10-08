package DesignPatterns.Creational.Singleton.test;


import DesignPatterns.Creational.Singleton.DateUtilEagerInitialization;

public class DateUtilEagerInitializationTest {

    public static void main(String[] args) {
        DateUtilEagerInitialization dateUtil = DateUtilEagerInitialization.getInstance();
        DateUtilEagerInitialization dateUtil1 = DateUtilEagerInitialization.getInstance();

        System.out.println("dateUtil " + dateUtil);
        System.out.println("dateUtil1 " + dateUtil1);

      //  System.out.println("" + DateUtilEagerInitialization.instance);
    }
}
