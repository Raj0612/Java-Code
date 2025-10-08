package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;
import Educative.Linkedin.enums.ConnectionInviteStatus;

import java.time.LocalDate;

public class ConnectionInvitation {
    private User sender;
    private User recipient;
    private LocalDate dateCreated;
    private ConnectionInviteStatus status;

    public ConnectionInvitation(User sender, User recipient, LocalDate dateCreated) {
        this.sender = sender;
        this.recipient = recipient;
        this.dateCreated = dateCreated;
        this.status = ConnectionInviteStatus.PENDING;
    }

    public boolean acceptConnection() {
        this.status = ConnectionInviteStatus.ACCEPTED;
        sender.getConnections().add(recipient);
        recipient.getConnections().add(sender);
        return true;
    }

    public boolean rejectConnection() {
        this.status = ConnectionInviteStatus.IGNORED;
        return true;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ConnectionInviteStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectionInviteStatus status) {
        this.status = status;
    }
}
