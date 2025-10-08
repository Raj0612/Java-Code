package Educative.LibraryManagement.notifications;


import java.time.LocalDate;

public abstract class Notification {
    private String notificationId;
    private LocalDate creationDate;
    private String content;
    public Notification(String notificationId, LocalDate creationDate, String content) {
        this.notificationId = notificationId; this.creationDate = creationDate; this.content = content;
    }
    public abstract boolean sendNotification();

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
