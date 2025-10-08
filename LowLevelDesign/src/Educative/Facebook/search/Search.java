package Educative.Facebook.search;

import Educative.Facebook.features.Page;
import Educative.Facebook.features.Group;
import Educative.Facebook.accounts.User;
import Educative.Facebook.features.Post;

import java.util.List;

public interface Search {
    List<User> searchUsers(String name);
    List<Group> searchGroups(String name);
    List<Page> searchPages(String name);
    List<Post> searchPosts(String keywords);
    Group searchGroupsById(int groupId);
    User searchUserById(int userId);
    void removeGroup(Group group);
}
