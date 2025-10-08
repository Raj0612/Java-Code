package Educative.StockBrokerage.notifications;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Notification {
    protected String notificationId;
    protected LocalDate creationDate;
    protected String content;

    public Notification(String content) {
        this.notificationId = UUID.randomUUID().toString();
        this.creationDate = LocalDate.now();
        this.content = content;
    }
    public abstract boolean sendNotification();
}
