package Educative.StockBrokerage.payments;

public class Wire extends TransferMoney {
    private int wire;
    public Wire(int id, int fromAccount, int toAccount, int wire) {
        super(id, fromAccount, toAccount);
        this.wire = wire;
    }
    @Override
    public boolean initiateTransaction() {
        // Simulate transfer
        return true;
    }
}