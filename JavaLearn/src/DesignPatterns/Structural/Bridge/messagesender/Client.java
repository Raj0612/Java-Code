package DesignPatterns.Structural.Bridge.messagesender;

public class Client {

    public static void main(String[] args) {

        AbstractMessage longMessage = new LongMessage(new EmailMessageSender());
        ((LongMessage) longMessage).sendMessage("Its a long message");


        AbstractMessage shortMessage = new ShortMessage(new SmsMessageSender());
        ((ShortMessage) shortMessage).sendMessage("Its a short message");
    }
}
