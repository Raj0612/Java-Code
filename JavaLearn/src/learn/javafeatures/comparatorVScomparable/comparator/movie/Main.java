package learn.javafeatures.comparatorVScomparable.comparator.movie;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Create a list of movies
        ArrayList<Movie> m = new ArrayList<>();
        m.add(new Movie("Force Awakens", 8.3, 2015));
        m.add(new Movie("Star Wars", 8.7, 1977));
        m.add(new Movie("Empire Strikes Back", 8.8, 1980));

        // Sort movies by rating and display all
        Collections.sort(m, new Rating());
        System.out.println("Movies sorted by rating:");
        for (Movie m1 : m) {
            System.out.println(m1.getR() + " " + m1.getN() + " " + m1.getY());
        }

        // Sort movies by name and display all
        Collections.sort(m, new NameCompare());
        System.out.println("\nMovies sorted by name:");
        for (Movie m1 : m) {
            System.out.println(m1.getN() + " " + m1.getR() + " " + m1.getY());
        }
    }
}
