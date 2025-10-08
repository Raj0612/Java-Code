package learn.java8features.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        Predicate<String> p = (s) -> s.startsWith("G");

        for (String st : names) {
            if (p.test(st))
                System.out.println(st);
        }

        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(10));
        //Predicate Chaining
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println("result2 " + result2);

        pred(10, (i) -> i > 7);

    }


    static void pred(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("pred Number " + number);
        }
    }
}
