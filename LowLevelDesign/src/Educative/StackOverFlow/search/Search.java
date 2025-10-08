package Educative.StackOverFlow.search;

import Educative.StackOverFlow.posts.Question;

import java.util.List;

public interface Search {
    List<Question> searchByTags(String tagName);
    List<Question> searchByUsers(String username);
    List<Question> searchByWords(String word);
}
