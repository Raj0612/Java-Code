package Educative.StockBrokerage.payments;

public class ElectronicBank extends TransferMoney {
    private String bankName;
    public ElectronicBank(int id, int fromAccount, int toAccount, String bankName) {
        super(id, fromAccount, toAccount);
        this.bankName = bankName;
    }
    @Override
    public boolean initiateTransaction() {
        // Simulate transfer
        return true;
    }
}