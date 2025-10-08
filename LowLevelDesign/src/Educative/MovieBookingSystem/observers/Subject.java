package Educative.MovieBookingSystem.observers;

import Educative.MovieBookingSystem.notifications.Notification;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Notification notification);
}
