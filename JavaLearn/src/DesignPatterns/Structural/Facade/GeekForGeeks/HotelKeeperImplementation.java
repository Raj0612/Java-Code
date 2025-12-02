package DesignPatterns.Structural.Facade.GeekForGeeks;

public class HotelKeeperImplementation implements HotelKeeper {
    @Override
    public VegMenu getVegMenu() {
        return (VegMenu) new VegRestaurant().getMenus();
    }

    @Override
    public NonVegMenu getNonVegMenu() {
        return (NonVegMenu) new NonVegRestaurant().getMenus();
    }

    @Override
    public BothMenu getVegNonMenu() {
        return (BothMenu) new VegNonBothRestaurant().getMenus();
    }
}
