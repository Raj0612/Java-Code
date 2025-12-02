package DesignPatterns.Structural.Facade.GeekForGeeks;

public class VegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new VegMenu();
    }
}
