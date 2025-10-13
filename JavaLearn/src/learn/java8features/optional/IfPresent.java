package learn.java8features.optional;

import java.util.Optional;

public class IfPresent {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Alice");

        name.ifPresentOrElse(
                n -> System.out.println("Hello, " + n),   // Consumer action
                () -> System.out.println("Name not found") // Runnable emptyAction
        );

        // Example 2: Value is absent
        Optional<String> emptyName = Optional.empty();

        emptyName.ifPresentOrElse(
                n -> System.out.println("Hello, " + n),
                () -> System.out.println("Name not found")
        );

        // Example 3: Combining with map() and ifPresentOrElse()
        Optional<String> userInput = Optional.ofNullable("  bob  ");

        userInput
                .map(String::trim)         // trim whitespace
                .map(String::toUpperCase)  // convert to uppercase
                .ifPresentOrElse(
                        val -> System.out.println("Processed value: " + val),
                        () -> System.out.println("No input provided")
                );

        // Example 4: Empty optional through ofNullable
        Optional<String> nullValue = Optional.ofNullable(null);

        nullValue.ifPresentOrElse(
                val -> System.out.println("Found value: " + val),
                () -> System.out.println("Value is missing")
        );

        // Example 5: ifPresent() alone
        Optional<Integer> number = Optional.of(42);
        number.ifPresent(n -> System.out.println("Number = " + n));

    }
}
