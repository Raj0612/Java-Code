package DesignPatterns.Creational.AbstractFactory.phone;

public class Phone {
    String description;
    public Phone(String model)
    {
        this.description = model;
    }
    public void getDescription()
    {
        System.out.println(this.description);
    }
}
