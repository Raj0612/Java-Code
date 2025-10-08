package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.function.Consumer;

/*
In main() invoke the consumer() method; in consumer() do the following:
        a) Using a lambda expression, implement the Printable interface (typed for String).
        he relevant method just prints out the String argument it receives. Invoke the relevant method, passing in "Printable lambda".

        b) Using both a lambda expression and a method reference, implement 1a using a Consumer.
 */
public class Question1 {

    public static void main(String[] args) {
        new Question1().answerA();
        new Question1().answerB();
    }
    private void answerA() {
        Printable<String> printableL = s -> System.out.println(s);
        Printable<String> printableMR = System.out::println;
        String input = "Printable lambda";
        printableL.print(input);
        printableMR.print((input));
    }

    private interface Printable<T> {
        void print(T t);
    }

    private void answerB() {
        Consumer<String> consumerL = s -> System.out.println(s);
        Consumer<String> consumerMR = System.out::println;
        String input = "Consumer lambda";
        consumerL.accept(input);
        consumerMR.accept(input);
    }
}
