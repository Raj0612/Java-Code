package Educative.StackOverFlow;

import Educative.StackOverFlow.accounts.*;
import Educative.StackOverFlow.enums.BadgeLevel;
import Educative.StackOverFlow.posts.*;
import Educative.StackOverFlow.service.*;
import Educative.StackOverFlow.additionalFeatures.*;

public class StackoverflowDesign {
    public static void main(String[] args) {
        // Create accounts and users
        Account aliceAccount = new Account("1", "alice", "pass", "Alice", "alice@example.com", "1234567890");
        User alice = new User(aliceAccount);

        Account bobAccount = new Account("2", "bob", "pass", "Bob", "bob@example.com", "0987654321");
        User bob = new User(bobAccount);

        Account modAccount = new Account("3", "moderator", "pass", "Moderator", "moderator@example.com", "0987654321");
        Moderator moderator = new Moderator(modAccount);

        // Create tags
        Tag javaTag = new Tag("java", "Java programming language");
        Tag oopTag = new Tag("oop", "Object Oriented Programming");

        // Create a question
        Question question = new Question("Q1", "How to write a singleton in Java?",
                "I want to know how to implement the singleton pattern in Java.", alice);
        question.addTag(javaTag);
        question.addTag(oopTag);

        // Add question to service (this also indexes it)
        QuestionService.getInstance().addQuestion(question);

        // Bob answers Alice's question
        Answer answer = new Answer("A1", "You can use a private constructor and a static getInstance method.", bob);
        QuestionService.getInstance().addAnswer(question, answer);

        // Bob comments on the question
        Comment comment = new Comment("C1", "This is a good question!", bob);
        question.addComment(comment);

        // Alice upvotes Bob's answer
        alice.upvote(answer);

        // Search for the question by tag
        System.out.println("Search by tag 'java':");
        for (Question q : QuestionService.getInstance().searchByTag("java")) {
            System.out.println(q.getTitle());
        }

        // Remove the question
        QuestionService.getInstance().removeQuestion("Q1");

        // Verify removal by searching again
        System.out.println("Search by tag 'java' after removal:");
        for (Question q : QuestionService.getInstance().searchByTag("java")) {
            System.out.println(q.getTitle());
        }

        Badge helpfulAnswer = new Badge("Helpful Answer", "Provided an answer that received 10 upvotes", BadgeLevel.SILVER);

        Account adminAccount = new Account("99", "admin", "adminpass", "Admin", "admin@so.com", "1111111111");
        Admin admin = new Admin(adminAccount);
        admin.awardBadge(bob, helpfulAnswer);

        // Print Bob's badges
        System.out.println("Bob's badges:");
        for (Badge badge : bob.getBadges()) {
            System.out.println(badge.getName() + " - " + badge.getDescription());
        }

    }
}
