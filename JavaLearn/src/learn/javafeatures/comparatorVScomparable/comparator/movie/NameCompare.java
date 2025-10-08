package learn.javafeatures.comparatorVScomparable.comparator.movie;

import java.util.Comparator;

public class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {

        // Sort by name in alphabetical order
        return m1.getN().compareTo(m2.getN());
    }
}
