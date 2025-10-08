package Educative.Facebook.accounts;

import Educative.Facebook.enums.FriendInviteStatus;
import Educative.Facebook.features.*;
import Educative.Facebook.interfaces.Observer;
import Educative.Facebook.interfaces.PageFunctionsByUser;
import Educative.Facebook.notications.Notification;
import Educative.Facebook.features.Post;
import Educative.Facebook.profilesdetails.Profile;
import Educative.Facebook.search.SearchCatalog;
import Educative.Facebook.services.NotificationService;

import java.time.LocalDate;
import java.util.*;

public class User extends Person implements PageFunctionsByUser, Observer {
    private int userId;
    private LocalDate dateOfJoining;
    private List<Page> pagesAdmin = new ArrayList<>();
    private List<Page> sharedPages = new ArrayList<>();
    private List<Group> groupsAdmin = new ArrayList<>();
    private Profile profile = new Profile();
    private List<Notification> notifications = new ArrayList<>();
    private List<Message> inbox = new ArrayList<>();
    private Set<Integer> blockedUsers = new HashSet<>();
    private List<FriendRequest> sentFriendRequests = new ArrayList<>();
    private List<FriendRequest> receivedFriendRequests = new ArrayList<>();

    public User(String name, Address address, String email, String phone, Account account, int userId, LocalDate dateOfJoining) {
        super(name, address, email, phone, account);
        this.userId = userId;
        this.dateOfJoining = dateOfJoining;
    }

    // PageFunctionsByUser methods
    @Override
    public Page createPage(String name) {
        Page newPage = new Page(UUID.randomUUID().hashCode(), name, "", 0, this);
        this.pagesAdmin.add(newPage);
        SearchCatalog.getInstance().addNewPage(newPage);
        return newPage;
    }

    @Override
    public Page sharePage(Page page) {
        sharedPages.add(page);
        return page;
    }

    @Override
    public void likePage(Page page) {
        page.setLikeCount(page.getLikeCount() + 1);
        // Add to user's followed/liked pages if not already present
        if (!this.profile.getPagesFollowed().contains(page.getPageId())) {
            this.profile.getPagesFollowed().add(page.getPageId());
        }
        // Optionally, send notification to page admins
    }

    @Override
    public void followPage(Page page) {
        if (!this.profile.getPagesFollowed().contains(page.getPageId())) {
            this.profile.getPagesFollowed().add(page.getPageId());
        }
        // Optionally, notify the user or page admin
    }

    @Override
    public void unLikePage(Page page) {
        if (page.getLikeCount() > 0) {
            page.setLikeCount(page.getLikeCount() - 1);
        }
        this.profile.getPagesFollowed().remove((Integer) page.getPageId());
        // Optionally, notify the user or page admin
    }

    @Override
    public void unFollowPage(Page page) {
        this.profile.getPagesFollowed().remove((Integer) page.getPageId());
        // Optionally, notify the user or page admin
    }

    @Override
    public void update(Notification notification) {
        System.out.println("Notification received: " + notification.getContent());
        notifications.add(notification);
    }

    public void joinGroup(Group group) {
        this.groupsAdmin.add(group);
    }

    public void leaveGroup(Group group) {
        this.groupsAdmin.remove(group);
    }

    public int getUserId() {
        return userId;
    }

    public void addMessageToInbox(Message message) {
        if (message != null) {
            inbox.add(message);
        }
    }

    public void addBlockedUser(User user) {
        if (user != null) {
            blockedUsers.add(user.getUserId());
        }
    }

    public void removeBlockedUser(User user) {
        if (user != null) {
            blockedUsers.remove(user.getUserId());
        }
    }


    public void likePost(Post post) {
        post.setLikeCount(post.getLikeCount() + 1);
    }

    public void likeComment(Comment comment) {
        comment.setLikeCount(comment.getLikeCount() + 1);
    }

    // User-specific methods
    public boolean sendMessage(Message message) {
        if (message == null || message.getRecipient() == null || message.getRecipient().isEmpty()) {
            return false;
        }
        // Add the message to each recipient's inbox or notification list
        for (User recipient : message.getRecipient()) {
            if (this.getBlockedUsers().contains(recipient.getUserId()) || recipient.getBlockedUsers().contains(this.getUserId())) {
                System.out.println("User " + this.getName() + " blocked user " + recipient.getName());
                return false;
            }
            NotificationService.getInstance().send(new Notification(0, LocalDate.now(), this.getName() + " sent you a message: " + message.getContent()), recipient);
            recipient.addMessageToInbox(message);
        }
        return true;
    }

    public boolean sendRecommendation(Page page, Group group, User user) {
        if (user == null) return false;
        StringBuilder sb = new StringBuilder(this.getName() + " recommends you ");
        if (page != null) sb.append("the page: ").append(page.getName());
        if (group != null) {
            sb.append(" and the group: ").append(group.getName());
        }
        NotificationService.getInstance().send(new Notification(0, LocalDate.now(), sb.toString()), user);
        return true;
    }

