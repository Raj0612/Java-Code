package Educative.StackOverFlow1.services;

import Educative.StackOverFlow1.accounts.Account;
import Educative.StackOverFlow1.accounts.User;
import Educative.StackOverFlow1.enums.Role;

import java.util.*;

public class AccountService {

    private final Map<String, User> usersByUsername = new HashMap<>();

    public User register(String username, String password, String email, Set<Role> roles) {
        if (usersByUsername.containsKey(username))
                throw new IllegalArgumentException("username exists");
        Account acc = new Account(username, password, email, roles);
        User user = new User(acc);
        usersByUsername.put(username, user);
        return user;
    }

    public User login(String username, String password) {
        User u = usersByUsername.get(username);
        if (u == null) return null;
        if (!u.getAccount().checkPassword(password))
            return null;
        u.getAccount().touchLastLogin();
        return u;
    }

    public User findByUsername(String username) {
        return usersByUsername.get(username);
    }
}
