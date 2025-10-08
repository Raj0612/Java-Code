package Educative.StackOverFlow1.posts;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.QuestionStatus;

import java.util.*;

public class Answer extends Post {
    private boolean accepted = false;
    private final Question parent;
    private final List<User> deleteVotes = new ArrayList<>();

    public Answer(String content, User postedBy, Question parent) {
        super(content, postedBy);
        this.parent = parent;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean addDeleteVote(User u) {
        if (deleteVotes.contains(u))
            return false;
        deleteVotes.add(u);
        return true;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Question getParent() {
        return parent;
    }
}
