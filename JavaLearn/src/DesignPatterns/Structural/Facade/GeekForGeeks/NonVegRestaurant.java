package DesignPatterns.Structural.Facade.GeekForGeeks;

public class NonVegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new BothMenu();
    }
}
