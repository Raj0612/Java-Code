package Educative.Facebook.features;

import Educative.Facebook.enums.PostPrivacySettings;
import Educative.Facebook.accounts.User;

import java.util.ArrayList;
import java.util.List;

//Template Method
public abstract class Post {
    private int postId;
    private String content;
    private byte[] image;
    private int likeCount;
    private int shareCount;
    private User postOwner;
    private PostPrivacySettings settings;
    private List<Comment> comments = new ArrayList<>();

    public Post(int postId, String content, byte[] image, int likeCount, int shareCount, User postOwner, PostPrivacySettings settings) {
        this.postId = postId;
        this.content = content;
        this.image = image;
        this.likeCount = likeCount;
        this.shareCount = shareCount;
        this.postOwner = postOwner;
        this.settings = settings;
    }

    public final void publish() {
        validateContent();
        saveToDatabase();
        notifyFollowers();
    }

    protected abstract void validateContent();

    protected abstract void saveToDatabase();

    protected abstract void notifyFollowers();

    public void changePostVisibility(PostPrivacySettings newSetting) {
        this.setSettings(newSetting);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public User getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(User postOwner) {
        this.postOwner = postOwner;
    }

    public PostPrivacySettings getSettings() {
        return settings;
    }

    public void setSettings(PostPrivacySettings settings) {
        this.settings = settings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
