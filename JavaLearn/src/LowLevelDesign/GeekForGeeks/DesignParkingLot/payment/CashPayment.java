package LowLevelDesign.GeekForGeeks.DesignParkingLot.payment;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void initiateTransaction() {
        System.out.println("Processing cash payment of $"+ amount);
        this.status = "Completed";
    }
}
