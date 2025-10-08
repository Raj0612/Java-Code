package Educative.ParkingLot.parkingspots;

import Educative.ParkingLot.vehicles.Vehicle;

public abstract class ParkingSpot {

    private int id;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(int id) {
        this.id = id;
        this.isFree = true;
        this.vehicle = null;
    }
    public abstract boolean assignVehicle(Vehicle vehicle);

    public abstract String getSpotType();

    public boolean removeVehicle() {
        if (vehicle != null) {
            vehicle = null;
            isFree = true;
            return true;
        }
        return false;
    }

    protected void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = (vehicle == null);
    }
    public int getId() {
        return id;
    }

    public boolean isFree() {
        return isFree;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
