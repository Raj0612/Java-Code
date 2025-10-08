package Educative.MovieBookingSystem.notifications;

import Educative.MovieBookingSystem.accounts.Person;

public class PhoneNotification extends Notification {
    public PhoneNotification(String content) {
        super(content);
    }

    @Override
    public void sendNotification(Person person) {
        System.out.println("Sending SMS to " + person.getPhone() + ": " + getContent());
    }
}