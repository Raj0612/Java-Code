package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;

import java.time.LocalDateTime;
import java.util.*;

public class Comment {
    private final String id = UUID.randomUUID().toString();
    private final String content;
    private final User postedBy;
    private final LocalDateTime createdAt;
    private final List<Vote> votes = new ArrayList<>();
    private final List<Flag> flags = new ArrayList<>();
    private boolean deleted = false;

    public Comment(String content, User postedBy) {
        this.content = content;
        this.postedBy = postedBy;
        this.createdAt = LocalDateTime.now();
    }

    public boolean addVote(Vote v) {
        for (Vote existing : votes) {
            if (existing.getVotedBy().equals(v.getVotedBy()))
                return false;
        }
        votes.add(v);
        return true;
    }

    public boolean addFlag(Flag f) {
        for (Flag existing : flags) {
            if (existing.getFlaggedBy().equals(f.getFlaggedBy()))
                return false;
        }
        flags.add(f);
        return true;
    }
}
