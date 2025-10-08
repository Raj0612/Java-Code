package DesignPatterns.Structural.Decorator.pizza;

public class Client {

    public static void main(String[] args) {

        Pizza pizza = new PizzaPlain();
        pizza.bake();

        System.out.println("");
        System.out.println("****Cheese Decorator****");
        Pizza pizza1 = new PizzaCheeseDecorator(new PizzaPlain());
        pizza1.bake();

        System.out.println("");
        System.out.println("*****Cheese And Veg Decorator*****");
        Pizza pizza2 = new PizzaCheeseDecorator(new PizzaVegDecorator(new PizzaPlain()));
        pizza2.bake();

    }
}
