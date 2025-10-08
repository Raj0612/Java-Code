package Educative.ParkingLot.vehicles;


public class MotorCycle extends Vehicle {
    public MotorCycle(String licenseNo) {
        super(licenseNo);
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}
