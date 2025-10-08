package Educative.Facebook.features;

import Educative.Facebook.accounts.User;

import java.util.*;

public class Page {
    private int pageId;
    private String name;
    private String description;
    private int likeCount;
    private List<User> admins = new ArrayList<>();

    public Page(int pageId, String name, String description, int likeCount, User creator) {
        this.pageId = pageId;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        // Optionally, initialize admins with the creator
        if (creator != null) {
            this.admins.add(creator);
        }
    }

    public List<User> getAdmins() {
        return Collections.unmodifiableList(admins);
    }

    public void addAdmin(User user) {
        if (user != null && !admins.contains(user)) {
            admins.add(user);
        }
    }

    public void removeAdmin(User user) {
        admins.remove(user);
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

}
