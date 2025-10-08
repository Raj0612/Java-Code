package Educative.MovieBookingSystem.accounts;

import Educative.MovieBookingSystem.moviedetails.Booking;
import Educative.MovieBookingSystem.notifications.Notification;
import Educative.MovieBookingSystem.observers.Observer;

import java.util.*;


public class Customer extends Person implements Observer {
    private final List<Booking> bookings;

    public Customer(String name, String address, String phone, String email) {
        super(name, address, phone, email);
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public boolean createBooking(Booking booking) {
        if (booking.confirmBooking()) {
            bookings.add(booking);
            System.out.println("Booking created for customer " + getName());
            return true;
        }
        return false;
    }

    public boolean updateBooking(Booking booking) {
        // For simplicity, disallow updating existing booking
        System.out.println("Update booking not supported.");
        return false;
    }

    public boolean deleteBooking(Booking booking) {
        if (bookings.contains(booking)) {
            booking.cancelBooking();
            bookings.remove(booking);
            System.out.println("Booking deleted for customer " + getName());
            return true;
        }
        return false;
    }

    @Override
    public void update(Notification notification) {
        notification.sendNotification(this);
    }
}
