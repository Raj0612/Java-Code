package Educative.StackOverFlow.accounts;

import java.util.UUID;

public class Guest {

    public Account registerAccount(String username, String password, String name, String email, String phone) {
        // Registration logic (stub)
        return new Account(UUID.randomUUID().toString(), username, password, name, email, phone);
    }
}
