package Educative.CarRentalSyatem.designpatterns;

import Educative.CarRentalSyatem.enums.*;
import Educative.CarRentalSyatem.vehicle.*;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String vehicleId, String licensePlateNumber,
                                        int passengerCapacity, VehicleStatus status,
                                        String model, int manufacturingYear, Enum<?> specificType) {
        switch (type.toUpperCase()) {
            case "CAR":
                if (specificType instanceof CarType) {
                    return new Car(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear, (CarType) specificType);
                }
                break;
            case "VAN":
                if (specificType instanceof VanType) {
                    return new Van(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear, (VanType) specificType);
                }
                break;
            case "TRUCK":
                if (specificType instanceof TruckType) {
                    return new Truck(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear, (TruckType) specificType);
                }
                break;
            case "MOTORCYCLE":
                if (specificType instanceof MotorcycleType) {
                    return new Motorcycle(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear, (MotorcycleType) specificType);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        throw new IllegalArgumentException("Invalid specific type for vehicle: " + type);
    }
}
