package LowLevelDesign.GitLab.Shrayansh8.DesignATM.ATMStates;

import LowLevelDesign.GitLab.Shrayansh8.DesignATM.ATM;
import LowLevelDesign.GitLab.Shrayansh8.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
