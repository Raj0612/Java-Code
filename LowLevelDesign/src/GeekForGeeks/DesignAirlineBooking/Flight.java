package GeekForGeeks.DesignAirlineBooking;

import java.time.LocalDateTime;
import java.util.Timer;

public class Flight {

    public LocalDateTime departure, arrival;

    public Timer duration;
    public String origin, destination;

    public Aircraft aircraft;

    public Flight(LocalDateTime departure, LocalDateTime arrival, Timer duration, String origin, String destination, Aircraft aircraft) {
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Timer getDuration() {
        return duration;
    }

    public void setDuration(Timer duration) {
        this.duration = duration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
