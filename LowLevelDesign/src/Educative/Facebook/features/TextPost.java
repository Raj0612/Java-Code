package Educative.Facebook.features;

import Educative.Facebook.enums.PostPrivacySettings;
import Educative.Facebook.accounts.User;
import Educative.Facebook.notications.Notification;
import Educative.Facebook.search.SearchCatalog;
import Educative.Facebook.services.NotificationService;

import java.time.LocalDate;
import java.util.List;

public class TextPost extends Post{
    public TextPost(int postId, String content, byte[] image, int likeCount, int shareCount, User postOwner, PostPrivacySettings settings) {
        super(postId, content, image, likeCount, shareCount, postOwner, settings);
    }
    @Override
    protected void validateContent() {
        if (getContent() == null || getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        // Optionally: Add more validation (length, prohibited words, etc.)
    }
    @Override
    protected void saveToDatabase() {
        // Simulate saving to database (in real app, call repository/DAO)
        System.out.println("Saving post [" + getPostId() + "] to database.");
    }
    @Override
    protected void notifyFollowers() {
        User owner = getPostOwner();
        if (owner == null || owner.getProfile() == null) return;

        List<Integer> followerIds = owner.getProfile().getUsersFollowed();

        SearchCatalog catalog = SearchCatalog.getInstance();

        String notificationMsg = owner.getName() + " has posted: " + getContent();
        Notification notification = new Notification(
                0, LocalDate.now(), notificationMsg
        );

        for (Integer followerId : followerIds) {
            // Find the follower User object
            User follower = catalog.searchUserById(followerId);
            NotificationService.getInstance().send(notification, follower);
        }
    }
}
