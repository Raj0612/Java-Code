package Educative.StackOverFlow.service;

import Educative.StackOverFlow.accounts.User;
import Educative.StackOverFlow.posts.Answer;
import Educative.StackOverFlow.posts.Question;
import Educative.StackOverFlow.search.SearchCatalog;
import Educative.StackOverFlow.additionalFeatures.Tag;
import Educative.StackOverFlow.additionalFeatures.TagList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionService {
    // Singleton instance
    private static QuestionService instance;

    // In-memory storage for questions (could be replaced with a database)
    private Map<String, Question> questionsById;

    // Private constructor for Singleton
    private QuestionService() {
        questionsById = new HashMap<>();
    }

    // Singleton accessor
    public static synchronized QuestionService getInstance() {
        if (instance == null) {
            instance = new QuestionService();
        }
        return instance;
    }

    // Add a new question to the system
    public boolean addQuestion(Question question) {
        if (question == null || questionsById.containsKey(question.getId())) {
            return false;
        }
        questionsById.put(question.getId(), question);

        // Add to SearchCatalog for tag, user, and word search
        SearchCatalog.getInstance().indexQuestion(question);

        // Register tags in TagList
        for (Tag tag : question.getTags()) {
            TagList.getInstance().incrementTagCount(tag);
        }
        return true;
    }

    // Get a question by its ID
    public Question getQuestionById(String questionId) {
        return questionsById.get(questionId);
    }

    // Delete a question (soft delete: flag as deleted)
    public boolean deleteQuestion(String questionId, User moderator) {
        Question q = questionsById.get(questionId);
        if (q == null) return false;
        return q.delete(moderator);
    }

    // Restore a deleted question
    public boolean restoreQuestion(String questionId, User moderator) {
        Question q = questionsById.get(questionId);
        if (q == null) return false;
        return q.restore(moderator);
    }

    // Add an answer to a question
    public boolean addAnswer(Question question, Answer answer) {
        if (question == null || answer == null) return false;
        boolean added = question.addAnswer(answer);
        if (added) {
            // Optionally, index answer for search (not shown)
        }
        return added;
    }

    // Get all questions
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionsById.values());
    }

    // Search questions by tag
    public List<Question> searchByTag(String tagName) {
        return SearchCatalog.getInstance().searchByTags(tagName);
    }

    // Search questions by username
    public List<Question> searchByUser(String username) {
        return SearchCatalog.getInstance().searchByUsers(username);
    }

    // Search questions by keyword
    public List<Question> searchByWord(String word) {
        return SearchCatalog.getInstance().searchByWords(word);
    }

    // Optional: Remove a question completely (used by admins)
    public boolean removeQuestion(String questionId) {
        Question q = questionsById.remove(questionId);
        if (q == null) return false;
        // Optionally, update TagList and SearchCatalog
        for (Tag tag : q.getTags()) {
            TagList.getInstance().decrementTagCount(tag);
        }
        SearchCatalog.getInstance().removeQuestion(q);
        return true;
    }
}
