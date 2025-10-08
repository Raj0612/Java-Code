package DesignPatterns.Structural.Adapter.creditcard;


public class Client {

    public static void main(String[] args) {
        CreditCard cc = new Customer();
        cc.giveBankDetails();
        System.out.println(cc.getCreditCard());
    }
}
