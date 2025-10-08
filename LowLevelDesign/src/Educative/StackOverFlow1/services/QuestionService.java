package Educative.StackOverFlow1.services;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.posts.*;

import java.util.*;

public class QuestionService {
    private final Map<String, Question> store = new HashMap<>();
    private static final QuestionService INSTANCE = new QuestionService();

    private QuestionService() {
    }

    public static QuestionService getInstance() {
        return INSTANCE;
    }

    public Question createQuestion(String title, String content, User postedBy) {
        if (!postedBy.getAccount().isActive())
            throw new IllegalStateException("account inactive");
        Question q = new Question(title, content, postedBy);
        store.put(q.getId(), q);
        return q;
    }

    public boolean addAnswer(Question q, Answer a) {
        if (q == null || a == null)
            return false;
        return q.addAnswer(a);
    }

    public Question getById(String id) {
        return store.get(id);
    }

    public List<Question> all() {
        return new ArrayList<>(store.values());
    }
}
