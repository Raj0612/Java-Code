package Educative.StackOverFlow.accounts;

import Educative.StackOverFlow.enums.ClosingDetail;
import Educative.StackOverFlow.enums.VoteType;
import Educative.StackOverFlow.notifications.Notification;
import Educative.StackOverFlow.service.NotificationService;
import Educative.StackOverFlow.posts.Answer;
import Educative.StackOverFlow.posts.Comment;
import Educative.StackOverFlow.posts.Post;
import Educative.StackOverFlow.posts.Question;
import Educative.StackOverFlow.service.QuestionService;
import Educative.StackOverFlow.additionalFeatures.Badge;
import Educative.StackOverFlow.additionalFeatures.Tag;
import Educative.StackOverFlow.additionalFeatures.TagList;
import Educative.StackOverFlow.additionalFeatures.Flag;
import Educative.StackOverFlow.votes.Vote;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected int reputationPoints;

    protected Account account;
    protected List<Badge> badges;

    protected List<Notification> notifications;

    public User(Account account) {
        this.account = account;
        this.badges = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public boolean createQuestion(Question question) {
        return QuestionService.getInstance().addQuestion(question);
    }

    public boolean addAnswer(Question question, Answer answer) {
        return QuestionService.getInstance().addAnswer(question, answer);
    }

    public boolean createComment(Post post, Comment comment) {
        return post.addComment(comment);
    }

    public boolean createTag(Tag tag) {
        return TagList.getInstance().addTag(tag);
    }

    public void flagPost(Post post, String reason) {
        post.addFlag(new Flag(this, reason));
    }

    public boolean upvote(Post post) {
        return post.addVote(new Vote(this, VoteType.UPVOTE));
    }

    public boolean downVote(Post post) {
        return post.addVote(new Vote(this, VoteType.DOWNVOTE));
    }

    public boolean voteToCloseQuestion(Question question, ClosingDetail detail) {
        return question.addClosingVote(this, detail);
    }

    public boolean voteToDeleteQuestion(Question question) {
        return question.addDeleteVote(this);
    }

    public boolean voteToDeleteAnswer(Answer answer) {
        return answer.addDeleteVote(this);
    }

    public boolean acceptAnswer(Question question, Answer answer) {
        return question.acceptAnswer(answer, this);
    }

    public void addBadge(Badge badge) {
        badges.add(badge);
    }

    public void notify(Notification notification) {
        notifications.add(notification);
        NotificationService.getInstance().sendNotification(account, notification);
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public void setReputationPoints(int reputationPoints) {
        this.reputationPoints = reputationPoints;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
