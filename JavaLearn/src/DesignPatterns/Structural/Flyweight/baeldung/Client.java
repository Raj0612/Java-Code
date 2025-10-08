package DesignPatterns.Structural.Flyweight.baeldung;
import java.awt.Color;
public class Client {
    public static void main(String[] args) {
        Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
        Vehicle blueVehicle = VehicleFactory.createVehicle(Color.BLUE);
        blackVehicle.start();
        blueVehicle.start();
    }
}
