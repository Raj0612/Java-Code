package DesignPatterns.Creational.Builder.Computer1;

public class Client {

    public static void main(String[] args) {

        Computer computer = new ComputerBuilder("Test", "2GB").setGraphicsCardEnabled(true).build();

        System.out.println("Computer " + computer);
    }
}
