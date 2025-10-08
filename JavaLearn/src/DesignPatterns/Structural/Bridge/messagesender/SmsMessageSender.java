package DesignPatterns.Structural.Bridge.messagesender;

public class SmsMessageSender implements IMessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println(message +" : This Message has been sent using SMS");
    }
}
