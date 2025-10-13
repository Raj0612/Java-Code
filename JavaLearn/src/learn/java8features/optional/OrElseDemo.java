package learn.java8features.optional;

import java.util.Optional;

public class OrElseDemo {

    public static void main(String[] args) {
        // Example 1: Value is present
        Optional<String> name = Optional.of("Alice");

        String result1 = name.orElse("Default Name");
        System.out.println("Result 1: " + result1);
        // Output: Alice


        // Example 2: Value is absent (empty Optional)
        Optional<String> emptyName = Optional.empty();

        String result2 = emptyName.orElse("Default Name");
        System.out.println("Result 2: " + result2);
        // Output: Default Name


        // Example 3: Using ofNullable() (handles null safely)
        String value = null;
        Optional<String> optionalValue = Optional.ofNullable(value);

        String result3 = optionalValue.orElse("Fallback Value");
        System.out.println("Result 3: " + result3);
        // Output: Fallback Value


        // Example 4: Combining with map()
        Optional<String> userInput = Optional.of("  bob  ");
        String processed = userInput
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");

        System.out.println("Processed Value: " + processed);
        // Output: BOB
    }

}
