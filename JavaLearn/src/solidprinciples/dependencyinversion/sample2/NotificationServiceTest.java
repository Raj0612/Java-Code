package solidprinciples.dependencyinversion.sample2;

public class NotificationServiceTest {

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        NotificationService notificationService = new NotificationService(emailSender);
        notificationService.sendNotification("Send Message");
    }
}
