package Educative.ATM.bank;

public class User {
    private ATMCard card;
    private BankAccount account;

    public User(ATMCard card, BankAccount account) {
        this.card = card;
        this.account = account;
    }

    public ATMCard getCard() {
        return card;
    }

    public void setCard(ATMCard card) {
        this.card = card;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
