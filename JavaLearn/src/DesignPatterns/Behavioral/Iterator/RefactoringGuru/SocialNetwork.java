package DesignPatterns.Behavioral.Iterator.RefactoringGuru;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
