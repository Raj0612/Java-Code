package Educative.AirlineManagement.airports;

import Educative.AirlineManagement.accounts.Passenger;
import Educative.AirlineManagement.payments.Payment;

import java.time.LocalDate;
import java.util.*;

public class Itinerary {
    private Airport startingAirport;
    private Airport finalAirport;
    private LocalDate creationDate;
    private List<FlightReservation> reservations;
    private List<Passenger> passengers;

    public Itinerary(Airport startingAirport, Airport finalAirport, LocalDate creationDate, List<Passenger> passengers) {
        this.startingAirport = startingAirport;
        this.finalAirport = finalAirport;
        this.creationDate = creationDate;
        this.passengers = passengers;
        this.reservations = new ArrayList<>();
    }

    public boolean addReservation(FlightReservation reservation) {
        return reservations.add(reservation);
    }

    public boolean makeReservation() {
        // Placeholder for reservation logic
        return true;
    }

    public boolean makePayment(Payment payment) {
        return payment.makePayment();
    }

    // Getters and setters
    public Airport getStartingAirport() {
        return startingAirport;
    }

    public void setStartingAirport(Airport startingAirport) {
        this.startingAirport = startingAirport;
    }

    public Airport getFinalAirport() {
        return finalAirport;
    }

    public void setFinalAirport(Airport finalAirport) {
        this.finalAirport = finalAirport;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<FlightReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<FlightReservation> reservations) {
        this.reservations = reservations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
