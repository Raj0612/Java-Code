package Educative.Facebook.features;

import Educative.Facebook.accounts.User;
import Educative.Facebook.notications.Notification;
import Educative.Facebook.interfaces.GroupFunctions;
import Educative.Facebook.interfaces.Observer;
import Educative.Facebook.interfaces.Subject;

import java.time.LocalDate;
import java.util.*;

public class Group implements GroupFunctions, Subject {
    private int groupId;
    private String name;
    private String description;
    private byte[] coverPhoto;
    private int totalUsers;
    private boolean isPrivate;
    private List<User> users = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    boolean isDeleted = false;

    public Group(int groupId, String name, String description, byte[] coverPhoto, boolean isPrivate) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.coverPhoto = coverPhoto;
        this.isPrivate = isPrivate;
        this.totalUsers = 0;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (Observer o : observers) o.update(notification);
    }

    @Override
    public boolean addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            addObserver(user);
            totalUsers++;
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        if (users.remove(user)) {
            removeObserver(user);
            totalUsers--;
            return true;
        }
        return false;
    }

    @Override
    public boolean notifyUser(User user) {
        Notification notification = new Notification(0, LocalDate.now(), "Group activity");
        user.update(notification);
        return true;
    }

    public void postInGroup(Post post) {
        posts.add(post);
        Notification notification = new Notification(0, LocalDate.now(), "New post in group: " + post.getContent());
        notifyObservers(notification);
    }
    public void updateDescription(String description) {
        this.description = description;
    }

    public void addCoverPhoto(byte[] image) {
        this.coverPhoto = image;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}

