package Educative.StackOverFlow.additionalFeatures;

import java.util.Objects;

public class Tag {
    private String name;
    private String description;

    public Tag(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // equals and hashCode for use in HashMap/HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return name.equalsIgnoreCase(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
