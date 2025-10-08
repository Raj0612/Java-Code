package DesignPatterns.Behavioral.ChainOfResponsibility.numberprocessor;

public class Client {

    public static void main(String[] args) {
        Chain chain = new Chain();

        chain.process(new Number(90));
        System.out.println();
        chain.process(new Number(-50));
        System.out.println();
        chain.process(new Number(0));
        System.out.println();
    }
}
