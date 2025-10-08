package Educative.Elevator;

import Educative.Elevator.appservice.ElevatorSystem;
import Educative.Elevator.building.ElevatorCar;
import Educative.Elevator.building.Floor;
import Educative.Elevator.enums.*;
import Educative.Elevator.panels.HallPanel;

import java.util.Random;

public class ElevatorDemo {

    public static void main(String[] args) {
        int numFloors = 13;
        int numCars = 3;
        int numPanels = 1;    // Number of HallPanels per floor
        int numDisplays = 3;  // Number of Displays per floor

        ElevatorSystem system = ElevatorSystem.getInstance(numFloors, numCars, numPanels, numDisplays);

        // SCENARIO 1
        System.out.println("=== Scenario 1: Elevator 3 in maintenance, passenger calls elevator from floor 7 ===\n");
        system.monitoring();
        System.out.println();

        ElevatorCar car3 = system.getCars().get(2);
        car3.enterMaintenance();
        System.out.println();
        system.monitoring();
        System.out.println();

        // Simulate passenger pressing hall button UP on floor 7
        Floor floor7 = system.getBuilding().getFloors().get(7);
        HallPanel hallPanel7 = floor7.getPanel(0);
        if (hallPanel7.getUpButton() != null) {
            System.out.println("Passenger presses UP hall button on floor 7");
            hallPanel7.getUpButton().pressButton();
        }
        runCall(system, 7, Direction.UP);

        car3.exitMaintenance();
        System.out.println("\n--- Resetting maintenance for all elevators ---\n");
        system.monitoring();
        System.out.println();

        // SCENARIO 2
        System.out.println("=== Scenario 2: Random positions, passenger calls elevator from ground (0) to top (12) ===");

        Random rand = new Random();
        for (ElevatorCar car : system.getCars()) {
            int randomFloor = rand.nextInt(numFloors);
            System.out.printf("\n== Setting random position for Elevator %d ==\n", car.getId() + 1);
            System.out.printf("→ Teleporting Elevator %d to floor %d%n", car.getId() + 1, randomFloor);
            car.registerRequest(randomFloor);
            car.move();
        }

        System.out.println("\nElevator positions after random repositioning:");
        for (ElevatorCar car : system.getCars()) {
            System.out.printf("Elevator %d → Floor: %d | State: %s%n",
                    car.getId() + 1, car.getCurrentFloor(), car.getState());
        }
        System.out.println();

        // Simulate passenger pressing hall button UP on floor 0
        Floor floor0 = system.getBuilding().getFloors().get(0);
        HallPanel hallPanel0 = floor0.getPanel(0);
        if (hallPanel0.getUpButton() != null) {
            System.out.println("Passenger presses UP hall button on floor 0");
            hallPanel0.getUpButton().pressButton();
        }
        runCall(system, 0, Direction.UP);

        // SCENARIO 3: Overload scenario
        System.out.println("\n=== Scenario 3: Overload scenario on Elevator 1 ===");
        ElevatorCar car1 = system.getCars().get(0);
        car1.addLoad(800);
        car1.addLoad(300); // Should trigger overload
        car1.registerRequest(5);
        car1.move();
        car1.removeLoad(200);
        car1.move();

        // SCENARIO 4: Emergency stop scenario
        System.out.println("\n=== Scenario 4: Emergency stop on Elevator 2 ===");
        ElevatorCar car2 = system.getCars().get(1);
        car2.registerRequest(10);
        car2.move();
        // Simulate pressing emergency button inside elevator 2
        System.out.println("Passenger presses emergency button inside Elevator 2");
        car2.getPanel().getEmergencyButton().pressButton();
        car2.emergencyStop();

        // SCENARIO 5: Multiple calls and dispatching
        System.out.println("\n=== Scenario 5: Multiple calls from different floors ===");
        // Simulate hall button presses on floors 3, 9, and 6
        Floor floor3 = system.getBuilding().getFloors().get(3);
        HallPanel hallPanel3 = floor3.getPanel(0);
        if (hallPanel3.getUpButton() != null) {
            System.out.println("Passenger presses UP hall button on floor 3");
            hallPanel3.getUpButton().pressButton();
        }
        Floor floor9 = system.getBuilding().getFloors().get(9);
        HallPanel hallPanel9 = floor9.getPanel(0);
        if (hallPanel9.getDownButton() != null) {
            System.out.println("Passenger presses DOWN hall button on floor 9");
            hallPanel9.getDownButton().pressButton();
        }
        Floor floor6 = system.getBuilding().getFloors().get(6);
        HallPanel hallPanel6 = floor6.getPanel(0);
        if (hallPanel6.getUpButton() != null) {
            System.out.println("Passenger presses UP hall button on floor 6");
            hallPanel6.getUpButton().pressButton();
        }

        system.callElevator(3, Direction.UP);
        system.callElevator(9, Direction.DOWN);
        system.callElevator(6, Direction.UP);
        system.dispatcher();
        system.monitoring();

        System.out.println(new String(new char[100]).replace('\0', '-'));
    }

    private static void runCall(ElevatorSystem system, int floor, Direction dir) {
        System.out.printf("Passenger calls lift on floor %d (%s)%n", floor, dir);
        ElevatorCar nearest = system.getNearestCar(floor, dir);
        if (nearest == null) {
            System.out.println("No idle elevator available right now.");
            return;
        }
        System.out.printf("→ Nearest elevator is %d at floor %d. Lift going %s.%n",
                nearest.getId() + 1, nearest.getCurrentFloor(), dir);
        system.callElevator(floor, dir);
        system.dispatcher();
        System.out.println("\n[Status after dispatch]");
        system.monitoring();
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
}
