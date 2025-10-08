package Educative.ATM.components;

import Educative.ATM.bank.ATMCard;

public class CardReader {

    ATMCard card = null;

    public void readCard(ATMCard atmCard) {
        if(atmCard == null || atmCard.getCardNumber() == null) {
            System.out.println("Please insert your card.");
        }
        card = atmCard;
        System.out.println("Card inserted. Please enter your PIN.");
    }

    public void ejectCard() {
        card = null;
        System.out.println("Card ejected.");
    }
}
