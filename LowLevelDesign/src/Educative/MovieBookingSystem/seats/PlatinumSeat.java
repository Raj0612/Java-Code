package Educative.MovieBookingSystem.seats;

public class PlatinumSeat extends Seat {
    private static final double PLATINUM_RATE = 30.0;

    public PlatinumSeat(String seatNo) {
        super(seatNo, PLATINUM_RATE);
    }
}