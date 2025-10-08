package DesignPatterns.Structural.Flyweight.baeldung;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    private static Map<Color, Vehicle> vehiclesCache
            = new HashMap<>();
    public VehicleFactory() {
    }

    public static Vehicle createVehicle(Color color) {
        // Looks for the requested vehicle into the cache.
        // If the vehicle doesn't exist, a new one is created.
        Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor -> {
            // Creates the new car.
            Engine newEngine = new Engine();
            return new Car(newEngine, newColor);
        });
        return newVehicle;
    }
}
