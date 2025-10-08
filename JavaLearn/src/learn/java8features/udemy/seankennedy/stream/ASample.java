package learn.java8features.udemy.seankennedy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ASample {

    public static void main(String[] args) {
        List<Double> temps = Arrays.asList(98.4, 100.2,87.9, 102.8);
        System.out.println("Number of temp > 100 is: " + temps.stream().peek(System.out::println).filter(temp -> temp >100).peek(System.out::println).count());

        Stream.of("Alex", "David","April","Edward").filter(s ->{
            System.out.println("filter: " + s);
            return true;
        }).forEach(s -> System.out.println("foreach: " + s));

        Stream.of("Alex", "David", "Tom", "Edward", "Zack", "April", "Peter")
                .filter(s -> {
                    System.out.println("filter: "+s);
                    return s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map: "+s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: "+s));
    }
}
