package java8.lambda;

import java.time.LocalTime;
import java.util.function.Supplier;

//Supplier is a functional interface that has a single abstract method: T get() which accepts no arguments and returns a result
public class SupplierExample {
    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hello World";
        System.out.println("Supplier : " +  supplier.get());

        Supplier<StringBuilder> supStrB  = () -> new StringBuilder();
        System.out.println("Supplier supStrB : " +  supStrB.get().append("Hello World"));

        Supplier<LocalTime> supTime = () -> LocalTime.now(); // Supplier<LocalTime>
        System.out.println("Supplier supTime : " +  supTime.get());
    }
}
