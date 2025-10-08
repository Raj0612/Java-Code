package Educative.StackOverFlow1.posts;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.VoteType;
import Educative.StackOverFlow1.features.*;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Post {
    protected final String id;
    protected String content;
    protected final User postedBy;
    protected final LocalDateTime createdAt;
    protected LocalDateTime lastEditedAt;
    protected User lastEditedBy;
    protected final List<Comment> comments = new ArrayList<>();
    protected final List<Flag> flags = new ArrayList<>();
    protected final List<Vote> votes = new ArrayList<>();
    protected boolean deleted = false;
    protected boolean locked = false;

    public Post(String content, User postedBy) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.postedBy = postedBy;
        this.createdAt = LocalDateTime.now();
    }

    public boolean addComment(Comment c) {
        if (deleted || locked) return false;
        return comments.add(c);
    }

    public boolean addFlag(Flag f) {
        for (Flag existing : flags)
            if (existing.getFlaggedBy().equals(f.getFlaggedBy()))
                return false;
        flags.add(f);
        return true;
    }

    public boolean addVote(Vote v) {
        if (deleted || locked)
            return false;
        for (Vote existing : votes)
            if (existing.getVotedBy().equals(v.getVotedBy()))
                return false;
        votes.add(v);
        // Reputation change handled by service
        return true;
    }

    public long getUpvotes() {
        return votes.stream().filter(v -> v.getType() == VoteType.UPVOTE).count();
    }

    public long getDownvotes() {
        return votes.stream().filter(v -> v.getType() == VoteType.DOWNVOTE).count();
    }

    public void softDelete() {
        deleted = true;
    }

    public void restore() {
        deleted = false;
    }

    public String getId() {
        return id;
    }

    public User getPostedBy() {
        return postedBy;
    }
}
