package DesignPatterns.Structural.Adapter.card;


public class Client {
    public static void main(String[] args) {
        CreditCard targetInterface=new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.print(targetInterface.getCreditCard());
    }
}
