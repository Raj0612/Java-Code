package Test.InterfaceTest.Test1;

import DesignPatterns.Creational.Builder.meal.packaging.Packing;

//To Test by implementing in Abstract class and normal class.
public interface Item {

    public String name();
    public Packing packing();
    public float price();
}
