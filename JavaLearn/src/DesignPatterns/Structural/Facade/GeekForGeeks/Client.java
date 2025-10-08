package DesignPatterns.Structural.Facade.GeekForGeeks;

public class Client {

    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both Both = keeper.getVegNonMenu();

    }
}
