package ashishps1.stackoverflow;

import ashishps1.stackoverflow.enums.VoteType;

public interface Votable {
    void vote(User voter, VoteType type);
    int getVoteCount();
}
