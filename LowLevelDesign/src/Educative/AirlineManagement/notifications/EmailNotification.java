package Educative.AirlineManagement.notifications;

import Educative.AirlineManagement.accounts.Account;

public class EmailNotification extends Notification {
    public EmailNotification(int notificationId, String content) {
        super(notificationId, content);
    }
    @Override
    public void sendNotification(Account account) {
        System.out.println("Email sent to " + account.getUsername() + ": " + getContent());
    }
}
