package Educative.MovieBookingSystem.observers;

import Educative.MovieBookingSystem.notifications.Notification;

//Implemented in Customer class
public interface Observer {
    void update(Notification notification);
}
