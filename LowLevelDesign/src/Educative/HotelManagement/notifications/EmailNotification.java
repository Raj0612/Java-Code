package Educative.HotelManagement.notifications;

import Educative.HotelManagement.accounts.Person;

public class EmailNotification extends Notification {
    public EmailNotification(String content) { super(content); }
    public void sendNotification(Person person) {
        System.out.println("Sending Email to " + person.getEmail() + ": " + content);
    }
}

