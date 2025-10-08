package LowLevelDesign.GeekForGeeks.DesignParkingLot;

import LowLevelDesign.GeekForGeeks.DesignParkingLot.vehicle.Vehicle;

public class ParkingLot {
    private String name;
    private String address;
    private boolean isFull;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle){
        System.out.println("Generating ticket for vehicle: " + vehicle.getLicenseNumber());
        return new ParkingTicket((int) (Math.random()* 1000), System.currentTimeMillis());
    }
}
