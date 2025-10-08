package DesignPatterns.Structural.Adapter.creditcard;

public class Customer extends BankDetails implements CreditCard {
    @Override
    public void giveBankDetails() {
            setBankName("CITI");
            setAccHolderName("Raj");
            setAccNumber("123");
    }

    @Override
    public String getCreditCard() {
        return getAccHolderName() + " is validated for using the credit card from " + getBankName();
    }
}
