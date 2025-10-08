package DesignPatterns.Creational.FactoryMethod.Dish;

public class Client {
    public static void main(String[] args) {
        // Order a pizza using the PizzaFactory
        DishFactory pizzaFactory = new PizzaFactory();
        ObjectCreator objectCreator = new  ObjectCreator(pizzaFactory);
        Dish pizza= objectCreator.getDish();
      //  Dish pizza = pizzaFactory.createDish();
        pizza.prepare();
        pizza.serve();

        // Order sushi using the SushiFactory
        DishFactory sushiFactory = new SushiFactory();
        Dish sushi = sushiFactory.createDish();
        sushi.prepare();
        sushi.serve();
    }
}
