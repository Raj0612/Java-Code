package Educative.MovieBookingSystem.seats;

public class SilverSeat extends Seat {
    private static final double SILVER_RATE = 10.0;

    public SilverSeat(String seatNo) {
        super(seatNo, SILVER_RATE);
    }
}