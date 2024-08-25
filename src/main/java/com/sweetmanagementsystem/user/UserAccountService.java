package com.sweetmanagementsystem.user;

import java.util.HashMap;
import java.util.Map;

public class UserAccountService {

    private Map<String, UserAccount> userAccounts;

    public UserAccountService() {
        userAccounts = new HashMap<>();
    }

    // Register a new user
    public void registerUser(UserAccount userAccount) {
        userAccounts.put(userAccount.getUsername(), userAccount);
    }

    // Login a user
    public boolean loginUser(String username, String password) {
        UserAccount userAccount = userAccounts.get(username);
        return userAccount != null && userAccount.getPassword().equals(password);
    }

    // Retrieve a user account
    public UserAccount getUserAccount(String username) {
        return userAccounts.get(username);
    }
}
