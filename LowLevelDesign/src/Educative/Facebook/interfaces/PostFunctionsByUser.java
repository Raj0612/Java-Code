package Educative.Facebook.interfaces;

import Educative.Facebook.features.Post;

public interface PostFunctionsByUser {
    Post createPost(String content);
    Post sharePost(Post post);
    void commentOnPost(Post post);
    void likePost(Post post);
}
