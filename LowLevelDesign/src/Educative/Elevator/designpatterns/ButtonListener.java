package Educative.Elevator.designpatterns;

import Educative.Elevator.buttons.Button;

// Observer pattern for button press notifications
//Implemented in ElevatorPanel & Button
public interface ButtonListener {
    void onButtonPressed(Button button);
}
