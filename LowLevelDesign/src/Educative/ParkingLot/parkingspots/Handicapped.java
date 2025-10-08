package Educative.ParkingLot.parkingspots;

import Educative.ParkingLot.vehicles.Vehicle;

public class Handicapped extends ParkingSpot {
    public Handicapped(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree() && vehicle != null) {
            setVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String getSpotType() {
        return "Handicapped";
    }
}