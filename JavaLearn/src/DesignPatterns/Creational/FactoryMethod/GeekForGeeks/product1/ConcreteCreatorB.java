package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product1;

public class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
