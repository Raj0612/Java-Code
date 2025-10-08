package Educative.Elevator.buttons;

import Educative.Elevator.enums.Direction;

public class HallButton  extends Button {
    private final Direction direction;

    public HallButton(Direction dir) {
        this.direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean isPressed() {
        return pressed;
    }
}
