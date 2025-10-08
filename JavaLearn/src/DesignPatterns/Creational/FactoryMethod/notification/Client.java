package DesignPatterns.Creational.FactoryMethod.notification;

public class Client {
    public static void main(String[] args)  {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}
