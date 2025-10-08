package DesignPatterns.Structural.Flyweight.coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeFactory {
    protected static List<Coffee> coffeeList = new ArrayList<Coffee>();

    public static Coffee makeCoffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
        Coffee coffee = new Coffee(flavourName, latteArt);
        System.out.printf("Making '%s' with Latte Art '%s'.\n", coffee.getFlavourName(), coffee.getLatteArt());
        coffeeList.add(coffee);
        return coffee;
    }

    public static int getNumberOfCoffee() {
        return coffeeList.size();
    }
}
