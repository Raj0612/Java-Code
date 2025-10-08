package learn.java8features.streamapi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterByObjectIndex {

    public static void filterByIndexUsingAtomic(){
        String[] myArray
                = new String[] { "stream",   "is",  "a",
                "sequence", "of",  "elements",
                "like",     "list" };

        Stream<String> myStream = Stream.of(myArray);

        AtomicInteger i = new AtomicInteger(0);
        myStream.filter(x -> i.getAndIncrement() % 2 == 0)
                .forEach(System.out::println);


        IntStream.rangeClosed(0, myArray.length - 1)
                .filter(x -> x % 2 == 0)
                .mapToObj(x -> myArray[x])
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        filterByIndexUsingAtomic();
    }
}
