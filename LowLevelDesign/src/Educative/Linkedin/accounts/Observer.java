package Educative.Linkedin.accounts;

import Educative.Linkedin.features.Notification;

//Implemented in User
public interface Observer {
    void update(Notification notification);
}
