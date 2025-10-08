package LowLevelDesign.GitLab.Shrayansh8.DesignATM;

public enum TransactionType {

    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes(){

        for(TransactionType type: TransactionType.values()){
            System.out.println("Choose the transaction: " + type.name());
        }
    }
}
