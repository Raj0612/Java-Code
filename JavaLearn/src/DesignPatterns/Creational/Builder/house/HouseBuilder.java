package DesignPatterns.Creational.Builder.house;

public interface HouseBuilder {
    public void buildBasement();

    public void buildStructure();

    public void buildRoof();

    public void buildInterior();

    public House getHouse();
}
