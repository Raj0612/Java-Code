package DesignPatterns.Creational.Singleton.test;


import DesignPatterns.Creational.Singleton.DateUtilLazyInitialization;

public class DateUtilLazyInitializationTest {

    public static void main(String[] args) {
        DateUtilLazyInitialization dateUtil = DateUtilLazyInitialization.getInstance();
        DateUtilLazyInitialization dateUtil1 = DateUtilLazyInitialization.getInstance();

        System.out.println("dateUtil " + dateUtil);
        System.out.println("dateUtil1 " + dateUtil1);
    }
}
