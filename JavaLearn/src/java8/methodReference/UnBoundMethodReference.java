package java8.methodReference;

import java.util.function.Function;

//Unbound method reference is  a method reference that is not bound to an instance
public class UnBoundMethodReference {

    public static void main(String[] args) {
        Function<String, String> upperCase = String::toUpperCase; // Function<String, String>
        Function<String, String> upper = s -> s.toUpperCase();

        System.out.println("upperCase : " + upperCase.apply("Hello World"));
    }
}
