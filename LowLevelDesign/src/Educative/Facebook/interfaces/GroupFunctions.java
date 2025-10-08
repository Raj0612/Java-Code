package Educative.Facebook.interfaces;

import Educative.Facebook.accounts.User;

//Implemented by Group
public interface GroupFunctions {
    boolean addUser(User user);
    boolean deleteUser(User user);
    boolean notifyUser(User user);
}
