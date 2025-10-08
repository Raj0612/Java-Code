package LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense;

import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.EqualExpenseSplit;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.ExpenseSplit;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
