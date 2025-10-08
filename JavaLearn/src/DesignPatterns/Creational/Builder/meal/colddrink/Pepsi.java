package DesignPatterns.Creational.Builder.meal.colddrink;

import DesignPatterns.Creational.Builder.meal.item.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
