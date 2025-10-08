package Educative.OnlineShopping.notifications;

import Educative.OnlineShopping.accounts.Account;

public class PhoneNotification extends Notification {
    public PhoneNotification(int notificationId, String content) {
        super(notificationId, content);
    }

    public boolean sendNotification(Account account) {
        System.out.println("SMS sent to " + account.getUserName() + " with content: " + content);
        return true;
    }
}
