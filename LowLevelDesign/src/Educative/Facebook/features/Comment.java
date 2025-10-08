package Educative.Facebook.features;

import Educative.Facebook.accounts.User;

public class Comment {
    private int commentId;
    private String content;
    private int likeCount;
    private User commentOwner;

    public Comment(int commentId, String content, int likeCount, User commentOwner) {
        this.commentId = commentId;
        this.content = content;
        this.likeCount = likeCount;
        this.commentOwner = commentOwner;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public User getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(User commentOwner) {
        this.commentOwner = commentOwner;
    }
}
