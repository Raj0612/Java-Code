package DesignPatterns.Structural.Flyweight.coffee;

import java.util.ArrayList;

public class CoffeeShop {
    private static final ArrayList<Order> orders = new ArrayList<>();

    public void takeOrder(CoffeeFlavour flavourName, CoffeeLatteArt latteArt, int tableNumber) {
        orders.add(Order.create(flavourName, latteArt, tableNumber));
    }

    public static int getNumberOfOrders() {
        return orders.size();
    }
}
