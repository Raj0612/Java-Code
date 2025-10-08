package Educative.AirlineManagement.airports;

import Educative.AirlineManagement.accounts.Passenger;
import Educative.AirlineManagement.enums.*;
import Educative.AirlineManagement.seats.FlightSeat;

import java.time.LocalDate;
import java.util.*;

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap;
    private ReservationStatus status;
    private LocalDate creationDate;

    public FlightReservation(String reservationNumber, FlightInstance flight, LocalDate creationDate) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.seatMap = new HashMap<>();
        this.status = ReservationStatus.REQUESTED;
        this.creationDate = creationDate;
    }

    public static FlightReservation fetchReservationDetails(String reservationNumber) {
        // Placeholder for DB fetch logic
        return null;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(seatMap.keySet());
    }

    public boolean assignSeat(Passenger passenger, FlightSeat seat) {
        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            seat.setStatus(SeatStatus.BOOKED);
            seat.setReservationNumber(this.reservationNumber);
            seatMap.put(passenger, seat);
            return true;
        }
        return false;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public FlightInstance getFlight() {
        return flight;
    }

    public void setFlight(FlightInstance flight) {
        this.flight = flight;
    }

    public Map<Passenger, FlightSeat> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(Map<Passenger, FlightSeat> seatMap) {
        this.seatMap = seatMap;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
