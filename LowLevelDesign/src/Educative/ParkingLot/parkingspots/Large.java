package Educative.ParkingLot.parkingspots;

import Educative.ParkingLot.vehicles.*;

public class Large extends ParkingSpot {
    public Large(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree()  && (vehicle instanceof Truck || vehicle instanceof Van || vehicle instanceof Car)) {
            setVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String getSpotType() {
        return "Large";
    }
}
