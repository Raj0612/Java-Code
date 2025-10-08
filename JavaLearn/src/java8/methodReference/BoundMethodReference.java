package java8.methodReference;

import java.util.function.Predicate;
import java.util.function.Supplier;

// Bound method reference is a method reference that is bound to an instance
public class BoundMethodReference {
    public static void main(String[] args) {
        String name = "Mr. Joe Bloggs";
        Supplier<String> lowerL   = () -> name.toLowerCase();
        System.out.println("Supplier lowerL : " + lowerL.get());
        Supplier<String> lowerMR  = name::toLowerCase;
        System.out.println("Supplier lowerMR : " + lowerMR.get());

        Predicate<String> titleL = (title) -> name.startsWith(title);
        System.out.println("Predicate titleL : " + titleL.test("Mr."));

        Predicate<String> startsWithA = name::startsWith; // Predicate<String>
        System.out.println("Predicate startsWithA : " + startsWithA.test("Mr."));
    }
}
