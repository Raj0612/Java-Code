package DesignPatterns.Behavioral.State.gumballstate;

public class Client {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(2);

        System.out.println(gumballMachine);
        System.out.println("********************************");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
        System.out.println("********************************");

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.refill(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
