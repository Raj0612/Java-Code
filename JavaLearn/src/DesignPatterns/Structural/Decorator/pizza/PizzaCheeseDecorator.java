package DesignPatterns.Structural.Decorator.pizza;

public class PizzaCheeseDecorator extends PizzaDecorator{
    public PizzaCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public void bake(){
        super.bake();
        System.out.println("Adding Cheese Topping");
    }
}
