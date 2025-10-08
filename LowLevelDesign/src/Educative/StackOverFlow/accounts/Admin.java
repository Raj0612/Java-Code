package Educative.StackOverFlow.accounts;

import Educative.StackOverFlow.enums.AccountStatus;
import Educative.StackOverFlow.additionalFeatures.Badge;

public class Admin extends User {
    public Admin(Account account) { super(account); }

    public boolean blockUser(User user) {
        user.getAccount().setStatus(AccountStatus.BLOCKED);
        return true;
    }

    public boolean unblockUser(User user) {
        user.getAccount().setStatus(AccountStatus.ACTIVE);
        return true;
    }

    public void awardBadge(User user, Badge badge) {
        user.addBadge(badge);
    }
}