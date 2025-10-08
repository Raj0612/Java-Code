package Educative.OnlineShopping.notifications;

import Educative.OnlineShopping.accounts.Account;

public class EmailNotification extends Notification {
    public EmailNotification(int notificationId, String content) {
        super(notificationId, content);
    }

    public boolean sendNotification(Account account) {
        System.out.println("Email sent to " + account.getEmail() + " with content: " + content);
        return true;
    }
}
