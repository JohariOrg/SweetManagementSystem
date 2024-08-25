package com.sweetmanagementsystem.admin;

import java.util.ArrayList;
import java.util.List;

public class FeedbackService {

    private List<String> feedbackList;

    public FeedbackService() {
        feedbackList = new ArrayList<>();
    }

    // Method to add feedback
    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
    }

    // Method to retrieve all feedback
    public List<String> getAllFeedback() {
        return feedbackList;
    }

    // Method to remove feedback
    public boolean removeFeedback(String feedback) {
        return feedbackList.remove(feedback);
    }
}
