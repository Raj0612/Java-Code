package Educative.Elevator.utility;

import Educative.Elevator.enums.Direction;
import Educative.Elevator.enums.ElevatorState;

public class Display {
    private int floor;
    private int load;
    private Direction direction;
    private ElevatorState state;
    private boolean maintenance;
    private boolean overloaded;

    public void update(int floor, Direction direction, int load, ElevatorState state, boolean overloaded, boolean maintenance) {
        this.floor = floor;
        this.direction = direction;
        this.load = load;
        this.state = state;
        this.overloaded = overloaded;
        this.maintenance = maintenance;
    }

    public void showElevatorDisplay(int carId) {
        System.out.printf("Elevator %d Display -> Floor: %d | Direction: %s | Load: %dkg | State: %s | Overloaded: %b | Maintenance: %b%n",
                carId, floor, direction, load, state, overloaded, maintenance);
    }
}
