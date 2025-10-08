package Educative.CarRentalSyatem.vehicle;

import Educative.CarRentalSyatem.enums.*;

public class Motorcycle extends Vehicle {
    private MotorcycleType motorcycleType;

    public Motorcycle() {
    }

    public Motorcycle(String vehicleId, String licensePlateNumber, int passengerCapacity,
                      VehicleStatus status, String model, int manufacturingYear, MotorcycleType motorcycleType) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.motorcycleType = motorcycleType;
    }

    public MotorcycleType getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(MotorcycleType motorcycleType) {
        this.motorcycleType = motorcycleType;
    }
}
