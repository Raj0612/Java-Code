package Educative.StackOverFlow1.accounts;

import Educative.StackOverFlow1.enums.NotificationType;
import Educative.StackOverFlow1.enums.Role;
import Educative.StackOverFlow1.notification.Notification;
import Educative.StackOverFlow1.services.NotificationService;

import java.util.*;

public class User {
    private final Account account;
    private final Reputation reputation;
    private final List<Notification> notifications = new ArrayList<>();
    private final Set<String> badges = new HashSet<>();

    public User(Account account) {
        this.account = account;
        this.reputation = new Reputation(0);
    }

    public Account getAccount() {
        return account;
    }

    public Reputation getReputation() {
        return reputation;
    }

    public void receiveNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }

    public void awardBadge(String badgeName) {
        badges.add(badgeName);
        NotificationService.getInstance().send(this, new Notification(NotificationType.BADGE, "Awarded badge: " + badgeName));
    }

    public boolean isModerator() {
        return account.hasRole(Role.MODERATOR) || account.hasRole(Role.ADMIN);
    }

    public boolean isAdmin() {
        return account.hasRole(Role.ADMIN);
    }

    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return account.getAccountId().equals(user.account.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(account.getAccountId());
    }
}
