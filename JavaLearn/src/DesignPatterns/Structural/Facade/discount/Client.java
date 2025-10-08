package DesignPatterns.Structural.Facade.discount;

public class Client {
    public static void main(String[] args) {
        DiscountFacade facade = new DiscountFacade();
        boolean isDiscountApplied = facade.applyDiscount(
                new ApplyDiscountRequest(1L, 1L, 1L));

        System.out.println("isDiscountApplied " + isDiscountApplied);


    }
}
