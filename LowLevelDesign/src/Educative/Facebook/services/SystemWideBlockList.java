package Educative.Facebook.services;
import Educative.Facebook.accounts.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class SystemWideBlockList {

    private static final SystemWideBlockList instance = new SystemWideBlockList();

    // Thread-safe set of blocked user IDs
    private final Set<Integer> blockedUserIds = Collections.synchronizedSet(new HashSet<>());

    // Private constructor for Singleton
    private SystemWideBlockList() {}

    // Get the singleton instance
    public static SystemWideBlockList getInstance() {
        return instance;
    }

    // Add a user to the block list
    public void addBlockedUser(User user) {
        if (user != null) {
            blockedUserIds.add(user.getUserId());
        }
    }

    // Remove a user from the block list
    public void removeBlockedUser(User user) {
        if (user != null) {
            blockedUserIds.remove(user.getUserId());
        }
    }

    // Check if a user is blocked
    public boolean isBlocked(User user) {
        if (user == null) return false;
        return blockedUserIds.contains(user.getUserId());
    }

    // Optional: Get all blocked user IDs
    public Set<Integer> getBlockedUserIds() {
        return Collections.unmodifiableSet(blockedUserIds);
    }
}
