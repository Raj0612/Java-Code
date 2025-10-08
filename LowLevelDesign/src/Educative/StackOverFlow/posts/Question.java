package Educative.StackOverFlow.posts;

import Educative.StackOverFlow.accounts.Moderator;
import Educative.StackOverFlow.accounts.User;
import Educative.StackOverFlow.enums.ClosingDetail;
import Educative.StackOverFlow.enums.QuestionStatus;
import Educative.StackOverFlow.notifications.Notification;
import Educative.StackOverFlow.additionalFeatures.Bounty;
import Educative.StackOverFlow.additionalFeatures.Tag;
import Educative.StackOverFlow.additionalFeatures.TagList;
import Educative.StackOverFlow.votes.ClosingVote;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post {
    private String title;
    private QuestionStatus status;
    private ClosingDetail closingReason;
    private Bounty bounty;
    private List<Tag> tags;
    private List<Answer> answers;
    private List<User> followers;
    private List<ClosingVote> closingVotes;
    private List<User> deleteVotes;
    private int viewCount;
    private Answer acceptedAnswer;

    public Question(String id, String title, String content, User postedBy) {
        super(id, content, postedBy);
        this.title = title;
        this.status = QuestionStatus.ACTIVE;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.closingVotes = new ArrayList<>();
        this.deleteVotes = new ArrayList<>();
        this.viewCount = 0;
    }

    public boolean addTag(Tag tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
            TagList.getInstance().incrementTagCount(tag);
            return true;
        }
        return false;
    }

    public boolean addAnswer(Answer answer) {
        answers.add(answer);
        // Notify the question owner
        postedBy.notify(new Notification("Your question received a new answer!"));
        return true;
    }

    public boolean addBounty(Bounty bounty) {
        this.bounty = bounty;
        this.status = QuestionStatus.BOUNTIED;
        return true;
    }

    public boolean addClosingVote(User user, ClosingDetail detail) {
        for (ClosingVote cv : closingVotes) {
            if (cv.getUser().equals(user)) return false; // Already voted
        }
        closingVotes.add(new ClosingVote(user, detail));
        // If closing votes reach threshold, close the question
        if (closingVotes.size() >= 3) {
            this.status = QuestionStatus.CLOSED;
            this.closingReason = detail;
        }
        return true;
    }

    public boolean addDeleteVote(User user) {
        if (deleteVotes.contains(user)) return false;
        deleteVotes.add(user);
        // If delete votes reach threshold, mark as flagged (or deleted)
        if (deleteVotes.size() >= 3) {
            this.status = QuestionStatus.FLAGGED;
        }
        return true;
    }

    public boolean close(User moderator, ClosingDetail detail) {
        if (moderator instanceof Moderator) {
            this.status = QuestionStatus.CLOSED;
            this.closingReason = detail;
            return true;
        }
        return false;
    }

    public boolean reopen(User moderator) {
        if (moderator instanceof Moderator) {
            if (this.status == QuestionStatus.CLOSED) {
                this.status = QuestionStatus.ACTIVE;
                this.closingReason = null;
                return true;
            }
        }
        return false;
    }

    public boolean delete(User moderator) {
        this.status = QuestionStatus.FLAGGED;
        return true;
    }

    public boolean restore(User moderator) {
        if(moderator instanceof Moderator){
            if (this.status == QuestionStatus.FLAGGED) {
                this.status = QuestionStatus.ACTIVE;
                return true;
            }
        }
        return false;
    }

    public boolean acceptAnswer(Answer answer, User user) {
        if (this.postedBy.equals(user) && answers.contains(answer)) {
            this.acceptedAnswer = answer;
            answer.setAccepted(true);
            user.notify(new Notification("Your answer was accepted!"));
            return true;
        }
        return false;
    }

    public void incrementViewCount() {
        viewCount++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public QuestionStatus getStatus() {
        return status;
    }

    public void setStatus(QuestionStatus status) {
        this.status = status;
    }

    public ClosingDetail getClosingReason() {
        return closingReason;
    }

    public void setClosingReason(ClosingDetail closingReason) {
        this.closingReason = closingReason;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public void setBounty(Bounty bounty) {
        this.bounty = bounty;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<ClosingVote> getClosingVotes() {
        return closingVotes;
    }

    public void setClosingVotes(List<ClosingVote> closingVotes) {
        this.closingVotes = closingVotes;
    }

    public List<User> getDeleteVotes() {
        return deleteVotes;
    }

    public void setDeleteVotes(List<User> deleteVotes) {
        this.deleteVotes = deleteVotes;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }
}
