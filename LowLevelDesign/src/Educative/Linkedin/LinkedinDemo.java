package Educative.Linkedin;

import Educative.Linkedin.accounts.*;
import Educative.Linkedin.enums.*;
import Educative.Linkedin.features.*;
import Educative.Linkedin.profiledetails.*;
import Educative.Linkedin.search.SearchCatalog;

import java.time.*;
import java.util.*;

public class LinkedinDemo {

    public static void main(String[] args) {
        // Create accounts and users
        Account acc1 = new Account("u1", "pass1", "alice", "alice@mail.com", AccountStatus.ACTIVE);
        Account acc2 = new Account("u2", "pass2", "bob", "bob@mail.com", AccountStatus.ACTIVE);
        User alice = new User("Alice Anderson", new Address(11111, "1st Ave", "Metropolis", "NY", "USA"), "111-111-1111", acc1, 1, LocalDate.of(2020, 1, 1));
        User bob = new User("Bob Brown", new Address(22222, "2nd Ave", "Gotham", "CA", "USA"), "222-222-2222", acc2, 2, LocalDate.of(2021, 2, 2));

        // Profile setup
        alice.addEducation(new Education("MIT", "BS Computer Science", LocalDate.of(2015, 9, 1), LocalDate.of(2019, 6, 1), "Graduated with honors"));
        alice.addExperience(new Experience("Software Engineer", "TechCorp", alice.getAddress(), LocalDate.of(2019, 7, 1), LocalDate.of(2022, 6, 1), "Backend developer"));
        alice.addSkill(new Skill("Java"));
        alice.addAchievement(new Achievement("Employee of the Month", LocalDate.of(2020, 8, 1), "Recognized for outstanding performance"));

        // Following users and companies
        alice.followUser(bob);
        bob.followUser(alice);

        // Send and accept connection invite
        ConnectionInvitation invite = new ConnectionInvitation(alice, bob, LocalDate.now());
        alice.sendInvite(invite);
        bob.acceptInvite(invite);

        // Create company page and follow
        CompanyPage techCorp = new CompanyPage(1, "TechCorp", "Innovative Tech Solutions", "Technology", 500, alice);
        alice.createPage(techCorp);
        bob.followCompany(techCorp);

        // Create job posting and apply
        Job job = new Job(1, "Data Scientist", LocalDate.now(), "Analyze data", techCorp, "Full-time", alice.getAddress(), JobStatus.OPEN);
        techCorp.createJobPosting(job);
        bob.applyForJob(job);

        // Create, join, and leave group
        Group javaGroup = new Group(1, "Java Enthusiasts", "A group for Java lovers");
        alice.createGroup(javaGroup);
        bob.joinGroup(javaGroup);
        bob.leaveGroup(javaGroup);

        // Create and interact with posts
        Post post = new Post(1, alice, "Excited to join TechCorp!");
        alice.createPost(post);
        bob.react(post, ReactionType.CELEBRATE);
        bob.sharePost(post);

        // Comment on post and comment
        Comment comment1 = new Comment(1, bob, "Congratulations!");
        bob.createComment(comment1, post);
        Comment reply = new Comment(2, alice, "Thanks Bob!");
        alice.createComment(reply, post);
        comment1.getComments().add(reply);
        bob.reactToComment(comment1, ReactionType.LIKE);

        // Delete post
        alice.deletePost(post);

        // Messaging
        Message msg = new Message(1, alice, Arrays.asList(bob), "Hi Bob, let's connect!");
        alice.sendMessage(msg);

        // Recommendation requests
        bob.requestRecommendation(alice, "Please recommend me for my Java skills.");
        Recommendation rec = alice.getProfile().getRecommendations().get(0);
        alice.acceptRecommendation(rec);

        // Notifications (Observer pattern)
        Notification notif = new Notification(1, LocalDate.now(), "You have a new follower!");
        notif.registerObserver(alice);
        notif.registerObserver(bob);
        notif.sendNotification();
        System.out.println("Alice notifications: " + alice.getNotifications().size());
        System.out.println("Bob notifications: " + bob.getNotifications().size());

        // Search scenarios
        SearchCatalog catalog = new SearchCatalog();
        catalog.addNewUser(alice);
        catalog.addNewUser(bob);
        catalog.addNewCompany(techCorp);
        catalog.addNewGroup(javaGroup);
        catalog.addNewJob(job);

        System.out.println("Search user 'Alice Anderson': " + catalog.searchUser("Alice Anderson").size());
        System.out.println("Search company 'TechCorp': " + catalog.searchCompany("TechCorp").size());
        System.out.println("Search job 'Data Scientist': " + catalog.searchJob("Data Scientist").size());
        System.out.println("Search group 'Java Enthusiasts': " + catalog.searchGroup("Java Enthusiasts").size());

        // View analytics
        Analytics aliceAnalytics = alice.viewAnalytics();
        System.out.println("Alice's profile views: " + aliceAnalytics.getProfileViews());
    }
}
