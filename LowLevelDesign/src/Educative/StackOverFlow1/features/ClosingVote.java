package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;
import java.time.LocalDateTime;

public class ClosingVote {
    private final User user;
    private final String reason;
    private final LocalDateTime at;

    public ClosingVote(User user, String reason) {
        this.user = user;
        this.reason = reason;
        this.at = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }
}
