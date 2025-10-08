package DesignPatterns.Behavioral.TemplateMethod.house;

public class HouseWooden extends HouseTemplate{
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
