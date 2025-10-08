package DesignPatterns.Creational.Builder.meal.colddrink;

import DesignPatterns.Creational.Builder.meal.item.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
