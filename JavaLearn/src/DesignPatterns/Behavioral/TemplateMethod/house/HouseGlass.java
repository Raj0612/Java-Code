package DesignPatterns.Behavioral.TemplateMethod.house;

public class HouseGlass extends HouseTemplate{
    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}
