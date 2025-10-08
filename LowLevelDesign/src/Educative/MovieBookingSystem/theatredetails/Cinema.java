package Educative.MovieBookingSystem.theatredetails;

import Educative.MovieBookingSystem.moviedetails.Hall;

import java.util.*;

public class Cinema {
    private final int cinemaId;
    private final String name;
    private final List<Hall> halls;
    private final City city;

    public Cinema(int cinemaId, String name, City city) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.city = city;
        this.halls = new ArrayList<>();
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Hall> getHalls() {
        return Collections.unmodifiableList(halls);
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }
}
