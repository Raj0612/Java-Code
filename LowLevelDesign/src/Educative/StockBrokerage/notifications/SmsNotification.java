package Educative.StockBrokerage.notifications;

public class SmsNotification extends Notification {
    private String phoneNumber;
    public SmsNotification(String phoneNumber, String content) {
        super(content);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean sendNotification() {
        // Simulate SMS send
        System.out.println("SMS sent to " + phoneNumber + ": " + content);
        return true;
    }
}
