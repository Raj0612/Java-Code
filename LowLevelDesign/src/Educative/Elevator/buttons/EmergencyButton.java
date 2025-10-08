package Educative.Elevator.buttons;

public class EmergencyButton extends Button {
    public boolean getPressed() {
        return pressed;
    }

    public void setPressed(boolean val) {
        pressed = val;
        if (pressed) {
            notifyListeners();
        }
    }

    @Override
    public boolean isPressed() {
        return pressed;
    }
}
