package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product1;

public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
