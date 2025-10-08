package Educative.AirlineManagement.notifications;

public class NotificationFactory {
    public static Notification createNotification(String type, int notificationId, String content) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SmsNotification(notificationId, content);
        } else if (type.equalsIgnoreCase("Email")) {
            return new EmailNotification(notificationId, content);
        }
        throw new IllegalArgumentException("Invalid notification type");
    }
}
