package learn.javafeatures.comparatorVScomparable.comparator.movie;

import java.util.Comparator;

public class Rating implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {

        // Sort by rating in descending order
        return Double.compare(m2.getR(), m1.getR());
    }
}
