package com.sweetmanagementsystem.management;

import java.util.HashMap;
import java.util.Map;

public class UserManagementSystem {

    // In-memory storage of users (username as key, User object as value)
    private static Map<String, User> users = new HashMap<>();

    // Method to add a new user
    public static void addUser(User user) {
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);
            System.out.println("User " + user.getUsername() + " added successfully.");
        } else {
            System.out.println("User " + user.getUsername() + " already exists.");
        }
    }

    // Method to retrieve a user by username
    public static User getUser(String username) {
        return users.get(username);
    }

    // Method to check if a user exists
    public static boolean userExists(String username) {
        return users.containsKey(username);
    }

    // For testing, print all users
    public static void printAllUsers() {
        System.out.println("Users in the system:");
        for (String username : users.keySet()) {
            System.out.println(username);
        }
    }
}
