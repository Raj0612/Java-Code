package Educative.StackOverFlow1;

import Educative.StackOverFlow1.accounts.*;
import Educative.StackOverFlow1.enums.*;
import Educative.StackOverFlow1.features.*;
import Educative.StackOverFlow1.posts.*;
import Educative.StackOverFlow1.services.*;

import java.util.Set;

public class StackOverFlowDemo {

    public static void main(String[] args) {
        TagService tagService = new TagService();
        AccountService accountService = new AccountService();
        QuestionService qService = QuestionService.getInstance();

        // Register users
        User alice = accountService.register("alice", "alicePass", "alice@x.com", Set.of(Role.USER));
        User bob = accountService.register("bob", "bobPass", "bob@x.com", Set.of(Role.USER));
        User charlie = accountService.register("charlie", "charliePass", "charlie@x.com", Set.of(Role.USER, Role.MODERATOR));

        // Increase reputation for demo
        alice.getReputation().add(2000); // alice can create tags
        bob.getReputation().add(100);
        charlie.getReputation().add(5000); // moderator and high rep

        // Alice creates a tag and a question
        Tag javaTag = new Tag("java", "Questions about Java", alice);
        if (alice.getReputation().canCreateTag())
            tagService.addTag(javaTag);
        Question q1 = qService.createQuestion("How to hash password in Java?", "I want to securely store passwords. Any suggestions?", alice);
        q1.addTag(javaTag, tagService);
        System.out.println("Created: " + q1);

        // Bob answers
        Answer a1 = new Answer("Use bcrypt or PBKDF2", bob, q1);
        qService.addAnswer(q1, a1);

        // Bob upvotes the question
        q1.addVote(new Vote(bob, VoteType.UPVOTE));
        bob.getReputation().add(10); // upvote reward to question? (sample)
        alice.getReputation().add(10); // question owner gains rep for upvote

        // Alice accepts Bob's answer
        boolean accepted = q1.acceptAnswer(a1, alice);
        System.out.println("Answer accepted: " + accepted + " ; Bob rep=" + bob.getReputation().getPoints());

        // Alice offers a bounty
        Bounty bounty = new Bounty(alice, 50, 7);
        if (alice.getReputation().getPoints() >= bounty.getPoints()) {
            alice.getReputation().add(-bounty.getPoints()); // deduct from giver immediately
            q1.addBounty(bounty);
            System.out.println("Bounty added: " + bounty.getPoints());

            // Charlie (moderator) closes the question
            boolean closed = q1.close(charlie, "Duplicate of another question");
            System.out.println("Question closed by charlie: " + closed + " status=" + q1.getStatus());

            // Bob flags the question
            q1.addFlag(new Flag(bob, "Needs more details"));

            // Print notifications
            System.out.println("\nAlice notifications:");
            alice.getNotifications().forEach(n -> System.out.println(n.toString()));

            System.out.println("\nBob notifications:");
            bob.getNotifications().forEach(n -> System.out.println(n.toString()));

            // Show top tags
            System.out.println("\nTop tags: " + tagService.getTopTags(5));

            // Print all questions
            System.out.println("\nAll Questions:");
            qService.all().forEach(System.out::println);
        }
    }
}
