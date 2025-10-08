package Educative.StackOverFlow.additionalFeatures;

import Educative.StackOverFlow.enums.BadgeLevel;

public class Badge {
    private String name;
    private String description;

    public Badge(String name, String description, BadgeLevel level) {
        this.name = name;
        this.description = description;
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
