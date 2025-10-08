package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;

import java.util.*;

public class Comment {
    private int commentId;
    private User commentOwner;
    private String text;
    private int totalReacts;
    private List<Comment> comments;

    public Comment(int commentId, User commentOwner, String text) {
        this.commentId = commentId;
        this.commentOwner = commentOwner;
        this.text = text;
        this.totalReacts = 0;
        this.comments = new ArrayList<>();
    }

    public boolean updateText(String newText) {
        this.text = newText;
        return true;
    }

    public void incrementReacts() {
        totalReacts++;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(User commentOwner) {
        this.commentOwner = commentOwner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTotalReacts() {
        return totalReacts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
