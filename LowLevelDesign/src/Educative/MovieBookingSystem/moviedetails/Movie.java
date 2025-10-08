package Educative.MovieBookingSystem.moviedetails;

import java.time.LocalDate;
import java.util.*;

public class Movie {
    private final String title;
    private final String genre;
    private final LocalDate releaseDate;
    private final String language;
    private final int duration; // in minutes
    private final List<ShowTime> shows;

    public Movie(String title, String genre, LocalDate releaseDate, String language, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.language = language;
        this.duration = duration;
        this.shows = new ArrayList<>();
    }

    public void addShow(ShowTime show) {
        shows.add(show);
    }

    public void removeShow(ShowTime show) {
        shows.remove(show);
    }

    public List<ShowTime> getShows() {
        return Collections.unmodifiableList(shows);
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " (" + language + ", " + genre + ", Released: " + releaseDate + ")";
    }
}
