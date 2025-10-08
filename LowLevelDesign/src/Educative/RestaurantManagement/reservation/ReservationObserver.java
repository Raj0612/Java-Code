package Educative.RestaurantManagement.reservation;

public interface ReservationObserver {
    void update(Reservation reservation, String message);
}
