package Educative.MovieBookingSystem.notifications;

import Educative.MovieBookingSystem.accounts.Person;

public class EmailNotification extends Notification {
    public EmailNotification(String content) {
        super(content);
    }

    @Override
    public void sendNotification(Person person) {
        System.out.println("Sending EMAIL to " + person.getEmail() + ": " + getContent());
    }
}

