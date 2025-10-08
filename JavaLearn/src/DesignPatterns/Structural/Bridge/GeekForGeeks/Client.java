package DesignPatterns.Structural.Bridge.GeekForGeeks;


public class Client {
    public static void main(String[] args) {
        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();
        Vehicle bike = new Bike(new Produce(), new Assemble());
        bike.manufacture();
    }
}
