package LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.User;
import LowLevelDesign.GitLab.Shrayansh8.DesignSplitwise.UserExpenseBalanceSheet;

public class User {

    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId = id;
        this.userName = userName;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }
    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
}
