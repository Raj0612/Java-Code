package DesignPatterns.Behavioral.Observer.geekforgeeks;

public interface Subject {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
