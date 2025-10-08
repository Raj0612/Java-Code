package Educative.HotelManagement.accounts;

import Educative.HotelManagement.RoomBooking;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Person {
    private int totalRoomsCheckedIn = 0;
    private List<RoomBooking> bookings = new ArrayList<>();

    public Guest(String name, Address addr, String email, String phone, Account acc) {
        super(name, addr, email, phone, acc);
    }
    public List<RoomBooking> getBookings() {
        return bookings;
    }
    public void addBooking(RoomBooking booking) {
        bookings.add(booking);
    }

    public int getTotalRoomsCheckedIn() {
        return totalRoomsCheckedIn;
    }

    public void setTotalRoomsCheckedIn(int totalRoomsCheckedIn) {
        this.totalRoomsCheckedIn = totalRoomsCheckedIn;
    }

    public void setBookings(List<RoomBooking> bookings) {
        this.bookings = bookings;
    }
}
