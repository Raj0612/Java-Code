package DesignPatterns.Creational.AbstractFactory.Medium.furniture.factories;

import DesignPatterns.Creational.AbstractFactory.Medium.furniture.products.Chair;
import DesignPatterns.Creational.AbstractFactory.Medium.furniture.products.Table;

public interface FurnitureFactory {

    Chair createChair();
    Table createTable();
}
