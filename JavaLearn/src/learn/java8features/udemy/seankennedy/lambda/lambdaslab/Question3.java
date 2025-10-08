package learn.java8features.udemy.seankennedy.lambda.lambdaslab;

import java.util.function.Predicate;


/*In main() invoke the predicate() method; in predicate() do the following:

        a) Using a lambda expression, implement the Evaluate interface (typed for Integer).
        The relevant method returns true if the argument passed is < 0, otherwise it returns false. Invoke the relevant method twice – the first time pass in -1 and the second time pass in +1

        b) Using a lambda expression, implement 3a using a Predicate.

        c) Declare a generically-typed check() method (not in UML).
        The first parameter is generic and the second parameter is a Predicate, also generically typed. The check() method returns true/false.
         Invoke the check() method with the following Predicate lambda expressions:

        - we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).

        - we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and “Ms. Ann Bloggs”

        - we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33 and 1.8 (metres assumed) in height;
            and “Ann” who is 13 and 1.4 (metres) in height.*/
public class Question3 {

    public static void main(String[] args) {
        new Question3().answerA();
        new Question3().answerB();
        new Question3().answerC();
    }

    private void answerA() {
        Evaluate<Integer> evaluateL = v -> v < 0;
        System.out.println(evaluateL.isNegative(-1));
        System.out.println(evaluateL.isNegative(+1));
    }

    private void answerB() {
        Predicate<Integer> integerPredicate = v -> v < 0;
        System.out.println(integerPredicate.test(-1));
        System.out.println(integerPredicate.test(+1));
    }

    private void answerC() {
        Predicate<Integer> isNegative = v -> v < 0;
        System.out.println(check(-1, isNegative));
        Predicate<String> isMrPrefix = s -> s.startsWith("Mr.");
        System.out.println(check("Mr. Joe Bloggs", isMrPrefix));
        System.out.println(check("Ms. Ann Bloggs", isMrPrefix));
        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        Person mike = new Person("Mike" , 1.8f ,33);
        Person ann = new Person("Ann" , 1.4f ,13);
        System.out.println(check(mike, isAdult));
        System.out.println(check(ann, isAdult));
    }

    private class Person {

        private String name = "";
        private float heightInMeters = 0;
        private int age = 0;

        public Person(String name, float heightInMeters, int age){
            this.name = name;
            this.heightInMeters = heightInMeters;
            this.age = age;
        };

        public String getName() {
            return name;
        }

        public float getHeightInMeters() {
            return heightInMeters;
        }

        public int getAge() {
            return age;
        }
    }


    private interface Evaluate<T> {
        boolean isNegative(T t);
    }

    private <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
