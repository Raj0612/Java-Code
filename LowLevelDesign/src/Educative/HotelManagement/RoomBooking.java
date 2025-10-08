package Educative.HotelManagement;

import Educative.HotelManagement.accounts.Guest;
import Educative.HotelManagement.enums.BookingStatus;
import Educative.HotelManagement.enums.RoomStatus;
import Educative.HotelManagement.invoices.Invoice;
import Educative.HotelManagement.notifications.Notification;
import Educative.HotelManagement.notifications.SMSNotification;
import Educative.HotelManagement.services.Service;
import Educative.HotelManagement.structures.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomBooking {
    private String reservationNumber;
    private LocalDate startDate;
    private int durationInDays;
    private BookingStatus status;
    private LocalDate checkin, checkout;
    private Guest guest;
    private Room room;
    private Invoice invoice;
    private List<Notification> notifications = new ArrayList<>();
    private double advancePayment;

    public RoomBooking(String resNum, LocalDate start, int duration, BookingStatus status, Guest guest, Room room, double advance) {
        this.reservationNumber = resNum;
        this.startDate = start;
        this.durationInDays = duration;
        this.status = status;
        this.guest = guest;
        this.room = room;
        this.advancePayment = advance;
        this.checkin = start;
        this.checkout = start.plusDays(duration);
        this.invoice = new Invoice(advance);
    }
    public static RoomBooking fetchDetails(String reservationNumber, List<RoomBooking> allBookings) {
        for (RoomBooking b : allBookings) {
            if (b.reservationNumber.equals(reservationNumber)) {
                return b;
            }
        }
        return null;
    }
    public boolean cancelBooking() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime checkinTime = this.checkin.atStartOfDay();
        if (now.isBefore(checkinTime.minusHours(24))) {
            this.status = BookingStatus.CANCELLED;
            this.invoice = new Invoice(0.0); // refund logic
            this.room.setStatus(RoomStatus.AVAILABLE);
            Notification notif = new SMSNotification("Booking " + reservationNumber + " cancelled. Full refund issued.");
            notif.sendNotification(guest);
            notifications.add(notif);
            return true;
        } else {
            Notification notif = new SMSNotification("Booking " + reservationNumber + " cancelled. No refund (less than 24h).");
            notif.sendNotification(guest);
            notifications.add(notif);
            this.status = BookingStatus.CANCELLED;
            this.room.setStatus(RoomStatus.AVAILABLE);
            return true;
        }
    }
    public void addService(Service service) {
        service.addInvoiceItem(invoice);
    }
    public void addNotification(Notification notif) {
        notifications.add(notif);
    }
    public Room getRoom() {
        return room;
    }
    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    public String getReservationNumber() {
        return reservationNumber;
    }
    public Invoice getInvoice() {
        return invoice;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
