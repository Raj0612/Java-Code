package Educative.ParkingLot.vehicles;

public class Truck extends Vehicle {
    public Truck(String licenseNo) {
        super(licenseNo);
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
