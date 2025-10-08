package DesignPatterns.Structural.Decorator.GeekForGeeks;

public class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", cheese";
    }

    @Override
    public double cost() {
        return decoratedPizza.cost() + 1.5; // Cost of cheese topping
    }
}
