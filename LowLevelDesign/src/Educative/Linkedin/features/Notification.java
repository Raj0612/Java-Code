package Educative.Linkedin.features;

import Educative.Linkedin.accounts.Observer;

import java.time.LocalDate;
import java.util.*;

public class Notification {
    private int notificationId;
    private LocalDate createdOn;
    private String content;
    private List<Observer> observers;

    public Notification(int notificationId, LocalDate createdOn, String content) {
        this.notificationId = notificationId;
        this.createdOn = createdOn;
        this.content = content;
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public boolean sendNotification() {
        notifyObservers();
        return true;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
