package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.function.Supplier;
/*In main() invoke the supplier() method; in supplier() do the following:

        a) Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant method just returns 77. Invoke the relevant method.

        b) Using a lambda expression, implement 2a using a Supplier.
   */
public class Question2 {

    public static void main(String[] args) {
        new Question2().answerA();
        new Question2().answerB();
    }

    private void answerA() {
        Integer value = 77;
        Retrievable<Integer> retrievableL = () -> value;
        Retrievable<Integer> retrievableMR = value::intValue;
        System.out.println("Retrievable: " + (77 == retrievableL.retrieve()));
        System.out.println("Retrievable: " + (77 == retrievableMR.retrieve()));
    }

    private interface Retrievable<T> {
        T retrieve();
    }

    private void answerB() {
        Supplier<Integer> supplier = () -> 77;
        System.out.println("Supplier " + (77 == supplier.get()));
    }
}
