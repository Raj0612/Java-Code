package Educative.MovieBookingSystem.theatredetails;

import java.util.*;

public class City {
    private final String name;
    private final String state;
    private final int zipCode;
    private final List<Cinema> cinemas;

    public City(String name, String state, int zipCode) {
        this.name = name;
        this.state = state;
        this.zipCode = zipCode;
        this.cinemas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public List<Cinema> getCinemas() {
        return Collections.unmodifiableList(cinemas);
    }

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }
}
