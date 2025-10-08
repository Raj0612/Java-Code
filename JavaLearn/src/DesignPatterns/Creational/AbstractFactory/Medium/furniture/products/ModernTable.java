package DesignPatterns.Creational.AbstractFactory.Medium.furniture.products;

public class ModernTable implements Table {
    @Override
    public void use() {
        System.out.println("Using a modern table!");
    }
}