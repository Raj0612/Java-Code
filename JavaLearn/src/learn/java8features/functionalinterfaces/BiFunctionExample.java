package learn.java8features.functionalinterfaces;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum = " + add.apply(2, 3));

        add = add.andThen(a -> 2 * a);
        System.out.println("add = " + add.apply(2, 3));

    }
}
