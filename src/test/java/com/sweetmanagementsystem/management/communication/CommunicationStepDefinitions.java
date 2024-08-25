package com.sweetmanagementsystem.management.communication;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.sweetmanagementsystem.communication.Message;
import com.sweetmanagementsystem.communication.MessagingService;
import com.sweetmanagementsystem.communication.NotificationService;

public class CommunicationStepDefinitions {

    private MessagingService messagingService;
    private NotificationService notificationService;

    @Given("the store owner is logged in for communication")
    public void the_store_owner_is_logged_in_for_communication() {
        messagingService = new MessagingService();
    }

    @When("the store owner sends a message to the supplier")
    public void the_store_owner_sends_a_message_to_the_supplier() {
        messagingService.sendMessage("StoreOwner", "Supplier", "Need more raw materials.");
    }

    @Then("the supplier should receive the message")
    public void the_supplier_should_receive_the_message() {
        List<Message> supplierMessages = messagingService.getMessagesForReceiver("Supplier");
        assertNotNull(supplierMessages);
        assertTrue(supplierMessages.size() > 0);
        for (Message message : supplierMessages) {
            System.out.println("Supplier received message: " + message.getContent());
        }
    }

    @Given("the store owner is logged in for notifications")
    public void the_store_owner_is_logged_in_for_notifications() {
        notificationService = new NotificationService();
    }

    @When("a notification is sent")
    public void a_notification_is_sent() {
        notificationService.sendNotification("Special request: Need a new batch of cakes.");
    }

    @Then("the store owner should receive the notification")
    public void the_store_owner_should_receive_the_notification() {
        List<String> notifications = notificationService.getAllNotifications();
        assertNotNull(notifications);
        assertTrue(notifications.size() > 0);
        notifications.forEach(System.out::println);
    }
}
