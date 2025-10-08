package Educative.LibraryManagement.notifications;
import Educative.LibraryManagement.accounts.Address;

import java.time.LocalDate;
public class PostalNotification extends Notification {
    private Address address;
    public PostalNotification(String notificationId, LocalDate creationDate, String content, Address address) {
        super(notificationId, creationDate, content); this.address = address;
    }
    @Override
    public boolean sendNotification() {
        System.out.println("Postal notification sent to " + address + ": " + super.getContent());
        return true;
    }
}
