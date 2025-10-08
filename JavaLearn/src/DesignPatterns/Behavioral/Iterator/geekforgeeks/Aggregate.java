package DesignPatterns.Behavioral.Iterator.geekforgeeks;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}
