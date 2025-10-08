package DesignPatterns.Creational.FactoryMethod.Dish;

public class SushiFactory implements DishFactory {
    @Override
    public Dish createDish() {
        return new Sushi();
    }
}
