package Educative.CarRentalSyatem.appservice;

import Educative.CarRentalSyatem.designpatterns.Observer;
import Educative.CarRentalSyatem.designpatterns.Subject;

import java.util.*;

public class NotificationService implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
