package DesignPatterns.Creational.Builder.meal.burger;

import DesignPatterns.Creational.Builder.meal.item.Burger;

public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
