package DesignPatterns.Structural.Facade.GeekForGeeks;

public class NonVegRestaurant implements Hotel {
    public Menus getMenus() {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }
}
