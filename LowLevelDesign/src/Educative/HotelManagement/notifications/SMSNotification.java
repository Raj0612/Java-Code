package Educative.HotelManagement.notifications;


import Educative.HotelManagement.accounts.Person;

public class SMSNotification extends Notification {
    public SMSNotification(String content) { super(content); }

    public void sendNotification(Person person) {
        System.out.println("Sending SMS to " + person.getPhone() + ": " + content);
    }

}

