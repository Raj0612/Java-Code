package Educative.StackOverFlow1.posts;

import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.*;
import Educative.StackOverFlow1.features.*;
import Educative.StackOverFlow1.notification.Notification;
import Educative.StackOverFlow1.services.*;

import java.util.*;

public class Question extends Post {
    private String title;
    private QuestionStatus status = QuestionStatus.ACTIVE;
    private String closingReason;
    private Bounty bounty;
    private final Set<Tag> tags = new HashSet<>();
    private final List<Answer> answers = new ArrayList<>();
    private final Set<User> followers = new HashSet<>();
    private final List<ClosingVote> closingVotes = new ArrayList<>();
    private final Set<User> deleteVotes = new HashSet<>();
    private int viewCount = 0;
    private Answer acceptedAnswer;
    //Rate limiting (prevent spam flags/comments/votes).
    public static final int CLOSE_VOTE_THRESHOLD = 3;
    public static final int DELETE_VOTE_THRESHOLD = 3;

    public Question(String title, String content, User postedBy) {
        super(content, postedBy);
        this.title = title;
    }

    public boolean addTag(Tag tag, TagService tagService) {
        boolean added = tags.add(tag);
        if (added)
            tagService.increment(tag);
        return added;
    }

    public boolean addAnswer(Answer answer) {
        if (deleted || locked)
            return false;
        answers.add(answer);
        // notify followers and owner
        NotificationService.getInstance().send(postedBy, new Notification(NotificationType.INFO, "Your question got a new answer."));
        for (User f : followers)
            NotificationService.getInstance().send(f, new Notification(NotificationType.INFO, "A followed question got a new answer: " + title));
        return true;
    }

    public boolean addClosingVote(User user, String detail) {
        if (closingVotes.stream().anyMatch(cv -> cv.getUser().equals(user)))
            return false;
        closingVotes.add(new ClosingVote(user, detail));
        if (this.status == QuestionStatus.ACTIVE && closingVotes.size() >= CLOSE_VOTE_THRESHOLD) {
            status = QuestionStatus.CLOSED;
            closingReason = detail;
        }
        return true;
    }

    public boolean addDeleteVote(User user) {
        if (deleteVotes.contains(user)) return false;
        deleteVotes.add(user);
        if (this.status == QuestionStatus.ACTIVE && deleteVotes.size() >= DELETE_VOTE_THRESHOLD) {
            status = QuestionStatus.ON_HOLD; // or DELETED after review
            // mark flagged etc.
        }
        return true;
    }

    public boolean close(User moderatorOrHighRepUser, String reason) {
        if (moderatorOrHighRepUser.isModerator() || moderatorOrHighRepUser.getReputation().canVoteToClose()) {
            status = QuestionStatus.CLOSED;
            closingReason = reason;
            return true;
        }
        return false;
    }

    public boolean reopen(User moderatorOrHighRepUser) {
        if (moderatorOrHighRepUser.isModerator()) {
            status = QuestionStatus.ACTIVE;
            closingReason = null;
            return true;
        }
        return false;
    }

    public boolean delete(User moderatorOrAdmin) {
        if (moderatorOrAdmin.isModerator() || moderatorOrAdmin.isAdmin()) {
            this.softDelete();
            this.status = QuestionStatus.DELETED;
            return true;
        }
        return false;
    }

    public boolean restore(User moderatorOrAdmin) {
        if (moderatorOrAdmin.isModerator() || moderatorOrAdmin.isAdmin()) {
            this.restore();
            this.status = QuestionStatus.ACTIVE;
            return true;
        }
        return false;
    }

    public boolean acceptAnswer(Answer answer, User by) {
        if (!by.equals(this.postedBy))
            return false;
        if (!answers.contains(answer))
            return false;
        this.acceptedAnswer = answer;
        answer.setAccepted(true);
        answer.getPostedBy().getReputation().add(15); // +15 for accepted
        NotificationService.getInstance().send(answer.getPostedBy(), new Notification(NotificationType.INFO, "Your answer was accepted for: " + title));
        return true;
    }

    public boolean addBounty(Bounty b) {
        if (b == null || b.isExpired())
            return false;
        this.bounty = b;
        this.status = QuestionStatus.BOUNTIED;
        return true;
    }

    public void incrementView() {
        viewCount++;
    }

    @Override
    public String toString() {
        return "Question[" + title + "] by " + postedBy.getUsername() + " status=" + status + " views=" + viewCount;
    }

    public QuestionStatus getStatus() {
        return status;
    }
}
