package DesignPatterns.Behavioral.Observer.refactoringguru;


import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
