package DesignPatterns.Creational.AbstractFactory.Medium.furniture;

import DesignPatterns.Creational.AbstractFactory.Medium.furniture.factories.*;
import DesignPatterns.Creational.AbstractFactory.Medium.furniture.products.*;

public class Client {
    public static void main(String[] args) {
        // Create modern furniture using the ModernFurnitureFactory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();

        // Use the modern furniture
        modernChair.sitOn();
        modernTable.use();

        // Create Victorian furniture using the VictorianFurnitureFactory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();

        // Use the Victorian furniture
        victorianChair.sitOn();
        victorianTable.use();
    }
}
