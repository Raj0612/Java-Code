package Educative.CarRentalSyatem.vehicle;

import Educative.CarRentalSyatem.enums.*;

public class Van extends Vehicle {
    private VanType vanType;

    public Van() {
    }

    public Van(String vehicleId, String licensePlateNumber, int passengerCapacity,
               VehicleStatus status, String model, int manufacturingYear, VanType vanType) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.vanType = vanType;
    }

    public VanType getVanType() {
        return vanType;
    }

    public void setVanType(VanType vanType) {
        this.vanType = vanType;
    }
}
