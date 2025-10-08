package learn.javafeatures.comparatorVScomparable.comparable.movie;

public class Movie implements Comparable<Movie> {
    private String n; // Movie Name
    private double r; // Movie Rating
    private int y; // Release year of the movie

    // Constructor
    public Movie(String n, double r, int y) {
        this.n = n;
        this.r = r;
        this.y = y;
    }

    // Implementation of the compareTo method
    // for default sorting by year
    public int compareTo(Movie m) {

        // Sort movies in ascending
        // order of year
        return this.y - m.y;
    }

    // Getter and Setter method
    public String getName() {
        return n;
    }

    public double getRating() {
        return r;
    }

    public int getYear() {
        return y;
    }
}
