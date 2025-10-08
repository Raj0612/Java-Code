package GeekForGeeks.DesignParkingLot;


import GeekForGeeks.DesignParkingLot.payment.CashPayment;
import GeekForGeeks.DesignParkingLot.payment.Payment;
import GeekForGeeks.DesignParkingLot.vehicle.Car;
import GeekForGeeks.DesignParkingLot.vehicle.Vehicle;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Central Parking", "123 Main st");

        Vehicle car = new Car("ABC123");
        ParkingTicket ticket = parkingLot.getParkingTicket(car);
        car.assignTicket(ticket);
        System.out.println("Ticket for car " + car.getLicenseNumber() + " is " + ticket.getTicketNumber());

        Payment payment = new CashPayment(20.0);
        payment.initiateTransaction();
        ticket.setPayment(payment);
        System.out.println("Parking Ticket Processed: " + ticket.getTicketNumber());
    }
}
