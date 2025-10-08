package Educative.CarRentalSyatem.notification;

import Educative.CarRentalSyatem.account.Account;
import java.time.LocalDateTime;

public abstract class Notification {
    private int notificationId;
    private LocalDateTime createdOn;
    private String content;

    public Notification() {
        this.createdOn = LocalDateTime.now();
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract void sendNotification(Account account);
}