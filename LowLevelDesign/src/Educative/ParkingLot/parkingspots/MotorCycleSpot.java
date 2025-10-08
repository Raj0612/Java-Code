package Educative.ParkingLot.parkingspots;

import Educative.ParkingLot.vehicles.*;

public class MotorCycleSpot extends ParkingSpot {
    public MotorCycleSpot(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (isFree() && vehicle != null && vehicle instanceof MotorCycle) {
            setVehicle(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String getSpotType() {
        return "Motorcycle";
    }
}
