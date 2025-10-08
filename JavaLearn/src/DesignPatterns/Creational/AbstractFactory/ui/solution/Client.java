package DesignPatterns.Creational.AbstractFactory.ui.solution;

public class Client {
    public static void main(String[] args) {


        UIAbstractFactory abstractFactory;

        String os = "Windows";
        if("Windows".equals(os))
            abstractFactory  = new WindowsFactory();
        else
            abstractFactory  = new MacFactory();

        Application app = new Application(abstractFactory);
        app.paint();

    }
}
