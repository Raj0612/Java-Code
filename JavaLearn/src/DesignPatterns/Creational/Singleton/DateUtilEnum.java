package DesignPatterns.Creational.Singleton;

public enum DateUtilEnum {

    INSTANCE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
