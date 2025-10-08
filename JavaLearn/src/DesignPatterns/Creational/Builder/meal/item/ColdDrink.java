package DesignPatterns.Creational.Builder.meal.item;

import DesignPatterns.Creational.Builder.meal.packaging.Bottle;
import DesignPatterns.Creational.Builder.meal.packaging.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
