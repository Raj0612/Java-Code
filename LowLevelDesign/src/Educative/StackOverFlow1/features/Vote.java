package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.VoteType;

import java.time.LocalDateTime;

public class Vote {
    private final User votedBy;
    private final VoteType type;
    private final LocalDateTime at;

    public Vote(User by, VoteType type) {
        this.votedBy = by;
        this.type = type;
        this.at = LocalDateTime.now();
    }

    public User getVotedBy() {
        return votedBy;
    }

    public VoteType getType() {
        return type;
    }
}
