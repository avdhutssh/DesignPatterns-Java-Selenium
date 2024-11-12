package com.eventbroker;

public class StringSubscriber implements Subscriber<String> {
    @Override
    public void onEvent(Event<String> event) {
        System.out.println("Received String event:");
        System.out.println("  Payload: " + event.getPayload());
        System.out.println("  Timestamp: " + event.getTimestamp());
        System.out.println("  Timeout: " + event.getTimeout());
        System.out.println("  Priority: " + event.getPriority());
        System.out.println("  Sender: " + event.getSender());
        System.out.println("  Custom Headers: " + event.getCustomHeaders());
        System.out.println();
    }
}
