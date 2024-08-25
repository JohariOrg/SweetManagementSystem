package com.sweetmanagementsystem.communication;

import java.util.ArrayList;
import java.util.List;

public class MessagingService {

    private List<Message> messages;

    public MessagingService() {
        messages = new ArrayList<>();
    }

    // Send a message
    public void sendMessage(String sender, String receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messages.add(message);
    }

    // Retrieve messages sent to a specific receiver
    public List<Message> getMessagesForReceiver(String receiver) {
        List<Message> receiverMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getReceiver().equals(receiver)) {
                receiverMessages.add(message);
            }
        }
        return receiverMessages;
    }
}
