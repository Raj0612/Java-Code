package DesignPatterns.Behavioral.ChainOfResponsibility.support;

public class SupportAgent extends SupportHandler{
    @Override
    public void handleRequest(String priority) {
        if("low".equals(priority)){
            System.out.println("Ticket handled by support agent");
        }else if(nextHandler!=null){
            nextHandler.handleRequest(priority);
        }
    }
}
