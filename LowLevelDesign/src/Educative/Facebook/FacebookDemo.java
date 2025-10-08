package Educative.Facebook;

import Educative.Facebook.accounts.*;
import Educative.Facebook.enums.*;
import Educative.Facebook.features.*;
import Educative.Facebook.notications.Notification;
import Educative.Facebook.features.TextPost;
import Educative.Facebook.profilesdetails.*;
import Educative.Facebook.search.SearchCatalog;
import Educative.Facebook.services.NotificationService;

import java.time.LocalDate;
import java.util.*;

public class FacebookDemo {

    public static void main(String[] args) {
        // 1. User Registration and Profile Setup
        Account aliceAcc = new Account("1", "alicePass", "alice", "alice@fb.com", AccountStatus.ACTIVE);
        Account bobAcc = new Account("2", "bobPass", "bob", "bob@fb.com", AccountStatus.ACTIVE);
        Address address = new Address(12345, "221B", "London", "London", "UK");
        User alice = new User("Alice", address, "alice@fb.com", "111-222-3333", aliceAcc, 1, LocalDate.now());
        User bob = new User("Bob", address, "bob@fb.com", "444-555-6666", bobAcc, 2, LocalDate.now());

        // Set up profile details
        alice.getProfile().addWorkExperience(new Work("Engineer", "FB Inc", "London", "Backend Developer", LocalDate.now(), null));
        alice.getProfile().addEducation(new Education("Oxford", "BSc CS", "Computer Science", LocalDate.now(), null));
        alice.getProfile().addPlace(new Places("London"));

        // 2. Add users to SearchCatalog (Singleton)
        SearchCatalog catalog = SearchCatalog.getInstance();
        catalog.addNewUser(alice);
        catalog.addNewUser(bob);

        // 3. Privacy Settings
        ProfilePrivacy privacy = new ProfilePrivacy();
        privacy.changeFriendsListVisibility(alice.getProfile(), FriendsListVisibility.FRIENDS_ONLY);
        privacy.lockProfilePicture(alice.getProfile());

        // 4. Friend Request and Following
        alice.sendFriendRequest(bob);
        FriendRequest friendRequest =  bob.getReceivedFriendRequests().stream().filter(friendRequest1 -> friendRequest1.getSender().getUserId() == (alice.getUserId())).findFirst()
                .orElse(null);;
        if(friendRequest!=null)
             friendRequest.acceptRequest(bob);
        bob.followUser(alice); // Bob follows Alice

        // 5. Messaging
        Message message = new Message(1, alice, "Hi Bob!", Arrays.asList(bob), null);
        alice.sendMessage(message);

        // 6. Create a Page and perform actions
        Page techPage = alice.createPage("TechTalks");
        alice.likePage(techPage);
        bob.followPage(techPage);
        alice.unLikePage(techPage);
        bob.unFollowPage(techPage);

        // 7. Create a Group and perform actions (Observer pattern)
        Group javaGroup = new Group(1, "Java Enthusiasts", "A place for Java lovers", null, false);
        bob.joinGroup(javaGroup); // Admin of the Group
        javaGroup.addUser(alice);
        javaGroup.addUser(bob);
        alice.leaveGroup(javaGroup);

        // 8. Posting, Sharing, Liking, Commenting
        TextPost alicePost = new TextPost(1, "Hello, world!", null, 0, 0, alice, PostPrivacySettings.PUBLIC);
        alicePost.publish(); // Template method
        bob.likePost(alicePost);

        // Bob comments on Alice's post
        Comment bobComment = new Comment(1, "Nice post!", 0, bob);
        alicePost.addComment(bobComment);
        // In a real system, you'd add this comment to the post's comment list

        // Alice likes Bob's comment
        alice.likeComment(bobComment);

        // 9. Notifications (Observer pattern)
        NotificationService.getInstance().send(
                new Notification(2, LocalDate.now(), "Bob liked your post!"), alice
        );
        NotificationService.getInstance().send(
                new Notification(3, LocalDate.now(), "Alice liked your comment!"), bob
        );

        // 10. Group Post and Notification to all members
        TextPost groupPost = new TextPost(2, "Welcome to Java Group!", null, 0, 0, alice, PostPrivacySettings.PUBLIC);
        javaGroup.postInGroup(groupPost);

        // 11. Search Functionality
        List<User> foundUsers = catalog.searchUsers("Alice");
        System.out.println("Search for 'Alice':");
        for (User u : foundUsers) {
            System.out.println("- " + u.getName());
        }

        // 12. Admin Actions
        Admin admin = new Admin();
        admin.blockUser(bob); // Bob is now blocked
        admin.enablePage(techPage);
        admin.disablePage(techPage);
        admin.changeGroupPrivacy(javaGroup);
        admin.deleteGroup(javaGroup);

        // 13. Show notifications
        System.out.println("Alice's notifications:");
        for (Notification n : alice.getNotifications()) {
            System.out.println("- " + n.getContent());
        }
        System.out.println("Bob's notifications:");
        for (Notification n : bob.getNotifications()) {
            System.out.println("- " + n.getContent());
        }

        // 14. Search a specific group
        Group g = SearchCatalog.getInstance().searchGroupsById(123);
        if (g != null) {
            System.out.println("Found group: " + g.getName());
        }

        // 15. Search a specific user
        User alice1 = SearchCatalog.getInstance().searchUserById(1);
        if (alice1 != null) {
            System.out.println("Found user: " + alice1.getName());
        }

        // 16. Show privacy settings
        System.out.println("Alice's friends list visibility: " + alice.getProfile().getFriendsListVisibility());
        System.out.println("Alice's profile picture locked: " + alice.getProfile().isProfilePictureLocked());
        System.out.println("Bob's account status: " + bob.getAccount().getStatus());
    }
}
