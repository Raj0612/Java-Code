package Educative.RestaurantManagement.reservation;

import Educative.RestaurantManagement.accounts.Customer;
import Educative.RestaurantManagement.enums.ReservationStatus;
import Educative.RestaurantManagement.notifications.Notification;
import Educative.RestaurantManagement.tables.Table;

import java.time.LocalDate;
import java.util.*;

public class Reservation {

    private int reservationID;
    private LocalDate timeOfReservation;
    private int peopleCount;
    private ReservationStatus status;
    private String notes;
    private LocalDate checkInTime;
    private Customer customer;
    private List<Table> tables;
    private List<Notification> notifications;
    private List<ReservationObserver> observers;

    public Reservation(int reservationID, LocalDate timeOfReservation, int peopleCount, ReservationStatus status, String notes, LocalDate checkInTime, Customer customer) {
        this.reservationID = reservationID;
        this.timeOfReservation = timeOfReservation;
        this.peopleCount = peopleCount;
        this.status = status;
        this.notes = notes;
        this.checkInTime = checkInTime;
        this.customer = customer;
        this.tables = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public boolean updatePeopleCount(int count) {
        this.peopleCount = count;
        return true;
    }

    public void addObserver(ReservationObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (ReservationObserver observer : observers) {
            observer.update(this, message);
        }
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
    }
    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    public int getReservationID() {
        return reservationID;
    }

    public LocalDate getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(LocalDate timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", timeOfReservation=" + timeOfReservation +
                ", peopleCount=" + peopleCount +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", checkInTime=" + checkInTime +
                ", customer=" + customer +
                ", tables=" + tables +
                ", notifications=" + notifications +
                '}';
    }
}
