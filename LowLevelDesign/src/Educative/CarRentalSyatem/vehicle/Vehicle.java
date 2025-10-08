package Educative.CarRentalSyatem.vehicle;

import Educative.CarRentalSyatem.enums.VehicleStatus;
import Educative.CarRentalSyatem.features.VehicleLog;

import java.util.*;

public abstract class Vehicle {
    private String vehicleId;
    private String licensePlateNumber;
    private int passengerCapacity;
    private VehicleStatus status;
    private String model;
    private int manufacturingYear;
    private List<VehicleLog> logs = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String licensePlateNumber, int passengerCapacity,
                   VehicleStatus status, String model, int manufacturingYear) {
        this.vehicleId = vehicleId;
        this.licensePlateNumber = licensePlateNumber;
        this.passengerCapacity = passengerCapacity;
        this.status = status;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    public void reserve() {
        if (this.status == VehicleStatus.AVAILABLE) {
            this.status = VehicleStatus.RESERVED;
        }
    }

    public void returnVehicle() {
        if (this.status == VehicleStatus.RESERVED || this.status == VehicleStatus.IN_USE) {
            this.status = VehicleStatus.AVAILABLE;
        }
    }

    // Getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public List<VehicleLog> getLogs() {
        return logs;
    }

    public void addLog(VehicleLog log) {
        this.logs.add(log);
    }

    public void reserveVehicle() {
        if (this.status == VehicleStatus.AVAILABLE) {
            this.status = VehicleStatus.RESERVED;
        }
    }


}
