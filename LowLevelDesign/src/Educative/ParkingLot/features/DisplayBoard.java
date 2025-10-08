package Educative.ParkingLot.features;

import Educative.ParkingLot.parkingspots.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DisplayBoard {
    private int id;
    private Map<String, List<ParkingSpot>> parkingSpots;

    public DisplayBoard(int id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
    }

    public int getId() { return id; }

    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {
      //  parkingSpots.putIfAbsent(spotType, new ArrayList<>());
        parkingSpots.computeIfAbsent(spotType, k -> new ArrayList<>()).addAll(spots);
    }

    public void  bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(Map<Integer, ParkingSpot> allSpots) {
        parkingSpots.clear();
        for (ParkingSpot spot : allSpots.values()) {
          //  parkingSpots.putIfAbsent(spot.getSpotType(), new ArrayList<>());
           // parkingSpots.get(spot.getSpotType()).add(spot);
            parkingSpots.computeIfAbsent(spot.getSpotType(), k -> new ArrayList<>()).add(spot);
        }
    }

    public void showSlot() {
        System.out.println("Parking Slots Status (Board ID: " + id + "):");
        for (Map.Entry<String, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            String spotType = entry.getKey();
            List<ParkingSpot> spots = entry.getValue();
            System.out.println("Spot Type: " + spotType);
            for (ParkingSpot spot : spots) {
                String status = spot.isFree() ? "Free" : "Occupied by " + spot.getVehicle().getLicenseNo();
                System.out.println(" Spot ID: " + spot.getId() + " - " + status);
            }
            System.out.println();
        }
    }

    public void showFreeSlot() {
        System.out.println("Display Board ID: " + id + " - Free Slots:");
        for (Map.Entry<String, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            long freeCount = entry.getValue().stream().filter(ParkingSpot::isFree).count();
            System.out.println("  " + entry.getKey() + ": " + freeCount + " free spots");
        }
    }
}
