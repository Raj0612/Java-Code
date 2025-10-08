package DesignPatterns.Behavioral.State.refactoringguru;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
