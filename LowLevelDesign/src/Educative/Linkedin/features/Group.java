package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;

import java.util.*;

public class Group {
    private int groupId;
    private String name;
    private String description;
    private int totalMembers;
    private Set<User> members;
    private boolean deleted;

    public Group(int groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.totalMembers = 0;
        this.members = new HashSet<>();
        this.deleted = false;
    }

    public boolean addMember(User user) {
        if (deleted) return false;
        if (members.add(user)) {
            totalMembers++;
            return true;
        }
        return false;
    }

    public boolean removeMember(User user) {
        if (members.remove(user)) {
            totalMembers--;
            return true;
        }
        return false;
    }

    public boolean updateDescription(String desc) {
        this.description = desc;
        return true;
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

    public int getTotalMembers() {
        return totalMembers;
    }

    public Set<User> getMembers() {
        return members;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
