package Educative.StockBrokerage.notifications;

public class EmailNotification extends Notification {
    private String email;
    public EmailNotification(String email, String content) {
        super(content);
        this.email = email;
    }
    @Override
    public boolean sendNotification() {
        // Simulate Email send
        System.out.println("Email sent to " + email + ": " + content);
        return true;
    }
}
