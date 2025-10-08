package Educative.ParkingLot.designpatterns;

import Educative.ParkingLot.parkingspots.*;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(String type, int id) {
        return switch (type.toLowerCase()) {
            case "handicapped" -> new Handicapped(id);
            case "compact" -> new Compact(id);
            case "large" -> new Large(id);
            case "motorcycle" -> new MotorCycleSpot(id);
            default -> throw new IllegalArgumentException("Unknown parking spot type");
        };

//        switch (type.toLowerCase()) {
//            case "handicapped": return new Handicapped(id);
//            case "compact": return new Compact(id);
//            case "large": return new Large(id);
//            case "motorcycle": return new MotorCycleSpot(id);
//            default: throw new IllegalArgumentException("Unknown parking spot type");
//        }
    }
}
