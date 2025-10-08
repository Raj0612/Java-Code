package Educative.MovieBookingSystem.notifications;

import Educative.MovieBookingSystem.accounts.Person;

import java.time.LocalDateTime;

public abstract class Notification {
    private static int nextId = 1;
    private final int notificationId;
    private final LocalDateTime createdOn;
    private final String content;

    public Notification(String content) {
        this.notificationId = nextId++;
        this.createdOn = LocalDateTime.now();
        this.content = content;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getContent() {
        return content;
    }

    public abstract void sendNotification(Person person);
}
