package com.sweetmanagementsystem.feedback;

public class Feedback {

    private String username;
    private String message;

    public Feedback(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
