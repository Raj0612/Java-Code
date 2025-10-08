package Educative.StackOverFlow.votes;

import Educative.StackOverFlow.accounts.User;
import Educative.StackOverFlow.enums.VoteType;

import java.time.LocalDate;

public class Vote {
    private User votedBy;
    private VoteType type;
    private LocalDate votedAt;

    public Vote(User votedBy, VoteType type) {
        this.votedBy = votedBy;
        this.type = type;
        this.votedAt = LocalDate.now();
    }

    public User getVotedBy() { return votedBy; }
    public VoteType getType() { return type; }
}
