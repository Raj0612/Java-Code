package Educative.Elevator.panels;

import Educative.Elevator.buttons.*;
import Educative.Elevator.designpatterns.ButtonListener;
import Educative.Elevator.building.ElevatorCar;

import java.util.*;

public class ElevatorPanel  implements ButtonListener {
    private final List<ElevatorButton> elevatorButtons;
    private final DoorButton openButton;
    private final DoorButton closeButton;
    private final EmergencyButton emergencyButton;
    private ElevatorCar elevatorCar; // Reference to owning ElevatorCar

    public ElevatorPanel(int numFloors, ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        elevatorButtons = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            ElevatorButton btn = new ElevatorButton(i);
            btn.addListener(this);
            elevatorButtons.add(btn);
        }
        openButton = new DoorButton();
        closeButton = new DoorButton();
        emergencyButton = new EmergencyButton();
        emergencyButton.addListener(this);
    }

    @Override
    public void onButtonPressed(Button button) {
        if (button instanceof ElevatorButton) {
            ElevatorButton eb = (ElevatorButton) button;
            int floor = eb.getDestinationFloor();
            System.out.printf("Elevator %d panel: Floor button %d pressed.%n", elevatorCar.getId() + 1, floor);
            elevatorCar.registerRequest(floor);
        } else if (button instanceof DoorButton) {
            DoorButton db = (DoorButton) button;
            if (db == openButton) {
                System.out.printf("Elevator %d panel: Door open button pressed.%n", elevatorCar.getId() + 1);
                elevatorCar.getDoor().open();
            } else if (db == closeButton) {
                System.out.printf("Elevator %d panel: Door close button pressed.%n", elevatorCar.getId() + 1);
                elevatorCar.getDoor().close();
            }
        } else if (button instanceof EmergencyButton) {
            System.out.printf("Elevator %d panel: Emergency button pressed! Entering emergency mode.%n", elevatorCar.getId() + 1);
            elevatorCar.emergencyStop();
        }
    }

    public List<ElevatorButton> getElevatorButtons() {
        return elevatorButtons;
    }

    public DoorButton getOpenButton() {
        return openButton;
    }

    public DoorButton getCloseButton() {
        return closeButton;
    }

    public EmergencyButton getEmergencyButton() {
        return emergencyButton;
    }

    public void enterEmergency() {
        emergencyButton.setPressed(true);
    }

    public void exitEmergency() {
        emergencyButton.setPressed(false);
    }


}
