package DesignPatterns.Behavioral.TemplateMethod.Beverage;

public class TeaMaker extends  BeverageMaker{

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
