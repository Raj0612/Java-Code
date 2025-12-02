package DesignPatterns.Structural.Facade.GeekForGeeks;

public class VegNonBothRestaurant implements Hotel {
    public Menus getMenus() {
        BothMenu b = new BothMenu();
        return b;
    }
}
