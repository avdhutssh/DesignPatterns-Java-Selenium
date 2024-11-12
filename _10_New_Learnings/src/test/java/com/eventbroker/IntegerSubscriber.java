package com.eventbroker;

public class IntegerSubscriber implements Subscriber<Integer> {
    @Override
    public void onEvent(Event<Integer> event) {
        System.out.println("Received Integer event:");
        System.out.println("  Payload: " + event.getPayload());
        System.out.println("  Timestamp: " + event.getTimestamp());
        System.out.println("  Timeout: " + event.getTimeout());
        System.out.println("  Priority: " + event.getPriority());
        System.out.println("  Sender: " + event.getSender());
        System.out.println("  Custom Headers: " + event.getCustomHeaders());
    }
}