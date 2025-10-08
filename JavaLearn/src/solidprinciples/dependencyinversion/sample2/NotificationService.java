package solidprinciples.dependencyinversion.sample2;

interface Sender {
    void send(String message);
}

// Low-level module: EmailSender
class EmailSender implements Sender {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Low-level module: SMSSender
class SMSSender implements Sender {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
public class NotificationService {

    private Sender sender;

    public NotificationService(Sender sender) {
        this.sender = sender; // Constructor injection
    }

    public void sendNotification(String message) {
        sender.send(message);  // Delegating the responsibility of sending the message
    }
}
