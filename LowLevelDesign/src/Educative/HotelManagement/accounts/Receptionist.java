package Educative.HotelManagement.accounts;

import Educative.HotelManagement.notifications.*;
import Educative.HotelManagement.structures.Room;
import Educative.HotelManagement.RoomBooking;
import Educative.HotelManagement.enums.BookingStatus;
import Educative.HotelManagement.enums.RoomStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Receptionist extends Person {
    public Receptionist(String name, Address addr, String email, String phone, Account acc) {
        super(name, addr, email, phone, acc);
    }
    public List<Guest> searchGuest(List<Guest> guests, String name) {
        List<Guest> found = new ArrayList<>();
        for (Guest g : guests) {
            if (g.name.equalsIgnoreCase(name)) {
                found.add(g);
            }
        }
        return found;
    }
    public RoomBooking createBooking(Guest guest, Room room, LocalDate start, int duration, double advance) {
        RoomBooking booking = new RoomBooking(UUID.randomUUID().toString(), start, duration, BookingStatus.CONFIRMED, guest, room, advance);
        guest.addBooking(booking);
        room.setStatus(RoomStatus.RESERVED);
        return booking;
    }

    public boolean checkout(RoomBooking booking) {
        if (booking.getRoom().checkout()) {
            double roomCharges = booking.getRoom().getBookingPrice() * booking.getDurationInDays();
            double serviceCharges = booking.getInvoice().getAmount();
            double totalBill = roomCharges + serviceCharges;
            double amountDue = totalBill - booking.getAdvancePayment();
            booking.setStatus(BookingStatus.COMPLETED);
            Notification notif = new EmailNotification("Thank you for staying! Amount due: $" + amountDue);
            notif.sendNotification(booking.getGuest());
            return true;
        }
        return false;
    }
}
