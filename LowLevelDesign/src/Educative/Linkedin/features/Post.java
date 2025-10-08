package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;

import java.util.*;

public class Post {
    private int postId;
    private User postOwner;
    private String text;
    private List<byte[]> media;
    private int totalReacts;
    private int totalShares;
    private List<Comment> comments;

    public Post(int postId, User postOwner, String text) {
        this.postId = postId;
        this.postOwner = postOwner;
        this.text = text;
        this.media = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.totalReacts = 0;
        this.totalShares = 0;
    }

    public boolean updateText(String newText) {
        this.text = newText;
        return true;
    }

    public void incrementReacts() {
        totalReacts++;
    }

    public void incrementShares() {
        totalShares++;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public User getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(User postOwner) {
        this.postOwner = postOwner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<byte[]> getMedia() {
        return media;
    }

    public void setMedia(List<byte[]> media) {
        this.media = media;
    }

    public int getTotalReacts() {
        return totalReacts;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
