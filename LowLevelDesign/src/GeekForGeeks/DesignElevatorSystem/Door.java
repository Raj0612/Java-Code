package GeekForGeeks.DesignElevatorSystem;

import GeekForGeeks.DesignElevatorSystem.enums.DoorState;

public class Door {

    private DoorState state;
    private boolean isOpen;

    public void openDoor(){
        isOpen = true;
        state = DoorState.OPEN;
    }

    public void closeDoor(){
        isOpen = false;
        state = DoorState.CLOSE;
    }

    public DoorState getState() {
        return state;
    }

    public void setState(DoorState state) {
        this.state = state;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
