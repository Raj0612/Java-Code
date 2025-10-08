package Educative.Locker1.model;

import java.util.Objects;

public record User(String userId, String name, String email) {
    // Compact constructor for validation
    public User {
        Objects.requireNonNull(userId, "User ID cannot be null");
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(email, "Name cannot be null");
        if (userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be blank");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
    }

    // Custom methods can be added here
    public String getFormattedInfo() {
        return String.format("User ID: %s, Name: %s, Email: %s", userId, name, email);
    }
}
