package Educative.StackOverFlow.service;


import Educative.StackOverFlow.accounts.Account;
import Educative.StackOverFlow.notifications.Notification;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) instance = new NotificationService();
        return instance;
    }

    public boolean sendNotification(Account account, Notification notification) {
        // Simulate sending notification (email, SMS, etc.)
        System.out.println("Notification sent to " + account.getUsername() + ": " + notification.getContent());
        return true;
    }
}
