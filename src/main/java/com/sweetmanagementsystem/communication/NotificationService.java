package com.sweetmanagementsystem.communication;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<String> notifications;

    public NotificationService() {
        notifications = new ArrayList<>();
    }

    // Send a notification
    public void sendNotification(String notification) {
        notifications.add(notification);
    }

    // Retrieve all notifications
    public List<String> getAllNotifications() {
        return notifications;
    }
}
