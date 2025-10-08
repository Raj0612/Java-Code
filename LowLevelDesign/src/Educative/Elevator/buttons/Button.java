package Educative.Elevator.buttons;

import Educative.Elevator.designpatterns.ButtonListener;

import java.util.*;

public abstract class Button {
    protected boolean pressed = false;
    private final List<ButtonListener> listeners = new ArrayList<>();

    public void pressButton() {
        if (!pressed) {
            pressed = true;
            notifyListeners();
        }
    }

    public void reset() {
        pressed = false;
    }

    public abstract boolean isPressed();

    public void addListener(ButtonListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ButtonListener listener) {
        listeners.remove(listener);
    }

    protected void notifyListeners() {
        for (ButtonListener listener : listeners) {
            listener.onButtonPressed(this);
        }
    }
}
