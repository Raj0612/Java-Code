package Educative.CarRentalSyatem.vehicle;

import Educative.CarRentalSyatem.enums.*;

public class Truck extends Vehicle {
    private TruckType truckType;

    public Truck() {
    }

    public Truck(String vehicleId, String licensePlateNumber, int passengerCapacity,
                 VehicleStatus status, String model, int manufacturingYear, TruckType truckType) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.truckType = truckType;
    }

    public TruckType getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckType truckType) {
        this.truckType = truckType;
    }
}
