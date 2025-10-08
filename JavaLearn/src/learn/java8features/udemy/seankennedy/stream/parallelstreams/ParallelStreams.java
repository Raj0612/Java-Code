package learn.java8features.udemy.seankennedy.stream.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        sequentialStream();
        System.out.println();
        parallelStream();
        System.out.println();
        sequentialAddition();
        parallelAddition();
    }
    public static void sequentialAddition() {
        System.out.println("sequentialAddition");
        /*
            Sequential stream
            10 20 30 40 50 60
               30 30 40 50 60
                  60 40 50 60
                    100 50 60
                       150 60
                          210
        */
        // Sequential stream
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                // IntStream has the sum() method so we use
                // the mapToInt() method to map from Stream<Integer>
                // to an IntStream (i.e. a stream of int primitives).
                // IntStream mapToInt(ToIntFunction)
                //    ToIntFunction is a functional interface:
                //       int applyAsInt​(T value)
                        .mapToInt(n -> n.intValue()) 
                      //  .mapToInt(Integer::intValue) 
                      //  .mapToInt(n -> n) 
                        .sum();
        System.out.println("Sum == "+sum); // 210
        System.out.println();
    }
    public static void parallelAddition() {
        System.out.println("parallelAddition");
        Stream<String> animalsStream = Arrays.asList("sheep", "pigs", "horses")
                                           .parallelStream();

//        Stream<String> animalsStream = Stream.of("sheep", "pigs", "horses")
//                                             .parallel(); 
        
        /*
            Parallel stream
            Thread 1        Thread 2
            10 20 30        40 50 60
               30 30           90 60
                  60             150
                       210
        */
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                        .parallel() // Stream<T> method
                        .mapToInt(Integer::intValue) 
                        .sum();
        System.out.println("Sum == "+sum); // 210
        System.out.println();
    }
    public static void sequentialStream() {
        System.out.println("sequentialStream");
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .forEach(System.out::print);// abc
        System.out.println();
    }
    public static void parallelStream() {
        System.out.println("parallelStream");
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .parallel() 
                .forEach(System.out::print);// bca

        System.out.println();
    }
}
