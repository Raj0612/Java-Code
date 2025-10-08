package DesignPatterns.Creational.AbstractFactory.Medium.furniture.products;

public class VictorianTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a victorian table!");
    }
}