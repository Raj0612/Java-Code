package DesignPatterns.Structural.Adapter.educative;

public class Client {

    public static void main(String[] args) {
        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        Adapter hotAirBalloonAdapter = new Adapter(hotAirBalloon);

        hotAirBalloonAdapter.fly();
    }
}
