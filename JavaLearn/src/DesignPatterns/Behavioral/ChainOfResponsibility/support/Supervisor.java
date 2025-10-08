package DesignPatterns.Behavioral.ChainOfResponsibility.support;

public class Supervisor extends SupportHandler{
    @Override
    public void handleRequest(String priority) {
        if("medium".equals(priority)){
            System.out.println("Ticket handled by supervisor");
        }else if(nextHandler!=null){
            nextHandler.handleRequest(priority);
        }
    }
}

