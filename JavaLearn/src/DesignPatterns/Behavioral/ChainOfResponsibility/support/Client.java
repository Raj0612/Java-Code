package DesignPatterns.Behavioral.ChainOfResponsibility.support;

public class Client {
    public static void main(String[] args) {
        SupportHandler supportAgent = new SupportAgent();
        SupportHandler supervisor = new Supervisor();
        SupportHandler manager = new Manager();
        supportAgent.setNextHandler(supervisor);
        supervisor.setNextHandler(manager);

        supportAgent.handleRequest("low");
        supportAgent.handleRequest("medium");
        supportAgent.handleRequest("high");
        supportAgent.handleRequest("invalid");
    }
}
