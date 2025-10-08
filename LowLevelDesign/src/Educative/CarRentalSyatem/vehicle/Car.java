package Educative.CarRentalSyatem.vehicle;

import Educative.CarRentalSyatem.enums.*;

public class Car extends Vehicle {
    private CarType carType;

    public Car() {
    }

    public Car(String vehicleId, String licensePlateNumber, int passengerCapacity,
               VehicleStatus status, String model, int manufacturingYear, CarType carType) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
