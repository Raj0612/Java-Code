package DesignPatterns.Behavioral.State.digitalocean;

public class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }

}
