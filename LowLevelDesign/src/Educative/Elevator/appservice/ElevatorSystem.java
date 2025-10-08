package Educative.Elevator.appservice;

import Educative.Elevator.building.Building;
import Educative.Elevator.enums.*;
import Educative.Elevator.building.ElevatorCar;

import java.util.*;

public class ElevatorSystem {
    private static ElevatorSystem system;
    private final Building building;

    private ElevatorSystem(int floors, int cars, int numPanels, int numDisplaysPerFloor) {
        building = new Building(floors, cars, numPanels, numDisplaysPerFloor);
    }

    public static synchronized ElevatorSystem getInstance(int floors, int cars, int numPanels, int numDisplaysPerFloor) {
        if (system == null) {
            system = new ElevatorSystem(floors, cars, numPanels, numDisplaysPerFloor);
        }
        return system;
    }

    public static ElevatorSystem getInstance() {
        if (system == null) {
            throw new IllegalStateException("ElevatorSystem is not initialized yet.");
        }
        return system;
    }

    public List<ElevatorCar> getCars() {
        return building.getCars();
    }

    public Building getBuilding() {
        return building;
    }

    public void handleHallCall(int floor, Direction direction) {
        System.out.printf("Received hall call at floor %d going %s%n", floor, direction);
        ElevatorCar car = getNearestCar(floor, direction);
        if (car != null) {
            car.registerRequest(floor);
            System.out.printf("Dispatching Elevator %d to floor %d%n", car.getId() + 1, floor);
        } else {
            System.out.println("No idle elevator available to handle the hall call right now.");
        }
    }

    public void callElevator(int floorNum, Direction dir) {
        System.out.printf("Calling elevator to floor %d going %s.%n", floorNum, dir);
        ElevatorCar car = getNearestCar(floorNum, dir);
        if (car != null) {
            car.registerRequest(floorNum);
        } else {
            System.out.println("No idle elevator available to handle the call right now.");
        }
    }

    public ElevatorCar getNearestCar(int requestedFloor, Direction requestedDirection) {
        ElevatorCar nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for (ElevatorCar car : building.getCars()) {

            if (car.isInMaintenance() || car.isOverloaded()) {
                continue;
            }

            ElevatorState state = car.getState();
            int currentFloor = car.getCurrentFloor();
            if (state == ElevatorState.IDLE) {
                int distance = Math.abs(currentFloor - requestedFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = car;
                }
            } else if ((state == ElevatorState.UP && requestedDirection == Direction.UP && requestedFloor >= currentFloor)
                    || (state == ElevatorState.DOWN && requestedDirection == Direction.DOWN && requestedFloor <= currentFloor)) {
                // Elevator moving in the same direction and will pass the requested floor
                int distance = Math.abs(currentFloor - requestedFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = car;
                }
            }
        }
        return nearest;
    }

    public void dispatcher() {
        for (ElevatorCar car : building.getCars()) {
            car.move();
        }
    }

    public void monitoring() {
        System.out.println("Elevator System Monitoring:");
        for (ElevatorCar car : building.getCars()) {
            car.getDisplay().showElevatorDisplay(car.getId() + 1);
        }
    }
}
