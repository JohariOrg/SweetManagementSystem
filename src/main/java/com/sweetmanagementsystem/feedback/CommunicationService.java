package com.sweetmanagementsystem.feedback;

import java.util.ArrayList;
import java.util.List;

public class CommunicationService {

    private List<Feedback> feedbackList;

    public CommunicationService() {
        feedbackList = new ArrayList<>();
    }

    // Allow a beneficiary to leave feedback
    public void leaveFeedback(String username, String message) {
        Feedback feedback = new Feedback(username, message);
        feedbackList.add(feedback);
    }

    // View all feedback for store owners and suppliers
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    // Communicate with store owners or suppliers
    public void sendMessage(String sender, String receiver, String message) {
        System.out.println(sender + " sent a message to " + receiver + ": " + message);
    }
}
