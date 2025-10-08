package LowLevelDesign.GitLab.Shrayansh8.DesignATM.AmountWithdrawal;

import LowLevelDesign.GitLab.Shrayansh8.DesignATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;

    }

    public void withdraw(ATM atm, int remainingAmount) {
        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
