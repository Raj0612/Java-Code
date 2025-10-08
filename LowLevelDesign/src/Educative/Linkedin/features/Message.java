package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;

import java.util.*;

public class Message {
    private int messageId;
    private User sender;
    private List<User> recipients;
    private String text;
    private List<byte[]> media;

    public Message(int messageId, User sender, List<User> recipients, String text) {
        this.messageId = messageId;
        this.sender = sender;
        this.recipients = recipients;
        this.text = text;
        this.media = new ArrayList<>();
    }

    public boolean addRecipients(List<User> recipients) {
        this.recipients.addAll(recipients);
        return true;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<byte[]> getMedia() {
        return media;
    }

    public void setMedia(List<byte[]> media) {
        this.media = media;
    }
}
