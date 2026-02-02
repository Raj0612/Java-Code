package Educative.ATM.bank;

import Educative.ATM.components.*;
import Educative.ATM.enums.ATMStatus;
import Educative.ATM.enums.TransactionType;
import Educative.ATM.states.*;

public class ATM {

    private static ATM instance;

    private ATMState currentATMState;
    private ATMState cashWithdrawalState;
    private ATMState checkBalanceState;
    private ATMState idleState;
    private ATMState hasCardState;
    private ATMState selectOperationState;
    private ATMState transferMoneyState;

    private Bank bank;
    private CardReader cardReader;
    private CashDispenser cashDispenser;

    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    private int atmBalance;
    private int noOfHundredDollarBills;
    private int noOfFiftyDollarBills;
    private int noOfTenDollarBills;

    private ATMStatus atmStatus;
    public static synchronized ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }
    private ATM() {
        this.cardReader = new CardReader();
        this.keypad = new Keypad();
        this.screen = new Screen();
        this.printer = new Printer();
        this.atmStatus = ATMStatus.Idle;
        this.currentATMState = new IdleState();
        hasCardState = new HasCardState();
        selectOperationState = new SelectOperationState();
        cashWithdrawalState = new CashWithdrawalState();
        checkBalanceState = new CheckBalanceState();
        transferMoneyState = new TransferMoneyState();
    }

    // References to various ATM components
    public void initializeATM(int atmBalance, int noOfHundredDollarBills, int noOfFiftyDollarBills, int noOfTenDollarBills) {
        this.atmBalance = atmBalance;
        this.noOfHundredDollarBills = noOfHundredDollarBills;
        this.noOfFiftyDollarBills = noOfFiftyDollarBills;
        this.noOfTenDollarBills = noOfTenDollarBills;
        this.cashDispenser = new CashDispenser(noOfHundredDollarBills, noOfFiftyDollarBills, noOfTenDollarBills);
    }

    public boolean dispenseCash(int amount) {
        cashDispenser.dispenseCash(amount);
        return true;
    }

    public BankAccount findAccountByNumber(int accountNumber) {
        if (this.bank != null) {
            return this.bank.findAccountByNumber(accountNumber);
        }
        return null;
    }

    public void setState(ATMState state) {
        this.currentATMState = state;
        if (state instanceof IdleState) {
            atmStatus = ATMStatus.Idle;
        } else if (state instanceof HasCardState) {
            atmStatus = ATMStatus.HasCard;
        } else if (state instanceof SelectOperationState) {
            atmStatus = ATMStatus.SelectionOption;
        } else if (state instanceof CashWithdrawalState) {
            atmStatus = ATMStatus.Withdraw;
        } else if (state instanceof TransferMoneyState) {
            atmStatus = ATMStatus.TransferMoney;
        } else if (state instanceof CheckBalanceState) {
            atmStatus = ATMStatus.BalanceInquiry;
        }
    }

    public void checkBankBalance(ATMCard card) {
        currentATMState.displayBalance(this, card);
    }

    public void insertCard(ATMCard card) {
        currentATMState.insertCard(this, card);
    }
    public void authenticatePin(ATMCard card, int pin) {
        currentATMState.authenticatePin(this, card, pin);
    }
    public void selectOperation(ATMCard card, TransactionType tType) {
        currentATMState.selectOperation(this, card, tType);
    }
    public void cashWithdrawal(ATMCard card, int withdrawAmount) {
        currentATMState.cashWithdrawal(this, card, withdrawAmount);
    }
    public void displayBalance(ATMCard card) {
        currentATMState.displayBalance(this, card);
    }
    public void transferMoney(ATMCard card, int accountNumber, int transferAmount) {
        currentATMState.transferMoney(this, card, accountNumber, transferAmount);
    }

    public void returnCard() {
        currentATMState.returnCard(this);
    }
    public void exit() {
        currentATMState.exit(this);
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public ATMState getCashWithdrawalState() {
        return cashWithdrawalState;
    }

    public void setCashWithdrawalState(ATMState cashWithdrawalState) {
        this.cashWithdrawalState = cashWithdrawalState;
    }

    public ATMState getCheckBalanceState() {
        return checkBalanceState;
    }

    public void setCheckBalanceState(ATMState checkBalanceState) {
        this.checkBalanceState = checkBalanceState;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public void setIdleState(ATMState idleState) {
        this.idleState = idleState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public void setHasCardState(ATMState hasCardState) {
        this.hasCardState = hasCardState;
    }

    public ATMState getSelectOperationState() {
        return selectOperationState;
    }

    public void setSelectOperationState(ATMState selectOperationState) {
        this.selectOperationState = selectOperationState;
    }

    public ATMState getTransferMoneyState() {
        return transferMoneyState;
    }

    public void setTransferMoneyState(ATMState transferMoneyState) {
        this.transferMoneyState = transferMoneyState;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public void setCardReader(CardReader cardReader) {
        this.cardReader = cardReader;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCashDispenser(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public Keypad getKeypad() {
        return keypad;
    }

    public void setKeypad(Keypad keypad) {
        this.keypad = keypad;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public ATMState getState() {
        return currentATMState;
    }

    public ATMStatus getAtmStatus() {
        return atmStatus;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }
}
