package DesignPatterns.Structural.Bridge.messagesender;

public abstract class AbstractMessage {

    IMessageSender messageSender;

    public AbstractMessage(IMessageSender messageSender){
        this.messageSender = messageSender;
    }
    abstract void sendMessage(String message);
}
