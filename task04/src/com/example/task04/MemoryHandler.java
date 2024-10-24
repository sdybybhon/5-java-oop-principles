package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {
    private final ArrayList<String> messages = new ArrayList<>();
    private final MessageHandler proxyHandler;
    private final int messageLimit;

    public MemoryHandler(MessageHandler proxyHandler, int messageLimit) {
        this.proxyHandler = proxyHandler;
        this.messageLimit = messageLimit;
    }

    @Override
    public void handleMessage(String message) {
        messages.add(message);
        if (messages.size() >= messageLimit) {
            flush();
        }
    }

    public void flush() {
        for (String msg : messages) {
            proxyHandler.handleMessage(msg);
        }
        messages.clear();
    }
}

