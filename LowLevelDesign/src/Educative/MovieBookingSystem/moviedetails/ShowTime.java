package Educative.MovieBookingSystem.moviedetails;

import Educative.MovieBookingSystem.seats.Seat;

import java.time.LocalDateTime;
import java.util.*;

public class ShowTime {
    private static int nextId = 1;
    private final int showId;
    private final LocalDateTime startTime;
    private final int duration; // in minutes
    private final List<Seat> seats;
    private final Hall hall;
    private final Movie movie;

    public ShowTime(LocalDateTime startTime, int duration, Hall hall, Movie movie, List<Seat> seats) {
        this.showId = nextId++;
        this.startTime = startTime;
        this.duration = duration;
        this.hall = hall;
        this.movie = movie;
        this.seats = new ArrayList<>(seats);
    }

    public int getShowId() {
        return showId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats);
    }

    public Hall getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> available = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                available.add(seat);
            }
        }
        return available;
    }

    public void showAvailableSeats() {
        System.out.println("Available seats for Show " + showId + " of movie " + movie.getTitle() + ":");
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                System.out.println(seat);
            }
        }
    }
}
