package Educative.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingRoom {

    private String id;
    private int capacity;
    private final String name;
    private boolean isAvailable;
    private List<Meeting> bookings;

    public MeetingRoom(int id, int capacity, String name) {
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.isAvailable = true;
        this.bookings = new ArrayList<>();
        this.name = name;
    }

    public boolean isAvailable(Interval interval) {
        for (Meeting m : bookings) {
            if (m.getTimeSlot().overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getName() { return name; }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Meeting> getBookedIntervals() {
        return bookings;
    }

    public void addBooking(Meeting meeting) {
        this.bookings.add(meeting);
    }
}
