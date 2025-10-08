package DesignPatterns.Behavioral.ChainOfResponsibility.upgrad;

public interface Handler {
    void process(String fileType);
    void setHandler(Handler handler);
    String getHandlerName();
}
