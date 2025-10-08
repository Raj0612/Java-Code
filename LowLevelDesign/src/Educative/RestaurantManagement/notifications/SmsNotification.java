package Educative.RestaurantManagement.notifications;


import Educative.RestaurantManagement.accounts.Person;

public class SmsNotification extends Notification {
    private String phone;

    public SmsNotification(int notificationId, String content, String phone) {
        super(notificationId,  content);
        this.phone = phone;
    }

    public void send(Person person) {
        // Send SMS logic (placeholder)
        System.out.println("Sending SMS to " + person.getPhone());
    }


}
