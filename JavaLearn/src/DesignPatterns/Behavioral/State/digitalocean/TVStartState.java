package DesignPatterns.Behavioral.State.digitalocean;

public class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }

}
