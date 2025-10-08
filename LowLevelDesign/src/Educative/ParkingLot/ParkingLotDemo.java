package Educative.ParkingLot;

import Educative.ParkingLot.accounts.Admin;
import Educative.ParkingLot.designpatterns.ParkingSpotFactory;
import Educative.ParkingLot.enums.*;
import Educative.ParkingLot.features.*;
import Educative.ParkingLot.accounts.Person;
import Educative.ParkingLot.parkingspots.*;
import Educative.ParkingLot.system.ParkingLot;
import Educative.ParkingLot.vehicles.*;

public class ParkingLotDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n====================== PARKING LOT SYSTEM DEMO ======================\n");

        ParkingLot lot = ParkingLot.getInstance();

        // Add parking spots
        lot.addParkingSpot(new Handicapped(1));
        lot.addParkingSpot(new Compact(2));
        lot.addParkingSpot(new Large(3));
        lot.addParkingSpot(new MotorCycleSpot(4));
        lot.addParkingSpot(new Compact(5));
        lot.addParkingSpot(new Large(6));

        // Add display board
        DisplayBoard board = new DisplayBoard(1);
        lot.addDisplayBoard(board);

        // Add entrance and exit
        Entrance entrance = new Entrance(1);
        Exit exit = new Exit(1);
        lot.addEntrance(entrance);
        lot.addExit(exit);

        // Scenario 1: Customer enters and parks a car
        System.out.println("\n\u2192\u2192\u2192 SCENARIO 1: Customer enters and parks a car\n");
        Vehicle car = new Car("KA-01-HH-1234");
        System.out.println("-> Car " + car.getLicenseNo() + " arrives at entrance");
        ParkingTicket ticket1 = entrance.getTicket(car);

        System.out.println("-> Updating display board after parking:");
        board.update(lot.getAllSpots());
        board.showFreeSlot();

        // Scenario 2: Customer exits and pays
        System.out.println("\n\u2192\u2192\u2192 SCENARIO 2: Customer exits and pays\n");
        System.out.println("-> Car " + car.getLicenseNo() + " proceeds to exit panel");
        Thread.sleep(1500); // Simulate parking duration
        exit.validateTicket(ticket1);

        System.out.println("-> Updating display board after exit:");
        board.update(lot.getAllSpots());
        board.showFreeSlot();

        // Scenario 3: Filling lot and rejecting entry if full
        System.out.println("\n\u2192\u2192\u2192 SCENARIO 3: Multiple customers attempt to enter; lot may become full\n");
        Vehicle van = new Van("KA-01-HH-9999");
        Vehicle motorcycle = new MotorCycle("KA-02-XX-3333");
        Vehicle truck = new Truck("KA-04-AA-9998");
        Vehicle car2 = new Car("DL-09-YY-1234");

        System.out.println("-> Van " + van.getLicenseNo() + " arrives at entrance");
        ParkingTicket ticket2 = entrance.getTicket(van);

        System.out.println("-> Motorcycle " + motorcycle.getLicenseNo() + " arrives at entrance");
        ParkingTicket ticket3 = entrance.getTicket(motorcycle);

        System.out.println("-> Truck " + truck.getLicenseNo() + " arrives at entrance");
        ParkingTicket ticket4 = entrance.getTicket(truck);

        System.out.println("-> Car " + car2.getLicenseNo() + " arrives at entrance");
        ParkingTicket ticket5 = entrance.getTicket(car2);

        System.out.println("-> Updating display board after several parkings:");
        board.update(lot.getAllSpots());
        board.showFreeSlot();

        // Try to park another car (lot may now be full)
        Vehicle car3 = new Car("UP-01-CC-1001");
        System.out.println("-> Car " + car3.getLicenseNo() + " attempts to park (should be denied if lot is full):");
        ParkingTicket ticket6 = entrance.getTicket(car3);

        board.update(lot.getAllSpots());
        board.showFreeSlot();

        // Additional Scenario 4: Admin resets password and adds new spot
        System.out.println("\n\u2192\u2192\u2192 SCENARIO 4: Admin resets password and adds new parking spot\n");
        Person adminPerson = new Person("AdminUser", "123 Admin St", "1234567890", "admin@example.com");
        Admin admin = new Admin("admin1", "password", adminPerson, AccountStatus.ACTIVE);
        admin.resetPassword();

        ParkingSpot newSpot = new Compact(7);
        boolean added = admin.addParkingSpot(newSpot);
        System.out.println("Admin added new parking spot with ID 7: " + (added ? "Success" : "Failure"));

        board.update(lot.getAllSpots());
        board.showFreeSlot();

        // Additional Scenario 5: Vehicle tries to park in wrong spot type
        System.out.println("\n\u2192\u2192\u2192 SCENARIO 5: Motorcycle tries to park in Large spot\n");
        ParkingSpot largeSpot = ParkingSpotFactory.createParkingSpot("large", 8);
        lot.addParkingSpot(largeSpot);
        Vehicle motorcycle2 = new MotorCycle("MH-01-XY-9876");
        boolean assigned = largeSpot.assignVehicle(motorcycle2);
        System.out.println("Motorcycle assigned to large spot: " + assigned);

        System.out.println("\n====================== END OF DEMONSTRATION ======================\n");
    }

}
