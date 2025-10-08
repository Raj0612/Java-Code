package Test.InterfaceTest.Test1;

import DesignPatterns.Creational.Builder.meal.packaging.Packing;

public class Client {

    public static void main(String[] args) {

        TestClass cls = new TestClass();
        AbstractTest at = new AbstractTest() {
            @Override
            public String name() {
                return null;
            }

            @Override
            public Packing packing() {
                return null;
            }

            @Override
            public float price() {
                return 0;
            }
        };
    }
}
