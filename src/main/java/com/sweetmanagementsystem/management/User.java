package com.sweetmanagementsystem.management;

public class User {
    private String username;
    private String password;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    // Universal login method for all users
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.loggedIn = true;
            return true;
        }
        return false;
    }
}