    public boolean sendFriendRequest(User user) {
        if (user == null || user == this) return false;

        if (this.getProfile().getFriends().contains(user)) return false;

        if (this.getBlockedUsers().contains(user.getUserId()) || user.getBlockedUsers().contains(this.getUserId())) {
            System.out.println("User " + this.getName() + " blocked user " + user.getName());
            return false;
        }

        // Check if there is already a pending request from this user to the target user
        for (FriendRequest req : this.getSentFriendRequests()) {
            if (req.getRecipient().equals(user) && req.getStatus() == FriendInviteStatus.PENDING) {
                System.out.println("User " + this.getName() + " already sent a friend request to " + user.getName());
                return false;
            }
        }

        FriendRequest request = new FriendRequest(user, this, FriendInviteStatus.PENDING, LocalDate.now(), LocalDate.now());

        //Add to friend request lists
        this.getSentFriendRequests().add(request);
        user.getReceivedFriendRequests().add(request);

        NotificationService.getInstance().send(new Notification(0, LocalDate.now(), this.getName() + " sent you a friend request!"), user);
        return true;
    }

    public boolean unfriendUser(User user) {
        if (user == null || user == this) return false;
        boolean removed = this.getProfile().getFriends().remove(user);
        removed = user.getProfile().getFriends().remove(this) || removed;
        if (removed) {
            NotificationService.getInstance().send(new Notification(0, LocalDate.now(), this.getName() + " unfriended you."), user);
        }
        return removed;
    }

    public boolean blockUser(User user) {
        if (user == null || user == this) return false;
        this.addBlockedUser(user);

        // 1. Remove from friends list (both sides)
        if (this.getProfile().getFriends().contains(user)) {
            this.getProfile().getFriends().remove(user);
        }
        if (user.getProfile().getFriends().contains(this)) {
            user.getProfile().getFriends().remove(this);
        }

        // 2. Unfollow the user (if currently following)
        this.getProfile().getUsersFollowed().remove((Integer) user.getUserId());
        user.getProfile().getUsersFollowed().remove((Integer) this.getUserId());

        // 3. Remove pending friend requests (if any)
        this.getSentFriendRequests().removeIf(req -> req.getRecipient().equals(user));
        this.getReceivedFriendRequests().removeIf(req -> req.getSender().equals(user));
        user.getSentFriendRequests().removeIf(req -> req.getRecipient().equals(this));
        user.getReceivedFriendRequests().removeIf(req -> req.getSender().equals(this));

        // 4. Optionally, remove from group memberships, shared pages, etc.
        // Remove from common groups
        List<Integer> thisGroups = new ArrayList<>(this.getProfile().getGroupsJoined());
        List<Integer> userGroups = new ArrayList<>(user.getProfile().getGroupsJoined());
        for (Integer groupId : thisGroups) {
            if (userGroups.contains(groupId)) {
                Group group = SearchCatalog.getInstance().searchGroupsById(groupId);
                if (group != null) {
                    group.deleteUser(this);
                    group.deleteUser(user);
                }
                this.getProfile().getGroupsJoined().remove(groupId);
                user.getProfile().getGroupsJoined().remove(groupId);
            }
        }

        // Remove as co-admins from pages
        List<Page> thisPagesAdmin = new ArrayList<>(this.getPagesAdmin());
        List<Page> userPagesAdmin = new ArrayList<>(user.getPagesAdmin());
        for (Page page : thisPagesAdmin) {
            if (userPagesAdmin.contains(page)) {
                this.getPagesAdmin().remove(page);
                user.getPagesAdmin().remove(page);
                // Optionally, update the Page's admin list here
            }
        }

        // Remove from followed pages if both follow the same page
        List<Integer> thisFollowedPages = new ArrayList<>(this.getProfile().getPagesFollowed());
        List<Integer> userFollowedPages = new ArrayList<>(user.getProfile().getPagesFollowed());
        for (Integer pageId : thisFollowedPages) {
            if (userFollowedPages.contains(pageId)) {
                this.getProfile().getPagesFollowed().remove(pageId);
                user.getProfile().getPagesFollowed().remove(pageId);
            }
        }

        //5. Send notification to the blocked user
        NotificationService.getInstance().send(new Notification(0, LocalDate.now(), this.getName() + " has blocked you."), user);
        return true;
    }

    public boolean followUser(User user) {
        if (user == null || user == this) return false;
        if (!this.getProfile().getUsersFollowed().contains(user.getUserId())) {
            this.getProfile().getUsersFollowed().add(user.getUserId());
            NotificationService.getInstance().send(new Notification(0, LocalDate.now(), this.getName() + " started following you!"), user);
            return true;
        }
        return false;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public List<Page> getPagesAdmin() {
        return pagesAdmin;
    }

    public void setPagesAdmin(List<Page> pagesAdmin) {
        this.pagesAdmin = pagesAdmin;
    }

    public List<Group> getGroupsAdmin() {
        return groupsAdmin;
    }

    public void setGroupsAdmin(List<Group> groupsAdmin) {
        this.groupsAdmin = groupsAdmin;
    }

    public List<Message> getInbox() {
        return inbox;
    }
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public Set<Integer> getBlockedUsers() {
        return blockedUsers;
    }

    public List<FriendRequest> getSentFriendRequests() {
        return sentFriendRequests;
    }

    public List<FriendRequest> getReceivedFriendRequests() {
        return receivedFriendRequests;
    }

}
