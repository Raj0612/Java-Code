package DesignPatterns.Structural.Adapter.whether;


public class Client {

    public static void main(String[] args) {
        WhetherUI ui = new WhetherUI();
        ui.showTemp(19406);
    }
}
