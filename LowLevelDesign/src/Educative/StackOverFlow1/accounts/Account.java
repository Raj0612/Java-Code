package Educative.StackOverFlow1.accounts;

import Educative.StackOverFlow1.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

public class Account {
    private final String accountId;
    private final String username;
    private String passwordHash;
    private final String email;
    private final Set<Role> roles;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    public Account(String username, String passwordPlain, String email, Set<Role> roles) {
        this.accountId = UUID.randomUUID().toString();
        this.username = username;
        this.passwordHash = hash(passwordPlain);
        this.email = email;
        this.roles = new HashSet<>(roles);
        if (this.roles.isEmpty()) this.roles.add(Role.USER);
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    public boolean checkPassword(String plain) {
        return Objects.equals(hash(plain), passwordHash);
    }

    public boolean resetPassword(String oldPlain, String newPlain) {
        if (!checkPassword(oldPlain)) return false;
        this.passwordHash = hash(newPlain);
        return true;
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public String getUsername() {
        return username;
    }

    public String getAccountId() {
        return accountId;
    }

    public void touchLastLogin() {
        this.lastLoginAt = LocalDateTime.now();
    }

    private static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest)
                sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
