package java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiPredicateExample {

    public static void main(String[] args) {

        Predicate<String> predicate = s -> s.startsWith("A");
        System.out.println("Predicate :" + predicate.test("ABC"));

        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2); // BiPredicate<String, String>
        System.out.println("BiPredicate :" + biPredicate.test("ABC", "ABC"));

        BiPredicate<String, Integer> biPredicate2 = (s1, s2) -> s1.length() == s2; // BiPredicate<String, Integer>
        System.out.println("BiPredicate2 :" + biPredicate2.test("ABC", 3));
    }
}
