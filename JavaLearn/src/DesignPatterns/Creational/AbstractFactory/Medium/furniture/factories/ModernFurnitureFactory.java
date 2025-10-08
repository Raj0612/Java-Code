package DesignPatterns.Creational.AbstractFactory.Medium.furniture.factories;

import DesignPatterns.Creational.AbstractFactory.Medium.furniture.products.*;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair(); // Create a modern chair
    }

    @Override
    public Table createTable() {
        return new ModernTable(); // Create a modern table
    }
}
