package Educative.Facebook.interfaces;

import Educative.Facebook.features.Comment;
import Educative.Facebook.features.Post;

public interface CommentFunctionsByUser {
    Comment createComment(Post post, String content);
    void likeComment(Comment comment);
}
