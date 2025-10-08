package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.product1;

public class Client {

    public static void main(String[] args) {
            Creator creatorA = new ConcreteCreatorA();
            Product productA = creatorA.factoryMethod();
            productA.display();

            Creator creatorB = new ConcreteCreatorB();
            Product productB = creatorB.factoryMethod();
            productB.display();
    }
}
