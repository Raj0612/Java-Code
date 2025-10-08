package Educative.StackOverFlow.accounts;

import Educative.StackOverFlow.enums.ClosingDetail;
import Educative.StackOverFlow.notifications.Notification;
import Educative.StackOverFlow.posts.Answer;
import Educative.StackOverFlow.posts.Question;
import Educative.StackOverFlow.additionalFeatures.Badge;

public class Moderator extends User {
    public Moderator(Account account) { super(account); }

    public boolean closeQuestion(Question question, ClosingDetail detail) {
        return question.close(this, detail);
    }

    public boolean reopenQuestion(Question question) {
        return question.reopen(this);
    }

    public boolean deleteQuestion(Question question) {
        return question.delete(this);
    }

    public boolean restoreQuestion(Question question) {
        return question.restore(this);
    }

    public boolean deleteAnswer(Answer answer) {
        return answer.delete(this);
    }

    public void awardBadge(User user, Badge badge) {
        user.addBadge(badge);
        user.notify(new Notification("Congratulations! You've earned the '" + badge.getName() + "' badge."));
    }
}

