package DesignPatterns.Creational.Builder.computer;


public class Client {
    public static void main(String[] args) {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").bluetoothEnabled(true).build();


        System.out.println("BlueTooth " + comp.isBluetoothEnabled());
        System.out.println("Graphics " + comp.isGraphicsCardEnabled());
    }
}
