package DesignPatterns.Creational.Builder.meal.item;

import DesignPatterns.Creational.Builder.meal.packaging.Packing;
import DesignPatterns.Creational.Builder.meal.packaging.Wrapper;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
