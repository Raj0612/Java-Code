package Educative.StockBrokerage.payments;

import java.time.LocalDate;

public abstract class TransferMoney {
    protected int id;
    protected LocalDate creationDate;
    protected int fromAccount;
    protected int toAccount;

    public TransferMoney(int id, int fromAccount, int toAccount) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.creationDate = LocalDate.now();
    }
    public abstract boolean initiateTransaction();

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }
}
