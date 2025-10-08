package GeekForGeeks.DesignParkingLot.payment;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void initiateTransaction() {
        System.out.println("Processing credit card payment of $"+ amount);
        this.status = "Completed";
    }
}
