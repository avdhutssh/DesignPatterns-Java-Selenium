package com.eventbroker;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        EventBroker broker = new EventBroker();

        // Register subscribers for String and Integer event types
        broker.registerSubscriber(String.class, new StringSubscriber());
        broker.registerSubscriber(Integer.class, new IntegerSubscriber());

        // Set custom headers for the events
        Map<String, String> headers = new HashMap<>();
        headers.put("Event-Type", "TestEvent");
        headers.put("Origin", "MainApp");

        // Publish a String event with metadata
        Event<String> stringEvent = new Event<>(
                LocalDateTime.now(),
                3000L,  // timeout in milliseconds
                1,      // priority level
                "Publisher1",
                "Hello Event!",
                headers
        );

        // Publish an Integer event with metadata
        Event<Integer> integerEvent = new Event<>(
                LocalDateTime.now(),
                5000L,
                2,
                "Publisher2",
                42,
                headers
        );

        // Publish events to the broker
        broker.publishEvent(stringEvent);
        broker.publishEvent(integerEvent);

        // Shutdown broker's executor service
        broker.shutdown();
    }
}
