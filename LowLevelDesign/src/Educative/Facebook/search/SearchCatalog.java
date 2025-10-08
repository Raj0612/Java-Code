package Educative.Facebook.search;

import Educative.Facebook.features.Page;
import Educative.Facebook.features.Group;
import Educative.Facebook.accounts.User;
import Educative.Facebook.features.Post;

import java.util.*;

public class SearchCatalog implements Search {
    private static SearchCatalog instance = null;
    private HashMap<String, List<User>> userNames = new HashMap<>();
    private HashMap<String, List<Group>> groupNames = new HashMap<>();
    private HashMap<String, List<Page>> pageTitles = new HashMap<>();
    private HashMap<String, List<Post>> posts = new HashMap<>();
    private Map<Integer, Group> groupIdMap = new HashMap<>();
    private Map<Integer, User> userIdMap = new HashMap<>();

    private SearchCatalog() {}
    public static SearchCatalog getInstance() {
        if (instance == null) {
            synchronized (SearchCatalog.class) {
                if (instance == null) instance = new SearchCatalog();
            }
        }
        return instance;
    }

    public boolean addNewUser(User user) {
        userNames.putIfAbsent(user.getName(), new ArrayList<>());
        userIdMap.put(user.getUserId(), user);
        return userNames.get(user.getName()).add(user);
    }
    public boolean addNewGroup(Group group) {
        groupNames.putIfAbsent(group.getName(), new ArrayList<>());
        groupIdMap.put(group.getGroupId(), group); // <-- Add this line
        return groupNames.get(group.getName()).add(group);
    }
    public boolean addNewPage(Page page) {
        return pageTitles.computeIfAbsent(page.getName(), k -> new ArrayList<>()).add(page);
        //pageTitles.putIfAbsent(page.getName(), new ArrayList<>());
        //return pageTitles.get(page.getName()).add(page);
    }
    public boolean addNewPost(Post post) {
        posts.putIfAbsent(post.getContent(), new ArrayList<>());
        return posts.get(post.getContent()).add(post);
    }

    @Override
    public List<User> searchUsers(String name) {
        return userNames.getOrDefault(name, new ArrayList<>());
    }
    @Override
    public List<Group> searchGroups(String name) {
        return groupNames.getOrDefault(name, new ArrayList<>());
    }
    @Override
    public List<Page> searchPages(String name) {
        return pageTitles.getOrDefault(name, new ArrayList<>());
    }
    @Override
    public List<Post> searchPosts(String keywords) {
        return posts.getOrDefault(keywords, new ArrayList<>());
    }
    @Override
    public Group searchGroupsById(int groupId) {
        return groupIdMap.get(groupId);
    }
    @Override
    public User searchUserById(int userId) {
        return userIdMap.get(userId);
    }

    @Override
    public void removeGroup(Group group) {
        if (group == null) return;

        // Remove from ID map
        groupIdMap.remove(group.getGroupId());

        // Remove from name map
        List<Group> groupsWithName = groupNames.get(group.getName());
        if (groupsWithName != null) {
            groupsWithName.remove(group);
            // If list is empty after removal, remove the key
            if (groupsWithName.isEmpty()) {
                groupNames.remove(group.getName());
            }
        }
    }
}
