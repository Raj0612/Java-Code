package Educative.OnlineShopping.notifications;

import Educative.OnlineShopping.accounts.Account;

import java.time.LocalDate;

public abstract class Notification {
    protected int notificationId;
    protected LocalDate createdOn;

    protected String content;
    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.content = content;
        this.createdOn = LocalDate.now();
    }
    public abstract boolean sendNotification(Account account);
}
