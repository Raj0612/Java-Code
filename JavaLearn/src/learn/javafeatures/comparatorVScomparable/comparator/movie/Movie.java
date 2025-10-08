package learn.javafeatures.comparatorVScomparable.comparator.movie;

public class Movie {
    private String n; // Movie name
    private double r; // Movie rating
    private int y;    // Movie year

    // Constructor to initialize movie details
    public Movie(String n, double r, int y) {
        this.n = n;
        this.r = r;
        this.y = y;
    }

    // Getter methods
    public String getN() {
        return n;
    }
    public double getR() {
        return r;
    }
    public int getY() {
        return y;
    }
}
