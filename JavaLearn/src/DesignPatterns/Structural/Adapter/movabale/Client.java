package DesignPatterns.Structural.Adapter.movabale;


public class Client {
    public static void main(String[] args) {
        Movable bmw = new BMW();
        MovableAdapter bmwAdapter = new MovableAdapterImpl(bmw);

        System.out.println("Result in km : " + bmwAdapter.getSpeed());
    }
}
