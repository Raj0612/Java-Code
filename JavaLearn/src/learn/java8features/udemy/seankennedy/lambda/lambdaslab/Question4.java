package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.function.Function;

/*In main() invoke the function() method; in function() do the following:

        a) Using a lambda expression, implement the Functionable interface - the input type is Integer and the return type is String.
        The relevant method returns the number passed in appended to the String “Number is: ”. Invoke the relevant method passing in 25.

        b) Using a lambda expression, implement 4a using a Function.
 */
public class Question4 {
    public static void main(String[] args) {
        new Question4().answerA();
        new Question4().answerB();
    }

    private void answerA() {
        Functionable<Integer, String> functionable = value -> "Number is:" + value;
        System.out.println(functionable.applyThis(25));
    }

    private void answerB() {
        Function<Integer, String> function = value -> "Number is:" + value;
        System.out.println(function.apply(25));
    }

    private interface Functionable<T, R> {
        R applyThis(T t);
    }
}
