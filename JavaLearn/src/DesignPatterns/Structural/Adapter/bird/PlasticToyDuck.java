package DesignPatterns.Structural.Adapter.bird;

public class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("PlasticToyDuck Squeak");
    }
}
