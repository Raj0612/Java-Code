package DesignPatterns.Creational.Builder.meal;

import DesignPatterns.Creational.Builder.meal.burger.ChickenBurger;
import DesignPatterns.Creational.Builder.meal.burger.VegBurger;
import DesignPatterns.Creational.Builder.meal.colddrink.Coke;
import DesignPatterns.Creational.Builder.meal.colddrink.Pepsi;

public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
