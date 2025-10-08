package Educative.StackOverFlow1.services;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.notification.Notification;

public class NotificationService {
    private static final NotificationService INSTANCE = new NotificationService();

    private NotificationService() {
    }

    public static NotificationService getInstance() {
        return INSTANCE;
    }

    // In real system: enqueue, deliver via channels. Here: print + push to user.
    public void send(User user, Notification notification) {
        user.receiveNotification(notification);
        System.out.println("NOTIFY -> " + user.getAccount().getUsername() + ": " + notification.getContent());
    }
}
