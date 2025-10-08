package DesignPatterns.Creational.AbstractFactory.Medium.furniture.factories;

import DesignPatterns.Creational.AbstractFactory.Medium.furniture.products.*;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
