package java8.streams;

import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {
        //generate
        Stream<Integer> ones = Stream.generate(() -> 1).limit(5);
        ones.forEach(System.out::println);// 1 1 1 1 1

        Stream<Boolean> bools = Stream.generate(() -> Math.random() > 0.5).limit(5);
        bools.forEach(System.out::println);// true false true false true

    }

}
