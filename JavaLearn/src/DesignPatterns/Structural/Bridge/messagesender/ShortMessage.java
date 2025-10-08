package DesignPatterns.Structural.Bridge.messagesender;

public class ShortMessage extends AbstractMessage{

    public ShortMessage(IMessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void sendMessage(String message) {
        messageSender.sendMessage(message);
    }
}
