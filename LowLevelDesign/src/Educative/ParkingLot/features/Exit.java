package Educative.ParkingLot.features;

import Educative.ParkingLot.enums.TicketStatus;
import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.payments.*;
import Educative.ParkingLot.system.ParkingLot;

import java.time.LocalDateTime;
import java.util.Random;
@SuppressWarnings("ClassCanBeRecord")
public class Exit {
    private final int id;

    public Exit(int id) {
        this.id = id;
    }

    public void validateTicket(ParkingTicket ticket) {
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return;
        }
        if (ticket.getStatus() == TicketStatus.PAID || ticket.getStatus() == TicketStatus.CANCELED) {
            System.out.println("Ticket already processed.");
            return;
        }
        ticket.setExitTime(LocalDateTime.now());
        double durationHours = (double) java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes() / 60.0;
        double amount = ParkingLot.getInstance().getParkingRate().calculate(durationHours, ticket.getVehicle(), ticket.getParkingSpot());
        ticket.setAmount(amount);

        // Payment strategy: For demo, randomly choose payment method
        Payment payment;
        if (new Random().nextBoolean()) {
            payment = new Cash(amount);
        } else {
            payment = new CreditCard(amount);
        }
        ticket.setPayment(payment);
        boolean paymentSuccess = payment.initiateTransaction();
        if (paymentSuccess) {
            ticket.setStatus(TicketStatus.PAID);
            ParkingSpot spot = ticket.getParkingSpot();
            spot.removeVehicle();
            System.out.println("Payment successful. Vehicle " + ticket.getVehicle().getLicenseNo() + " exited.");
        } else {
            ticket.setStatus(TicketStatus.FAILED);
            System.out.println("Payment failed. Please retry.");
        }
    }

    public int getId() {
        return id;
    }
}
