package GeekForGeeks.DesignAirlineBooking;

import java.time.LocalDateTime;

public class Reservation {

    private static int idCounter;
    public LocalDateTime creationDate;
    public String reservationNumber;
    public Flight flight;
    public Seat seats;
    public Airport destinationAirport, sourceAirport;

    public Customer customer;

    public Reservation(LocalDateTime creationDate, Flight flight, Seat seats, Airport destinationAirport, Airport sourceAirport, Customer customer) {
        idCounter++;
        this.creationDate = creationDate;
        this.reservationNumber = String.valueOf(idCounter);
        this.flight = flight;
        this.seats = seats;
        this.destinationAirport = destinationAirport;
        this.sourceAirport = sourceAirport;
        this.customer = customer;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeats() {
        return seats;
    }

    public void setSeats(Seat seats) {
        this.seats = seats;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "creationDate=" + creationDate +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", flight=" + flight.getAircraft().getName() +
                ", seats=" + seats.category +
                ", destinationAirport=" + destinationAirport.getName() +
                ", sourceAirport=" + sourceAirport.getName() +
                ", customer=" + customer.name +
                '}';
    }
}
