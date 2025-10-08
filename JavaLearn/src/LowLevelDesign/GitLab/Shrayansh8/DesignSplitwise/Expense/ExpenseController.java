package LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense;

import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.BalanceSheetController;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.ExpenseSplit;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.Split;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
