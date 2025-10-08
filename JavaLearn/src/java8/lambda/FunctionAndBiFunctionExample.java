package java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

//Function<T, R> is a functional interface that has a single abstract method: R apply(T t) which accepts a single argument and returns a result
//BiFunction<T, U, R> is a functional interface that has a single abstract method: R apply(T t, U u) which accepts two arguments and returns a result
public class FunctionAndBiFunctionExample {

    public static void main(String[] args) {

        Function<String, String> function = s -> s.toUpperCase(); // Function<String, String>
        System.out.println("Function : " + function.apply("Hello World"));

        BiFunction<String, String, String> biFunction = (s1, s2) -> s1.concat(s2); // BiFunction<String, String, String>
        System.out.println("BiFunction : " + biFunction.apply("Hello World", "Hello World"));

        BiFunction<String, String, String> biFunction2 = String::concat; // BiFunction<String, String, String>
        System.out.println("BiFunction2 : " + biFunction2.apply("Hello World", "Hello World"));

        BiFunction<Integer, String, String> biFunc1 = (age, name) -> "Name: " + name + ", Age: " + age;
        System.out.println("BiFunction3 : " + biFunc1.apply(25, "John"));

    }
}
