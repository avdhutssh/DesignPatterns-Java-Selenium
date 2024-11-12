package com.eventbroker;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        EventBroker broker = new EventBroker();

        // Register a subscriber for String type events
        broker.registerSubscriber(String.class, event -> {
            System.out.println("Received string event: " + event.getPayload());
        });

        // Register a subscriber for Integer type events
        broker.registerSubscriber(Integer.class, event -> {
            System.out.println("Received integer event: " + event.getPayload());
        });

        // Publish events
        Map<String, String> headers = new HashMap<>();
        headers.put("ExampleHeader", "HeaderValue");

        Event<String> stringEvent = new Event<>(
                LocalDateTime.now(),
                null,
                1,
                "Sender1",
                "Hello Event!",
                headers
        );

        Event<Integer> integerEvent = new Event<>(
                LocalDateTime.now(),
                null,
                2,
                "Sender2",
                42,
                headers
        );

        broker.publishEvent(stringEvent);
        broker.publishEvent(integerEvent);

        broker.shutdown();
    }
}
