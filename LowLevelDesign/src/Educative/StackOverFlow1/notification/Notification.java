package Educative.StackOverFlow1.notification;

import Educative.StackOverFlow1.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.*;
public class Notification {

    private final String id = UUID.randomUUID().toString();
    private final NotificationType type;
    private final String content;
    private final LocalDateTime createdAt;
    private boolean read = false;

    public Notification(NotificationType type, String content) {
        this.type = type;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public void markRead() {
        read = true;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "[" + createdAt + "] " + type + ": " + content + (read ? " (read)" : " (unread)");
    }
}
