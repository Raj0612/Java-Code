package Educative.HotelManagement.invoices;

public class Invoice {
    private double amount;
    public Invoice(double amount) {
        this.amount = amount;
    }
    public boolean createBill() {
        System.out.println("Bill created: $" + amount);
        return true;
    }
    public void addAmount(double amt) {
        this.amount += amt;
    }
    public double getAmount() {
        return amount;
    }
}
