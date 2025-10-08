package ashishps1.airlinemanagementsystem;

import ashishps1.airlinemanagementsystem.booking.Booking;
import ashishps1.airlinemanagementsystem.booking.BookingManager;
import ashishps1.airlinemanagementsystem.flight.Flight;
import ashishps1.airlinemanagementsystem.flight.FlightSearch;
import ashishps1.airlinemanagementsystem.payment.Payment;
import ashishps1.airlinemanagementsystem.payment.PaymentProcessor;
import ashishps1.airlinemanagementsystem.seat.Seat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirlineManagementSystem {
    private final Map<String, Flight> flights;
    private final Map<String, Aircraft> aircrafts;
    private final Map<String, Passenger> passengers;
    private final FlightSearch flightSearch;
    private final BookingManager bookingManager;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem() {
        flights = new HashMap<>();
        aircrafts = new HashMap<>();
        passengers = new HashMap<>();
        flightSearch = new FlightSearch();
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public Passenger addPassenger(String name, String email) {
        Passenger passenger = new Passenger(name, email);
        passengers.put(passenger.getId(), passenger);
        return passenger;
    }

    public Aircraft addAircraft(String tailNumber, String model, int totalSeats) {
        Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
        aircrafts.put(tailNumber, aircraft);
        return aircraft;
    }

    public Flight addFlight(String source, String destination, LocalDateTime departure,
                            LocalDateTime arrival, String aircraftNumber) {
        Aircraft aircraft = aircrafts.get(aircraftNumber);
        Flight flight = new Flight(source, destination, departure, arrival, aircraft);
        flights.put(flight.getFlightNumber(), flight);
        flightSearch.addFlight(flight);
        return flight;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlights(source, destination, date);
    }

    public Booking bookFlight(String flightNumber, String passengerId, Seat seat, double price) {
        Flight flight = flights.get(flightNumber);
        Passenger passenger = passengers.get(passengerId);
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }
}
