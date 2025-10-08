package Educative.ParkingLot.system;

import Educative.ParkingLot.accounts.Address;
import Educative.ParkingLot.features.*;
import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.vehicles.Vehicle;

import java.util.*;

public class ParkingLot {
    private int id;
    private String name;
    private Address address;
    private ParkingRate parkingRate;

    private Map<String, Entrance> entrances;
    private Map<String, Exit> exits;
    private Map<Integer, ParkingSpot> spots;
    private Map<Integer, ParkingTicket> tickets;
    private List<DisplayBoard> displayBoards;

    private static ParkingLot parkingLot = null;
    private int ticketCounter = 0;

    private ParkingLot() {
        entrances = new HashMap<>();
        exits = new HashMap<>();
        spots = new HashMap<>();
        tickets = new HashMap<>();
        displayBoards = new ArrayList<>();
        parkingRate = new ParkingRate(1, 10); // $10 per hour default
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean addEntrance(Entrance entrance) {
        if (entrance == null) return false;
        entrances.put(String.valueOf(entrance.getId()), entrance);
        return true;
    }

    public boolean addExit(Exit exit) {
        if (exit == null) return false;
        exits.put(String.valueOf(exit.getId()), exit);
        return true;
    }

    public boolean addParkingSpot(ParkingSpot spot) {
        if (spot == null) return false;
        spots.put(spot.getId(), spot);
        return true;
    }

    public boolean addDisplayBoard(DisplayBoard board) {
        if (board == null) return false;
        displayBoards.add(board);
        return true;
    }

    public ParkingRate getParkingRate() {
        return parkingRate;
    }

    public Map<Integer, ParkingSpot> getAllSpots() {
        return spots;
    }

    public int generateTicketNumber() {
        return ++ticketCounter;
    }

    public void addTicket(ParkingTicket ticket) {
        if (ticket != null) {
            tickets.put(ticket.getTicketNo(), ticket);
        }
    }

    public ParkingSpot findAvailableSpotForVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots.values()) {
            if (spot.isFree()) {
                // Check if spot can accommodate vehicle type
                if (spot.assignVehicle(vehicle)) {
                    // Undo assignment here, just check availability
                    spot.removeVehicle();
                    return spot;
                }
            }
        }
        return null;
    }

    public boolean isFull() {
        for (ParkingSpot spot : spots.values()) {
            if (spot.isFree()) return false;
        }
        return true;
    }
}
