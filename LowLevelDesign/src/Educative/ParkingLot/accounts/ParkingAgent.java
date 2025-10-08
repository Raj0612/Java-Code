package Educative.ParkingLot.accounts;
import Educative.ParkingLot.enums.TicketStatus;
import Educative.ParkingLot.system.ParkingLot;
import Educative.ParkingLot.features.*;
import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.payments.*;
import Educative.ParkingLot.vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class ParkingAgent  {
    private ParkingLot parkingLot;

    public ParkingAgent() {
        this.parkingLot = ParkingLot.getInstance();
    }

    /**
     * Handles vehicle entry: assigns a parking spot, issues a ticket.
     * @param vehicle The vehicle entering the parking lot.
     * @param entrance The entrance through which the vehicle enters.
     * @return The issued ParkingTicket or null if parking is full.
     */
    public ParkingTicket handleVehicleEntry(Vehicle vehicle, Entrance entrance) {
        if (vehicle == null || entrance == null) {
            System.out.println("Invalid vehicle or entrance.");
            return null;
        }

        if (parkingLot.isFull()) {
            System.out.println("Parking lot is full. Entry denied for vehicle: " + vehicle.getLicenseNo());
            return null;
        }

        ParkingSpot spot = parkingLot.findAvailableSpotForVehicle(vehicle);
        if (spot == null) {
            System.out.println("No suitable parking spot available for vehicle: " + vehicle.getLicenseNo());
            return null;
        }

        boolean assigned = spot.assignVehicle(vehicle);
        if (!assigned) {
            System.out.println("Failed to assign parking spot for vehicle: " + vehicle.getLicenseNo());
            return null;
        }

        int ticketNumber = parkingLot.generateTicketNumber();
        ParkingTicket ticket = new ParkingTicket(ticketNumber, LocalDateTime.now(), vehicle, entrance);
        ticket.setParkingSpot(spot);
        vehicle.assignTicket(ticket);
        parkingLot.addTicket(ticket);

        System.out.println("Ticket issued: " + ticketNumber + " for vehicle: " + vehicle.getLicenseNo() + " at spot: " + spot.getId());
        return ticket;
    }

    /**
     * Handles vehicle exit: validates ticket, calculates payment, processes payment, frees spot.
     * @param ticket The parking ticket presented at exit.
     * @param exit The exit through which the vehicle leaves.
     */
    public void handleVehicleExit(ParkingTicket ticket, Exit exit) {
        if (ticket == null || exit == null) {
            System.out.println("Invalid ticket or exit.");
            return;
        }

        if (ticket.getStatus() == TicketStatus.PAID || ticket.getStatus() == TicketStatus.CANCELED) {
            System.out.println("Ticket already processed.");
            return;
        }

        ticket.setExitIns(exit);
        ticket.setExitTime(LocalDateTime.now());

        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        double hours = duration.toMinutes() / 60.0;
        if (hours < 0) hours = 0;

        double amount = parkingLot.getParkingRate().calculate(hours, ticket.getVehicle(), ticket.getParkingSpot());
        ticket.setAmount(amount);

        // For demo, randomly select payment method
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
}
