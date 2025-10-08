package Educative.StockBrokerage.payments;

public class Check extends TransferMoney {
    private String checkNumber;
    public Check(int id, int fromAccount, int toAccount, String checkNumber) {
        super(id, fromAccount, toAccount);
        this.checkNumber = checkNumber;
    }
    @Override
    public boolean initiateTransaction() {
        // Simulate transfer
        return true;
    }
}
