package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.FlagStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Flag {
    private final String id = UUID.randomUUID().toString();
    private final User flaggedBy;
    private final String reason;
    private final LocalDateTime flaggedAt;
    private FlagStatus status = FlagStatus.OPEN;

    public Flag(User by, String reason) {
        this.flaggedBy = by;
        this.reason = reason;
        this.flaggedAt = LocalDateTime.now();
    }

    public User getFlaggedBy() {
        return flaggedBy;
    }

    public void setStatus(FlagStatus status) {
        this.status = status;
    }

    public FlagStatus getStatus() {
        return status;
    }
}
