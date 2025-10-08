package Educative.StackOverFlow.search;

import Educative.StackOverFlow.posts.Question;
import Educative.StackOverFlow.additionalFeatures.Tag;

import java.util.*;

public class SearchCatalog implements Search {
    private static SearchCatalog instance;
    private Map<Tag, List<Question>> questionsUsingTags;
    private Map<String, List<Question>> questionsUsingUsers;
    private Map<String, List<Question>> questionsUsingWords;

    private SearchCatalog() {
        questionsUsingTags = new HashMap<>();
        questionsUsingUsers = new HashMap<>();
        questionsUsingWords = new HashMap<>();
    }

    public static SearchCatalog getInstance() {
        if (instance == null) instance = new SearchCatalog();
        return instance;
    }

    public List<Question> searchByTags(String tagName) {
        for (Tag tag : questionsUsingTags.keySet()) {
            if (tag.getName().equalsIgnoreCase(tagName)) {
                return questionsUsingTags.get(tag);
            }
        }
        return new ArrayList<>();
    }

    public List<Question> searchByUsers(String username) {
        return questionsUsingUsers.getOrDefault(username.toLowerCase(), new ArrayList<>());
    }

    public List<Question> searchByWords(String word) {
        return questionsUsingWords.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public void indexQuestion(Question question) {
        // By tag
        for (Tag tag : question.getTags()) {
            questionsUsingTags.computeIfAbsent(tag, k -> new ArrayList<>()).add(question);
        }
        // By user
        String username = question.getPostedBy().getAccount().getUsername().toLowerCase();
        questionsUsingUsers.computeIfAbsent(username, k -> new ArrayList<>()).add(question);

        // By words in title and content
        Set<String> words = extractWords(question.getTitle() + " " + question.getContent());
        for (String word : words) {
            questionsUsingWords.computeIfAbsent(word, k -> new ArrayList<>()).add(question);
        }
    }

    public void removeQuestion(Question question) {
        // Remove from tag map
        for (Tag tag : question.getTags()) {
            List<Question> list = questionsUsingTags.get(tag);
            if (list != null) {
                list.remove(question);
                if (list.isEmpty()) {
                    questionsUsingTags.remove(tag);
                }
            }
        }

        // Remove from user map
        String username = question.getPostedBy().getAccount().getUsername().toLowerCase();
        List<Question> userList = questionsUsingUsers.get(username);
        if (userList != null) {
            userList.remove(question);
            if (userList.isEmpty()) {
                questionsUsingUsers.remove(username);
            }
        }

        // Remove from word map (assuming you index words from title/content)
        Set<String> words = extractWords(question.getTitle() + " " + question.getContent());
        for (String word : words) {
            List<Question> wordList = questionsUsingWords.get(word.toLowerCase());
            if (wordList != null) {
                wordList.remove(question);
                if (wordList.isEmpty()) {
                    questionsUsingWords.remove(word.toLowerCase());
                }
            }
        }
    }

    // Utility to extract words (simple whitespace split, can be improved)
    private Set<String> extractWords(String text) {
        Set<String> result = new HashSet<>();
        if (text != null) {
            for (String word : text.split("\\s+")) {
                if (!word.isEmpty()) {
                    result.add(word.replaceAll("\\W+", "").toLowerCase());
                }
            }
        }
        return result;
    }

    // Methods to add questions to catalog omitted for brevity
}
