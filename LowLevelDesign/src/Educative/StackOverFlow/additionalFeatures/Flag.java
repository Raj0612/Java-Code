package Educative.StackOverFlow.additionalFeatures;

import Educative.StackOverFlow.accounts.User;

import java.time.LocalDate;

public class Flag {
    private User flaggedBy;
    private String reason;
    private LocalDate flaggedAt;

    public Flag(User flaggedBy, String reason) {
        this.flaggedBy = flaggedBy;
        this.reason = reason;
        this.flaggedAt = LocalDate.now();
    }

    public User getFlaggedBy() { return flaggedBy; }
}
