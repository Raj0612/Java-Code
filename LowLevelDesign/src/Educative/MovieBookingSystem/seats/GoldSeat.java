package Educative.MovieBookingSystem.seats;

public class GoldSeat extends Seat {
    private static final double GOLD_RATE = 20.0;

    public GoldSeat(String seatNo) {
        super(seatNo, GOLD_RATE);
    }
}

