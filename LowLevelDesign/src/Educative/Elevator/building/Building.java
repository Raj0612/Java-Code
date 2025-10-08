package Educative.Elevator.building;

import java.util.*;

public class Building {
    private final List<Floor> floors;
    private final List<ElevatorCar> cars;

    public Building(int numFloors, int numCars, int numPanels, int numDisplaysPerFloor) {
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i, numPanels, numDisplaysPerFloor,numFloors - 1));
        }
        cars = new ArrayList<>();
        for (int i = 0; i < numCars; i++) {
            cars.add(new ElevatorCar(i, numFloors));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorCar> getCars() {
        return cars;
    }
}
