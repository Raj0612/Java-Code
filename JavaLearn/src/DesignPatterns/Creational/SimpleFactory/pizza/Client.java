package DesignPatterns.Creational.SimpleFactory.pizza;

public class Client {
    public static void main(String[] args) {

        PizzaStore store = new PizzaStore();
        store.orderPizzaFromPizzaStore("Veg");
        System.out.println();
        store.orderPizzaFromPizzaFactory("Chicken");

    }
}
