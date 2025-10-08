package DesignPatterns.Structural.Bridge.messagesender;

public class LongMessage extends AbstractMessage{
    public LongMessage(IMessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void sendMessage(String message) {
        messageSender.sendMessage(message);
    }
}
