package java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = list.stream()
                .filter(x -> x % 2 == 0)              // filter even numbers
                .map(x -> x * x)                      // square each number
                .distinct()                           // remove duplicates
                .sorted(Comparator.reverseOrder())    // sort in descending order
                .peek(System.out::println)            // print each element (for debugging)
                .skip(1)                           // skip the first element
                .limit(3)                      // take next 3 elements
                .collect(Collectors.toList());

        System.out.println("result: " + result);

        //flatMap
        List<List<String>> list1 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );

        System.out.println("list1: " + list1);

        List<String> flat = list1.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("flat: " + flat); //Output: ["a", "b", "c", "d"]

    }
}
