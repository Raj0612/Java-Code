package DesignPatterns.Behavioral.State.gumballstatewinner;

//State Interface or Base Class
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();

    public void refill();
}
