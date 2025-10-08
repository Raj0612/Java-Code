package DesignPatterns.Creational.Builder.meal.item;

import DesignPatterns.Creational.Builder.meal.packaging.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
