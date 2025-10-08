package Educative.ParkingLot.parkingspots;

import Educative.ParkingLot.vehicles.*;

public class Compact extends ParkingSpot {

    public Compact(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree()  && (vehicle instanceof Car || vehicle instanceof MotorCycle)) {
            setVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String getSpotType() {
        return "Compact";
    }
}
