package Educative.ParkingLot.vehicles;

public class Van extends Vehicle {
    public Van(String licenseNo) {
        super(licenseNo);
    }

    @Override
    public String getType() {
        return "Van";
    }
}
