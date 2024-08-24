package com.sweetmanagementsystem.account;

import java.util.HashMap;
import java.util.Map;

public class AccountManagementService {

    private Map<String, Account> accounts;

    public AccountManagementService() {
        accounts = new HashMap<>();
    }

    // Add a new account
    public void addAccount(Account account) {
        accounts.put(account.getUsername(), account);
    }

    // Update business information (name and contact email)
    public boolean updateAccountInfo(String username, String newBusinessName, String newContactEmail) {
        Account account = accounts.get(username);
        if (account != null) {
            account.setBusinessName(newBusinessName);
            account.setContactEmail(newContactEmail);
            return true;
        }
        return false;
    }

    // Retrieve account by username
    public Account getAccount(String username) {
        return accounts.get(username);
    }

    // Retrieve all accounts
    public Map<String, Account> getAllAccounts() {
        return accounts;
    }
}
