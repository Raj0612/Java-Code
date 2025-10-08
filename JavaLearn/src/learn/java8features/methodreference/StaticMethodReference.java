package learn.java8features.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StaticMethodReference {
    public static String saySomething() {
        return "Hello, this is static method.";
    }

    public static int addition(int a, int b){
        return (a + b);
    }

    public static void main(String[] args) {

        ISayable sayable = () -> "Hello, Raj";
        System.out.println("sayable " + sayable.say());

        ISayable sayable1 = StaticMethodReference::saySomething;
        System.out.println("sayable1 " + sayable1.say());



        Function<Integer, Double> sqrt = (Integer input) -> Math.sqrt(input);
        System.out.println("sqrt " + sqrt.apply(4));
        Function<Integer, Double> sqrtRef = Math::sqrt;
        System.out.println("sqrtRef " + sqrtRef.apply(4));

        BiFunction<Integer, Integer, Integer> functionLambda = (a, b) -> StaticMethodReference.addition(a, b);
        System.out.println("functionLambda " + functionLambda.apply(10, 20));

        BiFunction<Integer, Integer, Integer> function = StaticMethodReference::addition;
        System.out.println("function " + function.apply(10, 20));
    }
}
