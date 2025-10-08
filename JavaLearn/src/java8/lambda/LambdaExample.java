package java8.lambda;

import java.util.function.Predicate;

public class LambdaExample {

    public static void main(String[] args) {

        LambdaInterface<Integer> lambdaInterface = i -> i % 2 == 0;
        System.out.println("LambdaInterface Integer " +lambdaInterface.test(2));

        LambdaInterface<String> stringLambda = str -> { return str.equals("abc");};
        System.out.println("LambdaInterface String " + stringLambda.test("abcd"));

        Predicate<Integer> predicate = i -> i % 2 == 0; // lambda expression is converted to Predicate interface>
        System.out.println("Predicate Integer : " + predicate.test(2));

        Predicate<String> stringPredicate = str -> str.equals("abc");
        System.out.println("Predicate String : " + stringPredicate.test("abc"));

        System.out.println("Passing Lambda to a function : " + check(6,  i -> i % 2 == 0));
    }

    public static <T> boolean check(T t, LambdaInterface<T> lambdaInterface) {
        return lambdaInterface.test(t);
    }
}

interface LambdaInterface<T> {
    boolean test(T i);
}
