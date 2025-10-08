package learn.javafeatures.comparatorVScomparable.comparable.movie;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Create a list of movies
        ArrayList<Movie> l = new ArrayList<>();
        l.add(new Movie("Star Wars", 8.7, 1977));
        l.add(new Movie("Empire Strikes Back", 8.8, 1980));
        l.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sort movies using Comparable's
        // compareTo method by year
        Collections.sort(l);

        // Display the sorted list of movies
        System.out.println("Movies after sorting by year:");
        for (Movie m : l) {

            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(5);
        l1.add(4);

        Collections.sort(l1);
        System.out.println("Sort " + l1);

    }
}
