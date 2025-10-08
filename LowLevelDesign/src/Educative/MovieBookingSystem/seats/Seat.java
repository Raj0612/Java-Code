package Educative.MovieBookingSystem.seats;

import Educative.MovieBookingSystem.enums.SeatStatus;

import java.util.concurrent.locks.ReentrantLock;

public abstract class Seat {
    private final String seatNo;
    private SeatStatus status;
    private final double rate;

    private final ReentrantLock lock = new ReentrantLock(); // for thread-safe booking

    public Seat(String seatNo, double rate) {
        this.seatNo = seatNo;
        this.rate = rate;
        this.status = SeatStatus.AVAILABLE;
    }
    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    // Thread-safe seat booking attempt
    public boolean book() {
        lock.lock();
        try {
            if (status == SeatStatus.AVAILABLE) {
                status = SeatStatus.BOOKED;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            if (status == SeatStatus.BOOKED) {
                status = SeatStatus.AVAILABLE;
            }
        } finally {
            lock.unlock();
        }
    }

    public void reserve() {
        lock.lock();
        try {
            if (status == SeatStatus.AVAILABLE) {
                status = SeatStatus.RESERVED;
            }
        } finally {
            lock.unlock();
        }
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return seatNo + " (" + this.getClass().getSimpleName() + ") - " + status + " - $" + rate;
    }
}
