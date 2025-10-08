package Educative.StackOverFlow.posts;

import Educative.StackOverFlow.accounts.User;
import Educative.StackOverFlow.enums.VoteType;
import Educative.StackOverFlow.additionalFeatures.Flag;
import Educative.StackOverFlow.votes.Vote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String id;
    private String content;
    private int upVotes;
    private int downVotes;
    private List<Flag> flags;
    private LocalDate creationDate;
    private User postedBy;
    private List<Vote> votes;

    public Comment(String id, String content, User postedBy) {
        this.id = id;
        this.content = content;
        this.postedBy = postedBy;
        this.creationDate = LocalDate.now();
        this.upVotes = 0;
        this.downVotes = 0;
        this.flags = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    public boolean addUpvote(User user) {
        for (Vote v : votes) {
            if (v.getVotedBy().equals(user)) return false;
        }
        votes.add(new Vote(user, VoteType.UPVOTE));
        upVotes++;
        return true;
    }

    public boolean addDownVote(User user) {
        for (Vote v : votes) {
            if (v.getVotedBy().equals(user)) return false;
        }
        votes.add(new Vote(user, VoteType.DOWNVOTE));
        downVotes++;
        return true;
    }

    public boolean addFlag(Flag flag) {
        for (Flag f : flags) {
            if (f.getFlaggedBy().equals(flag.getFlaggedBy())) return false;
        }
        flags.add(flag);
        return true;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public String getContent() {
        return content;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public User getPostedBy() {
        return postedBy;
    }
}
