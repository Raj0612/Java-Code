package Educative.Facebook.interfaces;

import Educative.Facebook.features.Group;

public interface GroupFunctionsByUser {
    Group createGroup(String name);
    void joinGroup(Group group);
    void leaveGroup(Group group);
    void sendGroupInvite(Group group);
}
