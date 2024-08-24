package com.sweetmanagementsystem.management.feedback;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.sweetmanagementsystem.feedback.CommunicationService;
import com.sweetmanagementsystem.feedback.Feedback;

public class CommunicationStepDefinitions {

    private CommunicationService communicationService;
    private List<Feedback> feedbackList;

    @Given("the user is logged in for communication")
    public void the_user_is_logged_in_for_communication() { // Rename step
        communicationService = new CommunicationService();
    }

    @When("the user sends a message to the store owner")
    public void the_user_sends_a_message_to_the_store_owner() {
        communicationService.sendMessage("user123", "storeOwner", "Hello, I need help with my order.");
    }

    @Then("the message should be sent successfully")
    public void the_message_should_be_sent_successfully() {
        System.out.println("Message sent successfully.");
    }

    @Given("the user has purchased a product for feedback")
    public void the_user_has_purchased_a_product_for_feedback() { // Rename step
        communicationService = new CommunicationService();
    }

    @When("the user leaves feedback for the product")
    public void the_user_leaves_feedback_for_the_product() {
        communicationService.leaveFeedback("user123", "Great product!");
    }

    @Then("the feedback should be recorded successfully")
    public void the_feedback_should_be_recorded_successfully() {
        feedbackList = communicationService.getAllFeedback();
        assertNotNull(feedbackList);
        System.out.println("Feedback recorded: " + feedbackList.get(0).getMessage());
    }
}