package DesignPatterns.Structural.Flyweight.coffee;

public class Coffee {
    protected final CoffeeFlavour flavourName;
    protected final CoffeeLatteArt latteArt;
    protected Coffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
        this.flavourName = flavourName;
        this.latteArt = latteArt;
    }

    public CoffeeFlavour getFlavourName() {
        return flavourName;
    }

    public CoffeeLatteArt getLatteArt() {
        return latteArt;
    }
}
