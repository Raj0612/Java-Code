package Educative.ParkingLot.features;

import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.system.ParkingLot;
import Educative.ParkingLot.vehicles.*;

import java.time.LocalDateTime;
@SuppressWarnings("ClassCanBeRecord")
public class Entrance {
    private final int id;
    public Entrance(int id) {
        this.id = id;
    }
    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingLot lot = ParkingLot.getInstance();
        ParkingSpot spot = lot.findAvailableSpotForVehicle(vehicle);
        if (spot == null) {
            System.out.println("No available spot for vehicle type: " + vehicle.getType());
            return null;
        }
        boolean assigned = spot.assignVehicle(vehicle);
        if (!assigned) {
            System.out.println("Failed to assign vehicle to spot.");
            return null;
        }
        ParkingTicket ticket = new ParkingTicket(lot.generateTicketNumber(), LocalDateTime.now(), vehicle, this);
        vehicle.assignTicket(ticket);
        lot.addTicket(ticket);
        System.out.println("Ticket issued: " + ticket.getTicketNo() + " for vehicle " + vehicle.getLicenseNo() + " at spot " + spot.getId());
        return ticket;
    }
    public int getId() {
        return id;
    }
}
