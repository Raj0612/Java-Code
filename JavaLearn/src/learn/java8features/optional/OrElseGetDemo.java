package learn.java8features.optional;

import java.util.Optional;

public class OrElseGetDemo {
    public static void main(String[] args) {

        // Example 1: Value is present
        Optional<String> name = Optional.of("Alice");

        String result1 = name.orElseGet(() -> getDefaultName());
        System.out.println("Result 1: " + result1);
        // Output: Alice


        // Example 2: Value is absent
        Optional<String> emptyName = Optional.empty();

        String result2 = emptyName.orElseGet(() -> getDefaultName());
        System.out.println("Result 2: " + result2);
        // Output: Default User


        // Example 3: Using ofNullable()
        String value = null;
        Optional<String> optionalValue = Optional.ofNullable(value);

        String result3 = optionalValue.orElseGet(() -> "Generated Default");
        System.out.println("Result 3: " + result3);
        // Output: Generated Default


        // Example 4: Demonstrating performance benefit
        Optional<String> presentValue = Optional.of("Bob");

        // orElse() will call getDefaultName() even if not needed
        String res1 = presentValue.orElse(getDefaultName()); // getDefaultName() runs unnecessarily

        // orElseGet() will NOT call getDefaultName() if value present
        String res2 = presentValue.orElseGet(() -> getDefaultName()); // Supplier NOT called

        System.out.println("res1: " + res1);
        System.out.println("res2: " + res2);
    }

    // Simulate an expensive computation
    private static String getDefaultName() {
        System.out.println("getDefaultName() called...");
        return "Default User";
    }
}
