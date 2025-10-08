package DesignPatterns.Creational.Builder.meal.burger;

import DesignPatterns.Creational.Builder.meal.item.Burger;

public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
