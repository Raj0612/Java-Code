package Educative.ATM.bank;

public class ATMRoom {
    private ATM atm;
    private User user;

    public ATMRoom(ATM atm, User user) {
        this.atm = atm;
        this.user = user;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
