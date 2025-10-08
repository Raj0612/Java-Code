package DesignPatterns.Creational.Singleton.test;


import DesignPatterns.Creational.Singleton.DateUtilEnum;

public class DateUtilReflectionHandleByEnumTest {

    public static void main(String[] args) {
        DateUtilEnum instance = DateUtilEnum.INSTANCE;

        instance.setName("Raj");
        DateUtilEnum instance1 = DateUtilEnum.INSTANCE;
        System.out.println("name " + instance.getName());
        System.out.println("name1 " + instance1.getName());
    }
}
