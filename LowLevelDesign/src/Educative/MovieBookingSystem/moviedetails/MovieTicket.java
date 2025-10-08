package Educative.MovieBookingSystem.moviedetails;

import Educative.MovieBookingSystem.seats.Seat;

public class MovieTicket {
    private static int nextTicketId = 1;
    private final int ticketId;
    private final Seat seat;
    private final Movie movie;
    private final ShowTime show;

    public MovieTicket(Seat seat, Movie movie, ShowTime show) {
        this.ticketId = nextTicketId++;
        this.seat = seat;
        this.movie = movie;
        this.show = show;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Seat getSeat() {
        return seat;
    }

    public Movie getMovie() {
        return movie;
    }

    public ShowTime getShow() {
        return show;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketId + ": " + movie.getTitle() + " at " + show.getStartTime() + ", Seat: " + seat.getSeatNo();
    }
}
