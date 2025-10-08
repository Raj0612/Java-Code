package DesignPatterns.Behavioral.Iterator.RefactoringGuru;

public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
