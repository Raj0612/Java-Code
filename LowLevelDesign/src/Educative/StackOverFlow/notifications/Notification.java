package Educative.StackOverFlow.notifications;

import java.time.LocalDate;
import java.util.UUID;

public class Notification {
    private String notificationId;
    private LocalDate createdOn;
    private String content;

    public Notification(String content) {
        this.notificationId = UUID.randomUUID().toString();
        this.createdOn = LocalDate.now();
        this.content = content;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
