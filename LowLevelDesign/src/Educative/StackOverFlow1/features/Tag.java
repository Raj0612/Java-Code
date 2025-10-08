package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tag {
    private final String name;
    private final String description;
    private final String createdBy;
    private final LocalDateTime createdAt;

    public Tag(String name, String description, User createdBy) {
        this.name = name.trim().toLowerCase();
        this.description = description;
        this.createdBy = createdBy.getUsername();
        this.createdAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Tag))
            return false;
        Tag tag = (Tag) o;
        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
