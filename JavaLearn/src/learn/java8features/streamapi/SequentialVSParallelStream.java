package learn.java8features.streamapi;

import java.util.Arrays;
import java.util.List;

public class SequentialVSParallelStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello ",
                "G", "E", "E", "K", "S!");

        list.stream().forEach(System.out::print);
        System.out.println();
        list.parallelStream().forEach(System.out::print);
        System.out.println();
        list.parallelStream().forEachOrdered(System.out::print);
    }
}
