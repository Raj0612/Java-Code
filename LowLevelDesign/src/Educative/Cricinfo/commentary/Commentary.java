package Educative.Cricinfo.commentary;

import java.time.LocalDateTime;

public class Commentary {
    private final String text;
    private final LocalDateTime createdAt;
    private final Commentator commentator;

    public Commentary(String text, Commentator commentator) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
        this.commentator = commentator;
    }

    public String getText() { return text; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Commentator getCommentator() { return commentator; }
}
