package DesignPatterns.Behavioral.ChainOfResponsibility.GeekForGeeks;

public interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}
