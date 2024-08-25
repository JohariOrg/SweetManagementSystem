package com.sweetmanagementsystem.management;

public class Admin extends User {
    
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addUser(User user) {
        UserManagementSystem.addUser(user);
    }

    public User getUser(String username) {
        return UserManagementSystem.getUser(username);
    }
}
