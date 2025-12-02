package DesignPatterns.Structural.Facade.GeekForGeeks;

public interface HotelKeeper {
    VegMenu getVegMenu();
    NonVegMenu getNonVegMenu();
    BothMenu getVegNonMenu();
}
