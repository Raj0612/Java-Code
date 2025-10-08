package Educative.Facebook.features;

import Educative.Facebook.enums.FriendInviteStatus;
import Educative.Facebook.accounts.User;

import java.time.LocalDate;

public class FriendRequest {
    private User recipient;
    private User sender;
    private FriendInviteStatus status;
    private LocalDate requestSent;
    private LocalDate requestStatusModified;

    public FriendRequest(User recipient, User sender, FriendInviteStatus status, LocalDate requestSent, LocalDate requestStatusModified) {
        this.recipient = recipient;
        this.sender = sender;
        this.status = status;
        this.requestSent = requestSent;
        this.requestStatusModified = requestStatusModified;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public FriendInviteStatus getStatus() {
        return status;
    }

    public void setStatus(FriendInviteStatus status) {
        this.status = status;
    }

    public LocalDate getRequestSent() {
        return requestSent;
    }

    public void setRequestSent(LocalDate requestSent) {
        this.requestSent = requestSent;
    }

    public LocalDate getRequestStatusModified() {
        return requestStatusModified;
    }

    public void setRequestStatusModified(LocalDate requestStatusModified) {
        this.requestStatusModified = requestStatusModified;
    }

    public boolean acceptRequest(User user) {
        this.status = FriendInviteStatus.ACCEPTED;
        this.requestStatusModified = LocalDate.now();
        user.getProfile().getFriends().add(this.sender);
        this.sender.getProfile().getFriends().add(user);
        return true;
    }

    public boolean rejectRequest(User user) {
        this.status = FriendInviteStatus.REJECTED;
        this.requestStatusModified =LocalDate.now();
        return true;
    }

}
