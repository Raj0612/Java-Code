package Educative.Linkedin.accounts;

import Educative.Linkedin.enums.*;
import Educative.Linkedin.features.*;
import Educative.Linkedin.profiledetails.*;

import java.time.LocalDate;
import java.util.*;

public class User extends Person implements Observer {
    private int userId;
    private LocalDate dateOfJoining;
    private Profile profile;
    private Set<User> connections;
    private Set<User> followedUsers;
    private Set<CompanyPage> followedCompanies;
    private Set<Group> joinedGroups;
    private Set<CompanyPage> createdPages;
    private Set<Group> createdGroups;
    private List<Message> inbox;
    private List<Notification> notifications;
    private List<ConnectionInvitation> pendingInvites;
    private Set<Post> posts;

    public User(String name, Address address, String phone, Account account, int userId, LocalDate dateOfJoining) {
        super(name, address, phone, account);
        this.userId = userId;
        this.dateOfJoining = dateOfJoining;
        this.profile = new Profile();
        this.connections = new HashSet<>();
        this.followedUsers = new HashSet<>();
        this.followedCompanies = new HashSet<>();
        this.joinedGroups = new HashSet<>();
        this.createdPages = new HashSet<>();
        this.createdGroups = new HashSet<>();
        this.posts = new HashSet<>();
        this.inbox = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.pendingInvites = new ArrayList<>();
    }

    // Observer pattern: receive notification
    @Override
    public void update(Notification notification) {
        notifications.add(notification);
    }

    // Profile actions
    public boolean addExperience(Experience exp) {
        return profile.addExperience(exp);
    }

    public boolean addEducation(Education edu) {
        return profile.addEducation(edu);
    }

    public boolean addSkill(Skill skill) {
        return profile.addSkill(skill);
    }

    public boolean addAchievement(Achievement ach) {
        return profile.addAchievement(ach);
    }

    // Connection actions
    public boolean sendInvite(ConnectionInvitation invite) {
        invite.getRecipient().receiveInvite(invite);
        return true;
    }

    public void receiveInvite(ConnectionInvitation invite) {
        pendingInvites.add(invite);
    }
    public boolean cancelInvite(ConnectionInvitation invite) {
        invite.setStatus(ConnectionInviteStatus.IGNORED);
        return true;
    }

    public boolean acceptInvite(ConnectionInvitation invite) {
        if (invite.getStatus() == ConnectionInviteStatus.PENDING) {
            this.connections.add(invite.getSender());
            invite.getSender().connections.add(this);
            invite.setStatus(ConnectionInviteStatus.ACCEPTED);
            this.profile.getAnalytics().incrementConnections();
            return true;
        }
        return false;
    }

    // Following
    public boolean followUser(User user) {
        this.profile.getAnalytics().incrementFollows();
        return followedUsers.add(user);
    }

    public boolean unfollowUser(User user) {
        this.profile.getAnalytics().decrementFollows();
        return followedUsers.remove(user);
    }

    public boolean followCompany(CompanyPage company) {
        return followedCompanies.add(company);
    }

    public boolean unfollowCompany(CompanyPage company) {
        return followedCompanies.remove(company);
    }

    // Groups
    public boolean joinGroup(Group group) {
        if (group.addMember(this)) {
            joinedGroups.add(group);
            return true;
        }
        return false;
    }

    public boolean leaveGroup(Group group) {
        if (group.removeMember(this)) {
            joinedGroups.remove(group);
            return true;
        }
        return false;
    }

    public boolean createGroup(Group group) {
        createdGroups.add(group);
        joinGroup(group);
        return true;
    }

    public boolean deleteGroup(Group group) {
        group.setDeleted(true);
        return true;
    }

    // Pages
    public boolean createPage(CompanyPage page) {
        createdPages.add(page);
        return true;
    }

    public boolean deletePage(CompanyPage page) {
        createdPages.remove(page);
        return true;
    }

    // Posts
    public boolean createPost(Post post) {
        posts.add(post);
        post.getPostOwner().getProfile().getAnalytics().incrementPostImpressions();
        return true;
    }

    public boolean deletePost(Post post) {
        return posts.remove(post);
    }

    public boolean sharePost(Post post) {
        post.incrementShares();
        return true;
    }

    public boolean react(Post post, ReactionType reaction) {
        post.incrementReacts();
        return true;
    }

    // Comments
    public boolean createComment(Comment comment, Post post) {
        post.getComments().add(comment);
        return true;
    }

    public boolean deleteComment(Comment comment, Post post) {
        post.getComments().remove(comment);
        return true;
    }

    public boolean reactToComment(Comment comment, ReactionType reaction) {
        comment.incrementReacts();
        return true;
    }

    // Messaging
    public boolean sendMessage(Message message) {
        for (User recipient : message.getRecipients()) {
            recipient.inbox.add(message);
        }
        return true;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    // Recommendations
    public boolean requestRecommendation(User user, String description) {
        Recommendation rec = new Recommendation(this.userId, LocalDate.now(), description, false);
        user.profile.getRecommendations().add(rec);
        return true;
    }

    public boolean acceptRecommendation(Recommendation rec) {
        rec.setAccepted(true);
        return true;
    }

    public boolean deleteRecommendation(Recommendation rec) {
        profile.getRecommendations().remove(rec);
        return true;
    }

    // Apply for job
    public boolean applyForJob(Job job) {
        job.addApplicant(this);
        return true;
    }

    // Analytics
    public Analytics viewAnalytics() {
        return profile.getAnalytics();
    }

    public int getUserId() {
        return userId;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<User> getConnections() {
        return connections;
    }

    public Set<User> getFollowedUsers() {
        return followedUsers;
    }

    public Set<CompanyPage> getFollowedCompanies() {
        return followedCompanies;
    }

    public Set<Group> getJoinedGroups() {
        return joinedGroups;
    }

    public Set<CompanyPage> getCreatedPages() {
        return createdPages;
    }

    public Set<Group> getCreatedGroups() {
        return createdGroups;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public List<ConnectionInvitation> getPendingInvites() {
        return pendingInvites;
    }
}
