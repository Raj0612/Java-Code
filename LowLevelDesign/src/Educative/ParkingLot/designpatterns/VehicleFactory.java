package Educative.ParkingLot.designpatterns;

import Educative.ParkingLot.vehicles.*;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String licenseNo) {
//        switch (type.toLowerCase()) {
//            case "car": return new Car(licenseNo);
//            case "van": return new Van(licenseNo);
//            case "truck": return new Truck(licenseNo);
//            case "motorcycle": return new MotorCycle(licenseNo);
//            default: throw new IllegalArgumentException("Unknown vehicle type");
//        }

        return switch (type.toLowerCase()) {
            case "car" -> new Car(licenseNo);
            case "van" -> new Van(licenseNo);
            case "truck" -> new Truck(licenseNo);
            case "motorcycle" -> new MotorCycle(licenseNo);
            default -> throw new IllegalArgumentException("Unknown vehicle type");
        };
    }
}
