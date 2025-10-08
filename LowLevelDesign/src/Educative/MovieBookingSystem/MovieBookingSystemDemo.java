package Educative.MovieBookingSystem;


import Educative.MovieBookingSystem.accounts.*;
import Educative.MovieBookingSystem.catalogs.*;
import Educative.MovieBookingSystem.moviedetails.*;
import Educative.MovieBookingSystem.payments.*;
import Educative.MovieBookingSystem.seats.*;
import Educative.MovieBookingSystem.theatredetails.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MovieBookingSystemDemo {
    public static void main(String[] args) {
        // Setup city, cinema, halls
        City city = new City("Metropolis", "StateX", 12345);
        Cinema cinema = new Cinema(1, "Grand Cinema", city);
        city.addCinema(cinema);
        Hall hall1 = new Hall(101);
        cinema.addHall(hall1);

        // Create movies
        Movie movie1 = new Movie("Avengers", "Action", LocalDate.of(2025, 7, 1), "English", 150);
        Movie movie2 = new Movie("La Vida", "Drama", LocalDate.of(2025, 6, 15), "Spanish", 120);

        // Get Catalog singleton and add movies
        Catalog catalog = Catalog.getInstance();
        catalog.addMovie(movie1);
        catalog.addMovie(movie2);

        // Register customer for notifications
        Customer customer = new Customer("John Doe", "123 Elm St", "555-1234", "john@example.com");
        catalog.registerObserver(customer);

        // Setup seats for show
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 5; i++) seats.add(new PlatinumSeat("P" + i));
        for (int i = 1; i <= 10; i++) seats.add(new GoldSeat("G" + i));
        for (int i = 1; i <= 20; i++) seats.add(new SilverSeat("S" + i));

        // Create showtime
        LocalDateTime showStart = LocalDateTime.of(2025, 7, 10, 18, 30);
        ShowTime show1 = new ShowTime(showStart, 150, hall1, movie1, seats);

        // Admin adds show
        Admin admin = new Admin("Alice Admin", "456 Oak St", "555-5678", "alice@cinema.com", catalog);
        admin.addShow(show1, hall1);

        // Customer searches movies
        List<Movie> actionMovies = catalog.searchMovieGenre("Action");
        System.out.println("Action movies: " + actionMovies);

        // Customer selects seats and makes booking
        List<Seat> selectedSeats = new ArrayList<>();
        selectedSeats.add(seats.get(0)); // P1
        selectedSeats.add(seats.get(5)); // G1

        List<MovieTicket> tickets = new ArrayList<>();
        for (Seat seat : selectedSeats) {
            tickets.add(new MovieTicket(seat, movie1, show1));
        }

        // Customer pays online with credit card
        Payment payment = new CreditCardPayment(50.0, "John Doe", "1234567812345678", "123 Elm St", 123);
        Booking booking = new Booking(payment, tickets, customer);

        if (customer.createBooking(booking)) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed.");
        }

        // Show available seats after booking
        show1.showAvailableSeats();

        // Cancel booking example
        customer.deleteBooking(booking);
        show1.showAvailableSeats();
    }
}
