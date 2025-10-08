package DesignPatterns.Behavioral.State.baeldung;

public interface PackageState {
    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
