package learn.java8features.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrElseThrowDemo {
    public static void main(String[] args) {

        // Example 1: Value is present
        Optional<String> name = Optional.of("Alice");

        String result1 = name.orElseThrow(() -> new IllegalArgumentException("Name not found!"));
        System.out.println("Result 1: " + result1);
        // Output: Alice


        // Example 2: Value is absent
        Optional<String> emptyName = Optional.empty();

        try {
            String result2 = emptyName.orElseThrow(() -> new NoSuchElementException("No value present!"));
            System.out.println("Result 2: " + result2);
        } catch (NoSuchElementException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // Example 3: Using custom exception
        try {
            Optional<String> user = Optional.empty();
            String username = user.orElseThrow(UserNotFoundException::new);
            System.out.println(username);
        } catch (UserNotFoundException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }

    // Custom exception class
    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("User not found in database!");
        }
    }
}
