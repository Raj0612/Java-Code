package DesignPatterns.Structural.Facade.GeekForGeeks;

public class Client {

    public static void main(String[] args) {

        HotelKeeper keeper = new HotelKeeperImplementation();

        System.out.println("=== VEG MENU ===");
        keeper.getVegMenu().getItems().forEach(System.out::println);

        System.out.println("\n=== NON-VEG MENU ===");
        keeper.getNonVegMenu().getItems().forEach(System.out::println);

        System.out.println("\n=== VEG + NON-VEG MENU ===");
        keeper.getVegNonMenu().getItems().forEach(System.out::println);
    }
}
