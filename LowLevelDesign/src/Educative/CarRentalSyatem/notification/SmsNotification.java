package Educative.CarRentalSyatem.notification;


import Educative.CarRentalSyatem.account.Account;
import Educative.CarRentalSyatem.designpatterns.Observer;

public class SmsNotification implements Observer {
    private Account account;

    public SmsNotification(Account account) {
        this.account = account;
    }

    @Override
    public void update(String message) {
        System.out.println("Sending SMS to " + account.getPhoneNumber() + ": " + message);
    }
}