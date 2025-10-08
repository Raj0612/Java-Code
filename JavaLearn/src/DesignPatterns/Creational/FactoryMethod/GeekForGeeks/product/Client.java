package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product;

public class Client {
    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.factoryMethod();
        productA.display();

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.factoryMethod();
        productB.display();
    }
}
