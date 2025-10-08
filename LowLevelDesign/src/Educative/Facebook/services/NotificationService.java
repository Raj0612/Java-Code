package Educative.Facebook.services;

import Educative.Facebook.interfaces.Observer;
import Educative.Facebook.notications.Notification;

public class NotificationService {
    //private static NotificationService instance = null;
    private NotificationService() {}
//    public static NotificationService getInstance() {
//        if (instance == null) {
//            synchronized (NotificationService.class) {
//                if (instance == null) instance = new NotificationService();
//            }
//        }
//        return instance;
//    }
    public void send(Notification notification, Observer observer) {
        observer.update(notification);
    }

    private static class Holder {
        private static final NotificationService INSTANCE = new NotificationService();
    }

    public static NotificationService getInstance() {
        return Holder.INSTANCE;
    }
}
