package DesignPatterns.Behavioral.TemplateMethod.house;

public class Client {

    public static void main(String[] args) {
        HouseTemplate template = new HouseGlass();
        template.buildHouse();
    }
}
