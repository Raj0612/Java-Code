package Educative.RestaurantManagement.payments;

public class Bill {

    private int billId;
    private float amount;
    private float tip;
    private float tax;
    private boolean isPaid;

    public Bill(int billId, float amount, float tip, float tax, boolean isPaid) {
        this.billId = billId;
        this.amount = amount;
        this.tip = tip;
        this.tax = tax;
        this.isPaid = isPaid;
    }

    public boolean generateBill() {
        // Bill calculation logic (placeholder)
        return true;
    }

    public boolean payBill() {
        // Bill payment logic (placeholder)
        return true;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTip() {
        return tip;
    }

    public void setTip(float tip) {
        this.tip = tip;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
