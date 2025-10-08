package Educative.ParkingLot.vehicles;

import Educative.ParkingLot.features.ParkingTicket;

public abstract class Vehicle {
    private final String licenseNo;
    private ParkingTicket ticket;

    public Vehicle(String licenseNo) {
        this.licenseNo = licenseNo;
        this.ticket = null;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public abstract String getType();
}
