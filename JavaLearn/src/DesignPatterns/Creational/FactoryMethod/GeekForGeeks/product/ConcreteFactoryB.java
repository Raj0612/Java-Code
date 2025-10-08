package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product;

public class ConcreteFactoryB implements Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
