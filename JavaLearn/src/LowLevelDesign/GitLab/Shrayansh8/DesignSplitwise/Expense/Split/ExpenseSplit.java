package LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {

    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
