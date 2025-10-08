package LowLevelDesign.GeekForGeeks.DesignParkingLot.vehicle;

import LowLevelDesign.GeekForGeeks.DesignParkingLot.ParkingTicket;

public abstract class Vehicle {

    private String licenseNumber;

    public Vehicle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public abstract void assignTicket(ParkingTicket ticket);

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
