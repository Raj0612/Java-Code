package java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

//UnaryOperator<T> extends Function<T, T> is a functional interface that has a single abstract method: T apply(T t) which accepts a single argument and returns a result
//BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface that has a single abstract method: T apply(T t1, T t2) which accepts two arguments and returns a result
//Input and output type must be same
public class UnaryOperatorAndBinaryOperator {

    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = i -> i * 2; // UnaryOperator<Integer>
        System.out.println("UnaryOperator : " + unaryOperator.apply(2));

        BinaryOperator<Integer> binaryOperator = (i1, i2) -> i1 + i2; // BinaryOperator<Integer>
        System.out.println("BinaryOperator : " + binaryOperator.apply(2, 2));
    }
}
