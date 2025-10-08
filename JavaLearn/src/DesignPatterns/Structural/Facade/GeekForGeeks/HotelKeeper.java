package DesignPatterns.Structural.Facade.GeekForGeeks;

public interface HotelKeeper {
    public VegMenu getVegMenu();
    public NonVegMenu getNonVegMenu();
    public Both getVegNonMenu();
}
