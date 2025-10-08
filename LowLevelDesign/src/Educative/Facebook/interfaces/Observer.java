package Educative.Facebook.interfaces;

import Educative.Facebook.notications.Notification;

//Implemented by User
public interface Observer {
    void update(Notification notification);
}
