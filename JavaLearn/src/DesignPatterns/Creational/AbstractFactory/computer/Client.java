package DesignPatterns.Creational.AbstractFactory.computer;

public class Client {

    public static void main(String[] args) {

        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));

        ComputerAbstractFactory pcFactory = new PCFactory("4 GB","600 GB","1.4 GHz");
        Computer pc1 = pcFactory.createComputer();

    }
}
