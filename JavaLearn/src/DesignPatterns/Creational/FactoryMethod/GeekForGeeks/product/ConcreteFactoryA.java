package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product;

public class ConcreteFactoryA implements Factory{
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
