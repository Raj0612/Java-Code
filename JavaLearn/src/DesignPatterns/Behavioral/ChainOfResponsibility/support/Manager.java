package DesignPatterns.Behavioral.ChainOfResponsibility.support;

public class Manager extends SupportHandler{
    @Override
    public void handleRequest(String priority) {
        if("high".equals(priority)){
            System.out.println("Ticket handled by Manager");
        }else if(nextHandler!=null){
            nextHandler.handleRequest(priority);
        }else{
            System.out.println("Invalid Ticket");
        }
    }
}
