package DesignPatterns.Structural.Decorator.pizza;

public class PizzaVegDecorator extends PizzaDecorator{
    public PizzaVegDecorator(Pizza pizza) {
        super(pizza);
    }

    public void bake(){
        super.bake();
        System.out.println("Adding Veg Topping");
    }
}
