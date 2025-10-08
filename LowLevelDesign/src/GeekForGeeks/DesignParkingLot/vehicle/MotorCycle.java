package GeekForGeeks.DesignParkingLot.vehicle;

import GeekForGeeks.DesignParkingLot.ParkingTicket;

public class MotorCycle extends Vehicle {
    public MotorCycle(String licenseNumber) {
        super(licenseNumber);
    }

    @Override
    public void assignTicket(ParkingTicket ticket) {
        System.out.println("Assigning Ticket to MotorCycle: " + getLicenseNumber());
    }


}
