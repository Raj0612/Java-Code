package Educative.MovieBookingSystem.accounts;

import Educative.MovieBookingSystem.catalogs.Catalog;
import Educative.MovieBookingSystem.moviedetails.Hall;
import Educative.MovieBookingSystem.moviedetails.Movie;
import Educative.MovieBookingSystem.moviedetails.ShowTime;

public class Admin extends Person {
    private final Catalog catalog;

    public Admin(String name, String address, String phone, String email, Catalog catalog) {
        super(name, address, phone, email);
        this.catalog = catalog;
    }

    public boolean addShow(ShowTime show, Hall hall) {
        boolean added = hall.addShow(show);
        if (added) {
            show.getMovie().addShow(show);
            System.out.println("Show added by admin.");
        } else {
            System.out.println("Failed to add show due to overlap.");
        }
        return added;
    }

    public boolean updateShow(ShowTime oldShow, ShowTime newShow, Hall hall) {
        if (hall.removeShow(oldShow)) {
            boolean added = hall.addShow(newShow);
            if (added) {
                oldShow.getMovie().removeShow(oldShow);
                newShow.getMovie().addShow(newShow);
                System.out.println("Show updated by admin.");
                return true;
            } else {
                // rollback removal
                hall.addShow(oldShow);
            }
        }
        System.out.println("Failed to update show.");
        return false;
    }

    public boolean deleteShow(ShowTime show, Hall hall) {
        boolean removed = hall.removeShow(show);
        if (removed) {
            show.getMovie().removeShow(show);
            System.out.println("Show deleted by admin.");
        }
        return removed;
    }

    public boolean addMovie(Movie movie) {
        return catalog.addMovie(movie);
    }

    public boolean deleteMovie(Movie movie) {
        return catalog.removeMovie(movie);
    }
}
