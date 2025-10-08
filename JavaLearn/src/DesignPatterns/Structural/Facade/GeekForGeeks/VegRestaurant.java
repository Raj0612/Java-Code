package DesignPatterns.Structural.Facade.GeekForGeeks;

public class VegRestaurant implements Hotel {
    public Menus getMenus()  {
        VegMenu v = new VegMenu();
        return v;
    }
}
